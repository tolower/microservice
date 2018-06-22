package com.xmair.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@RibbonClients(defaultConfiguration =  FooConfiguration.class)
public class RibbonConfig  {


    @Bean
    public CustomConsulServerFilter serverListFilter() {
        
        CustomConsulServerFilter filter = new CustomConsulServerFilter();
        return filter;
    }



}
