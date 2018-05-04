package com.xmair.restapi.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * resttemplate使用okhttp连接池
 * */
@Configuration
public class RestClientConfig {

    /**
     * 注入okhttp客户端工具类，全局唯一，共享连接池，线程安全
     */
    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        ConnectionPool pool = new ConnectionPool(5, 30, TimeUnit.MINUTES);

        builder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectionPool(pool)
                .addNetworkInterceptor(new OkHttpInterceptor())
                .retryOnConnectionFailure(true);
        return builder.build();
    }

    @Bean
    public ClientHttpRequestFactory OkHttp3Factory() {

        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(OkHttp3Factory());
    }


}
