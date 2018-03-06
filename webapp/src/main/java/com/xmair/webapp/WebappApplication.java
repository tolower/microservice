package com.xmair.webapp;

import com.xmair.core.configuration.ConfigBean;
import com.xmair.core.entity.framedb.TbEmpData;
import io.undertow.UndertowOptions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.xmair.webapp")
@EnableConfigurationProperties({ConfigBean.class})
@MapperScan("com.xmair.core.mapper")
public class WebappApplication {

	public static void main(String[] args) {




		SpringApplication.run(WebappApplication.class, args);
	}

	// 在@Configuration的类中添加@bean
	@Bean
	UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {

		UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();

		// 这里也可以做其他配置
		factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));

		return factory;
	}

}
