package com.xmair.oauth.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xmair.oauth.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
@Configuration
public class BaseConfigurerAdapter extends WebMvcConfigurerAdapter {
/*
* 添加拦截器
* */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/actuator/**")
                .excludePathPatterns("/sba/**")
                .excludePathPatterns("/v2/api-docs","/configuration/**","/swagger-resources/**");
        super.addInterceptors(registry);
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


    /**
     * 配置servlet处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {

        configurer.enable();
    }

    //添加protobuf支持，需要client指定accept-type：application/x-protobuf
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new ProtobufHttpMessageConverter());
    }
    /*设置默认首页*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/learn/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    
}
