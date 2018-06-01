package com.xmair.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan(basePackages = "com.xmair.core")
@MapperScan("com.xmair.core.mapper")
@SpringBootApplication
public class CoreApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
