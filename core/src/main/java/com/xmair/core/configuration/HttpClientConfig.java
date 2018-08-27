package com.xmair.core.configuration;

import brave.http.HttpTracing;
import brave.okhttp3.TracingInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * resttemplate使用okhttp连接池
 * */
@Configuration
public class HttpClientConfig {

    @Autowired
    HttpTracing  httpTracing;
    @Autowired
    public MappingJackson2HttpMessageConverter jsonConverter;

    /**
     * 注入okhttp客户端工具类，全局唯一，共享连接池，线程安全
     */
    @Bean
    public OkHttpClient okHttpClient() {
            //注意：使用http2.0协议，只有明确知道服务端支持H2C协议的时候才能使用。添加H2C支持，
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .protocols(Collections.singletonList(Protocol.H2_PRIOR_KNOWLEDGE));
        Dispatcher dispatcher=new Dispatcher(
                httpTracing.tracing().currentTraceContext()
                        .executorService(new Dispatcher().executorService())
        );
        //设置连接池大小
        dispatcher.setMaxRequests(1000);
        dispatcher.setMaxRequestsPerHost(200);
       ConnectionPool pool = new ConnectionPool(20, 30, TimeUnit.MINUTES);


        builder.connectTimeout(250, TimeUnit.MILLISECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectionPool(pool)

                .dispatcher(dispatcher)
               //链路监控埋点
                .addNetworkInterceptor(TracingInterceptor.create(httpTracing))
                //.addInterceptor(new OkHttpInterceptor())
                .retryOnConnectionFailure(false);
        return builder.build();
    }

    @Primary
    @Bean
    public ClientHttpRequestFactory OkHttp3Factory() {

        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }


    private AsyncClientHttpRequestFactory AsyncClientHttpRequestFactory() {

        return new OkHttp3ClientHttpRequestFactory(okHttpClient());
    }

    @LoadBalanced
    @Bean
    public AsyncRestTemplate asyncRestTemplate(){
        AsyncRestTemplate restTemplate=new AsyncRestTemplate(AsyncClientHttpRequestFactory());
        return  restTemplate;

    }
    @Autowired
    private ObjectMapper objectMapper;

    /*
    * 服务内部交互默认用protobuf格式，通过拦截器添加accept header字段
    * */
    @Primary
    @LoadBalanced
    @Bean
    public RestTemplate restTemplateLB() {

        RestTemplate restTemplate= new RestTemplate(OkHttp3Factory());
        // RestTemplate restTemplate= new RestTemplate(nettyFactory());

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());

        MappingJackson2XmlHttpMessageConverter xmlConverter=new MappingJackson2XmlHttpMessageConverter();
        xmlConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_XML);
        xmlConverter.setSupportedMediaTypes(list);

        messageConverters.add(0,xmlConverter);
        messageConverters.add(0,new ProtostuffHttpMessageConverter());
        messageConverters.add(0,jsonConverter);
        restTemplate.setMessageConverters(messageConverters);
        // 把自定义的ClientHttpRequestInterceptor添加到RestTemplate，可添加多个
        restTemplate.setInterceptors(Collections.singletonList(new ProtobufHeaderInterceptor()));

        return  restTemplate;
    }

    /*
   * 不通过ribbon调的服务，默认使用json，通过拦截器添加accept header字段
   * */
    @Bean(name = "signleTemplate")
    public RestTemplate restTemplate() {

        RestTemplate restTemplate= new RestTemplate(OkHttp3Factory());

        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list1 = new ArrayList<MediaType>();
        list1.add(MediaType.TEXT_PLAIN);
        stringConverter.setSupportedMediaTypes(list1);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(stringConverter);

        MappingJackson2XmlHttpMessageConverter xmlConverter=new MappingJackson2XmlHttpMessageConverter();
        xmlConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_XML);
        xmlConverter.setSupportedMediaTypes(list);

        messageConverters.add(0,xmlConverter);
        messageConverters.add(0,new ProtostuffHttpMessageConverter());
        messageConverters.add(0,jsonConverter);

        restTemplate.setMessageConverters(messageConverters);
// 把自定义的ClientHttpRequestInterceptor添加到RestTemplate，可添加多个
        restTemplate.setInterceptors(Collections.singletonList(new JsonHeaderInterceptor()));


        return restTemplate;
    }


}
