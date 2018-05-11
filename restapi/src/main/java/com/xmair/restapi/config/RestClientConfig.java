package com.xmair.restapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.okhttp.RetryableOkHttpLoadBalancingClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
        ConnectionPool pool = new ConnectionPool(5, 20, TimeUnit.MINUTES);

        builder.connectTimeout(150, TimeUnit.MILLISECONDS)
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
    @Autowired
    private ObjectMapper objectMapper;

    @Primary
    @LoadBalanced
    @Bean
    public RestTemplate restTemplateLB() {

        RestTemplate restTemplate= new RestTemplate(OkHttp3Factory());
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(myDateFormat);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        return  restTemplate;
    }

    @Bean(name = "signleTemplate")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate= new RestTemplate(OkHttp3Factory());
        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(myDateFormat);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }


}
