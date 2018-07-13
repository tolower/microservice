package com.xmair.core;

import com.xmair.core.entity.framedb.TbEmpData;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ConfigurationProperties(prefix = "spring.rocketmq.producer")
public class RocketMQTest {

    @Autowired
    DefaultMQProducer producer;

    @Test
    public  void  testOneway() throws  Exception{
        for (int i = 0; i < 1000; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("testtopic1" /* Topic */,
                    "TagA" /* Tag */,"test"+i,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            producer.sendOneway(msg);

        }
    }
    @Test
    public void testProduct() throws  Exception{

        List<Message> messageList=new ArrayList<Message>();
        for(int i=0;i<1000;i++){
            Message msg = new Message("testtopic1",// topic
                    "TagA",// tag
                    "OrderID001",// key
                    ("Hello MetaQ").getBytes());// body
            messageList.add(msg);
        }


        SendResult  sendResult=   producer.send(messageList);


        Message msg = new Message("testtopic1",// topic
                "TagA",// tag
                "OrderID001",// key
                ("Hello MetaQ").getBytes());// body
        int orderid=12312;
         sendResult = producer.send(msg, new MessageQueueSelector() {
            //发送顺序消息，确保queue都是一样的
            @Override
            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                Integer id=(Integer) o;
                int index=id % list.size();
                return  list.get(index);
            }
        },orderid);
        //务必打印key、sendResult
        System.out.println("key:"+"OrderID001"+",sendResult:"+sendResult);
        System.out.println();
    }

    @Test
    public  void testConsumer() throws  Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("push-consumer-group1");
        consumer.setNamesrvAddr("11.4.74.49:9876;11.4.74.48:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setConsumeMessageBatchMaxSize(10);
        consumer.subscribe("testtopic1","TagA");
        consumer.setMessageModel(MessageModel.CLUSTERING);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {



                for(MessageExt ext : list){
                    try{
                        System.out.println(new String(ext.getBody(),"UTF-8"));
                        System.out.println(ext.getStoreHost().toString());
                        System.out.println(ext.toString());

                    }catch (UnsupportedEncodingException e){
                        e.printStackTrace();
                    }
                }
                return  ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();

Thread.sleep(13303);
    }

}
