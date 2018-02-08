package com.xmair.common;

import com.xmair.common.configuration.ConfigBean;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Song on 2017/2/15.
 * 项目启动入口，配置包根路径
 */
@SpringBootApplication
@EnableAdminServer

@ComponentScan(basePackages = "com.xmair.common")
@MapperScan("com.xmair.common.mapper")
@EnableConfigurationProperties({ConfigBean.class})
public class OauthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(OauthApplication.class, args);
	}
}
