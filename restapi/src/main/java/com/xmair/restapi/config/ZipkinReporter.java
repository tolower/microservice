package com.xmair.restapi.config;

import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Reporter;
import zipkin2.reporter.Sender;

import java.util.concurrent.TimeUnit;

@Configuration
public class ZipkinReporter {

    @Bean
    public Reporter<Span> reporter(
            SpanMetricReporter spanMetricReporter,
            ZipkinProperties zipkin,
            Sender sender
    ) {
        final AsyncReporter<Span> reporter = AsyncReporter.builder(sender)
                .queuedMaxSpans(50)
          //      .messageMaxBytes(5000)
           //     .messageTimeout(1000, TimeUnit.MILLISECONDS)

                .build(zipkin.getEncoder());
        return reporter;
    }
}
