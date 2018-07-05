package com.xmair.restapi;

import com.xmair.core.configuration.kafka.KafkaAppender;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(exclude = {
		WebServicesAutoConfiguration.class,
		RedisAutoConfiguration.class,
		RabbitAutoConfiguration.class,
		SessionAutoConfiguration.class,
		SocialWebAutoConfiguration.class,
		ThymeleafAutoConfiguration.class,
		SecurityAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
        WebSocketAutoConfiguration.class,
        ActiveMQAutoConfiguration.class,
        ArtemisAutoConfiguration.class,
        EmbeddedLdapAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})

//@MapperScan("com.xmair.core.mapper")
@EnableDiscoveryClient
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnableRetry
@EnableAspectJAutoProxy
@EnableAsync

public class RestapiApplication {



	public static void main(String[] args) {

		/*try {
			MDC.put("ip", InetAddress.getLocalHost().getHostAddress());
		}catch (UnknownHostException e){
			e.printStackTrace();
		}*/
		SpringApplication.run(RestapiApplication.class, args);


		KafkaAppender.applicationStatus=1;
	}

	




}
