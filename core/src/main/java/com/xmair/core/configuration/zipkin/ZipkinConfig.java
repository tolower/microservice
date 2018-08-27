package com.xmair.core.configuration.zipkin;

import brave.SpanCustomizer;
import brave.Tracing;
import brave.context.slf4j.MDCCurrentTraceContext;
import brave.http.HttpAdapter;
import brave.http.HttpClientParser;
import brave.http.HttpServerParser;
import brave.http.HttpTracing;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.codec.Encoding;
import zipkin2.codec.SpanBytesEncoder;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.kafka11.KafkaSender;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
public class ZipkinConfig {

    @Autowired
    private ZipkinProperties zipkinProperties;

    @Bean
    KafkaSender sender() {
        Map<String, String> pro = new HashMap<>();
        pro.put("acks", "1");
        // pro.put("linger.ms","50");

        pro.put("retries", "1");
        // pro.put("compression.type","gzip");
        // pro.put("producer.type","async");
        return KafkaSender.newBuilder().overrides(pro)
                .bootstrapServers(zipkinProperties.getKafkaHosts())
                .topic(zipkinProperties.getTopic())

               // .encoding(Encoding.JSON)
                .build();
    }

    @Bean
    AsyncReporter<Span> spanReporter() {
        return AsyncReporter.builder(sender())
                .closeTimeout(500, TimeUnit.MILLISECONDS)
                .messageMaxBytes(200000)
                .queuedMaxSpans(500)
                .build();
    }

    @Bean
    Tracing tracing() {
        return Tracing.newBuilder()
                .localServiceName(zipkinProperties.getServiceName())
                .sampler(Sampler.ALWAYS_SAMPLE)
                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "user-name"))
                .currentTraceContext(MDCCurrentTraceContext.create()) // puts trace IDs into logs
                .spanReporter(spanReporter()).build();
    }


    @Bean
    HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.newBuilder(tracing)
                .clientParser(new HttpClientParser() {

                    @Override
                    protected <Req> String spanName(HttpAdapter<Req, ?> adapter, Req req) {
                        return adapter.url(req).toString();
                    }

                    @Override
                    public <Req> void request(HttpAdapter<Req, ?> adapter, Req req, SpanCustomizer customizer) {
                        customizer.name(spanName(adapter, req)); // default span name

                        customizer.tag("url", adapter.url(req)); // the whole url, not just the path
                        super.request(adapter, req, customizer);
                    }

                })
                .serverParser(new HttpServerParser() {
                    @Override
                    protected <Req> String spanName(HttpAdapter<Req, ?> adapter, Req req) {
                        return adapter.url(req).toString();
                    }

                    @Override
                    public <Req> void request(HttpAdapter<Req, ?> adapter, Req req, SpanCustomizer customizer) {
                        customizer.name(spanName(adapter, req)); // default span name
                        customizer.tag("url", adapter.url(req)); // the whole url, not just the path
                        super.request(adapter, req, customizer);
                    }
                })
                .build();
    }

}
