package com.xmair.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.xmair.job")
public class JobApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobApplication.class, args);
	}
}
