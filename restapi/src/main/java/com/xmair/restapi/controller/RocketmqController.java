package com.xmair.restapi.controller;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping(value = "/rocketmq")
public class RocketmqController {
    @Autowired
    DefaultMQProducer producer;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void getUser(String id) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("push-consumer-group1");
        consumer.setNamesrvAddr("11.4.74.49:9876;11.4.74.48:9876");

        consumer.setInstanceName("ddd");

        consumer.setHeartbeatBrokerInterval(2000);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setConsumeMessageBatchMaxSize(1);

        consumer.subscribe("TopicTest", "*");
        consumer.setMessageModel(MessageModel.CLUSTERING);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {


                for (MessageExt ext : list) {
                    try {
                        System.out.println(new String(ext.getBody(), "UTF-8"));
                        System.out.println(ext.getStoreHost().toString());
                        System.out.println(ext.toString());

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();

        Thread.sleep(1203303);
    }


}
