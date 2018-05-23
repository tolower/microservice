package com.xmair.restapi.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import com.xmair.restapi.config.CustomConsulServerFilter;
import org.springframework.cloud.consul.discovery.ConsulRibbonClientConfiguration;
import org.springframework.cloud.consul.discovery.HealthServiceServerListFilter;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
//@RibbonClients(defaultConfiguration =  FooConfiguration.class)
public class RibbonConfig  {


    @Bean
    public CustomConsulServerFilter serverListFilter() {
        CustomConsulServerFilter filter = new CustomConsulServerFilter();
        return filter;
    }



}
