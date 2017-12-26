package com.xmair.auth.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xmair.auth.authserver")
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
