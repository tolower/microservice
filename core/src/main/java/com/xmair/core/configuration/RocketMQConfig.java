package com.xmair.core.configuration;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.function.Consumer;


@Configuration
@ConfigurationProperties(prefix = "spring.rocketmq.producer")
public class RocketMQConfig
{
    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Primary
    @Bean
    public DefaultMQProducer initMQProducer()  {
        DefaultMQProducer producer = new DefaultMQProducer(group);
        producer.setNamesrvAddr(nameServer);
        producer.setInstanceName(instanceName);
        producer.setCompressMsgBodyOverHowmuch(compressMsgBodyOverHowmuch);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setRetryAnotherBrokerWhenNotStoreOK(retryAnotherBrokerWhenNotStoreOk);
        producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendAsyncFailed);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);
        producer.setSendMsgTimeout(sendMsgTimeout);
        //设置到broker的心跳
        producer.setHeartbeatBrokerInterval(5000);
        //从namesrv获取topic路由
        producer.setPollNameServerInterval(3000);
        try {
            producer.start();
        }catch (MQClientException e)
        {
            logger.error("RocketMQ初始化异常",e);
            return  null;
        }

        return  producer;
    }





    @Bean
    public DefaultMQPushConsumer initMQPushConsumer()  {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(pushConsumerGroup);
        consumer.setNamesrvAddr(nameServer);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //从namesrv获取topic路由
        consumer.setPollNameServerInterval(3000);
        consumer.setHeartbeatBrokerInterval(5000);
        consumer.setConsumeMessageBatchMaxSize(10);

        return  consumer;
    }

    public String getPushConsumerGroup() {
        return pushConsumerGroup;
    }

    public void setPushConsumerGroup(String pushConsumerGroup) {
        this.pushConsumerGroup = pushConsumerGroup;
    }

    public String getPullConsumerGroup() {
        return pullConsumerGroup;
    }

    public void setPullConsumerGroup(String pullConsumerGroup) {
        this.pullConsumerGroup = pullConsumerGroup;
    }

    private  String pushConsumerGroup;
    private  String pullConsumerGroup;


    public boolean isRetryAnotherBrokerWhenNotStoreOk() {
        return retryAnotherBrokerWhenNotStoreOk;
    }

    private  String  nameServer;
    private  String  group;
    private  int  retryTimesWhenSendAsyncFailed;
    private  int  sendMsgTimeout;
    private  int  compressMsgBodyOverHowmuch;
    private  int  maxMessageSize;
    private  boolean  retryAnotherBrokerWhenNotStoreOk;
    private  String instanceName;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }



    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getRetryTimesWhenSendAsyncFailed() {
        return retryTimesWhenSendAsyncFailed;
    }

    public void setRetryTimesWhenSendAsyncFailed(int retryTimesWhenSendAsyncFailed) {
        this.retryTimesWhenSendAsyncFailed = retryTimesWhenSendAsyncFailed;
    }

    public int getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public int getCompressMsgBodyOverHowmuch() {
        return compressMsgBodyOverHowmuch;
    }

    public void setCompressMsgBodyOverHowmuch(int compressMsgBodyOverHowmuch) {
        this.compressMsgBodyOverHowmuch = compressMsgBodyOverHowmuch;
    }

    public int getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(int maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public boolean getRetryAnotherBrokerWhenNotStoreOk() {
        return retryAnotherBrokerWhenNotStoreOk;
    }

    public void setRetryAnotherBrokerWhenNotStoreOk(boolean retryAnotherBrokerWhenNotStoreOk) {
        this.retryAnotherBrokerWhenNotStoreOk = retryAnotherBrokerWhenNotStoreOk;
    }

    public int getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }

    private  int  retryTimesWhenSendFailed;




     /*    @Bean
    @Autowired
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory)
    {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());


        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
      //  template.setEnableTransactionSupport(true);
        template.setValueSerializer(new ProtoSerializer());
        //template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }*/

}
