package com.xmair.restapi.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.instrument.web.TraceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class ZipkinFilter  {

    @Bean
   public TraceFilter myTraceFilter(BeanFactory beanFactory, final Tracer tracer) {


        return new TraceFilter(beanFactory) {
            @Override
            protected void addResponseTags(HttpServletResponse response,
                                                     Throwable e) {
                // execute the default behaviour
                super.addResponseTags(response, e);
                // for readability we're returning trace id in a hex form
               // response.addHeader("ZIPKIN-TRACE-ID",  Span.idToHex(tracer.getCurrentSpan().getTraceId()));
                // we can also add some custom tags
                tracer.addTag("custom", "06645");
            }
        };
    }
}
