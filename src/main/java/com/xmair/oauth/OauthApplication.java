package com.xmair.oauth;

import com.xmair.oauth.configuration.ConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Song on 2017/2/15.
 * 项目启动入口，配置包根路径
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xmair.oauth")
@MapperScan("com.xmair.oauth.mapper")
@EnableConfigurationProperties({ConfigBean.class})
public class OauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
}
