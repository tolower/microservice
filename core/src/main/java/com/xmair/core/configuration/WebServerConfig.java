package com.xmair.core.configuration;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

@Configuration
public class WebServerConfig {
    // 增加对http2的支持
    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {

        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

        // 这里也可以做其他配置
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)
        .setServerOption(UndertowOptions.MAX_CONCURRENT_REQUESTS_PER_CONNECTION,10000)
        .setServerOption(UndertowOptions.HTTP2_SETTINGS_INITIAL_WINDOW_SIZE,65535));

        return factory;
    }

}
