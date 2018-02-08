package com.xmair.common.oauthclient;

import com.xmair.common.oauthclient.config.OauthConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableConfigurationProperties({OauthConfig.class})
@ComponentScan(basePackages = "com.xmair.common.oauthclient")
public class OauthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthClientApplication.class, args);
	}
}
