package com.xmair.restapi.config;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.spring.webmvc.TracingHandlerInterceptor;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmair.core.configuration.ProtostuffHttpMessageConverter;
import com.xmair.core.util.DateConverter;
import com.xmair.restapi.apiversion.VersionHandlerMapping;

import okhttp3.OkHttpClient;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.util.AntPathMatcher;
import org.springframework.validation.Validator;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.kafka11.KafkaSender;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
@Import({TracingHandlerInterceptor.class})
@Configuration
@ComponentScan(basePackages = {"com.xmair.core.configuration"
        ,"com.xmair.core.util"
        ,"com.xmair.restapi"
        ,"com.xmair.core.service"})
public class WebConfig extends WebMvcConfigurationSupport {




    @Autowired
    private  ObjectMapper objectMapper;

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    public MappingJackson2HttpMessageConverter jsonConverter;


    @Autowired
    private TracingHandlerInterceptor serverZipkinInterceptor;

    @Primary
    @Bean
    public MappingJackson2HttpMessageConverter getCustomJacksonConverter(ObjectMapper objectMapper){
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        list.add(MediaType.APPLICATION_JSON);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serverZipkinInterceptor)
                .excludePathPatterns("/metrics/**")
                .excludePathPatterns("/v2/api-docs","/configuration/**","/swagger-resources/**");

        registry.addInterceptor(new PrometheusMetricsInterceptor()).addPathPatterns("/**");

       
    }





    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
                .getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer
                    .getConversionService();
            genericConversionService.addConverter(new DateConverter());
        }
    }

    /*
    *增加ajax跨域访问支持
    *
    */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedMethods("get","post")
                .allowedOrigins("*")
                .allowedHeaders("*");
       // super.addCorsMappings(registry);
    }



    //添加protobuf支持，需要client指定accept-type：application/x-protobuf
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.TEXT_PLAIN);
        list.add(MediaType.TEXT_HTML);
        list.add(MediaType.TEXT_MARKDOWN);
        stringConverter.setSupportedMediaTypes(list);
        MappingJackson2XmlHttpMessageConverter xmlConverter=new MappingJackson2XmlHttpMessageConverter();
        xmlConverter.setDefaultCharset(Charset.forName("utf-8"));
        List<MediaType> list2 = new ArrayList<MediaType>();
        list2.add(MediaType.APPLICATION_XML);
        xmlConverter.setSupportedMediaTypes(list2);
        converters.add(0,stringConverter);
        converters.add(0,xmlConverter);
        converters.add(0,new ProtostuffHttpMessageConverter());
        converters.add(0,getCustomJacksonConverter(objectMapper));
    }

    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new VersionHandlerMapping("v");
        handlerMapping.setOrder(0);

        handlerMapping.setInterceptors(getInterceptors());
        AntPathMatcher pathMatcher = new AntPathMatcher();
        pathMatcher.setCaseSensitive(false);
        handlerMapping.setPathMatcher(pathMatcher);
        return handlerMapping;
    }
    /*忽略url大小写*/
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {


        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }


    /**
     * 发现如果继承了WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。
     * 需要重新指定静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /*设置默认首页*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addRedirectViewController("/","/swagger-ui.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }






}