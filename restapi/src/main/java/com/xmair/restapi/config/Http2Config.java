package com.xmair.restapi.config;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Http2Config {
    // 增加对http2的支持
    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {

        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        // 这里也可以做其他配置
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)
        .setServerOption(UndertowOptions.MAX_CONCURRENT_REQUESTS_PER_CONNECTION,1000)
                .setServerOption(UndertowOptions.HTTP2_SETTINGS_MAX_CONCURRENT_STREAMS,500)
        .setServerOption(UndertowOptions.HTTP2_SETTINGS_INITIAL_WINDOW_SIZE,6553500));

        return factory;
    }

}
