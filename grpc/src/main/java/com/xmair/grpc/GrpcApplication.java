package com.xmair.grpc;

import io.grpc.Grpc;
import io.grpc.netty.GrpcHttp2ConnectionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.xmair.grpc")
@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		JmxAutoConfiguration.class,
		MultipartAutoConfiguration.class,
		SpringDataWebAutoConfiguration.class,
		WebSocketAutoConfiguration.class,
		ActiveMQAutoConfiguration.class,
		ArtemisAutoConfiguration.class,
		EmbeddedLdapAutoConfiguration.class,HibernateJpaAutoConfiguration.class
})
@MapperScan("com.xmair.core.mapper")
public class GrpcApplication{

	public static void main(String[] args) {

		SpringApplication.run(GrpcApplication.class, args);
	}



}
