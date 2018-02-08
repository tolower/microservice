package com.xmair.common.oauthclient2;

import com.xmair.common.oauthclient2.config.OauthConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({OauthConfig.class})
@ComponentScan(basePackages = "com.xmair.common.oauthclient2")
public class OauthClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(OauthClient2Application.class, args);
	}
}
