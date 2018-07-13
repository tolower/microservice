package com.xmair.restapi.controller;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rocketmq")
public class RocketmqController {
    @Autowired
    DefaultMQProducer producer;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public SendResult getUser(String id) throws  Exception{
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
        Message msg = new Message("testtopic",// topic
                "TagA",// tag
                "OrderID001"+id,// key
                ("Hello MetaQ").getBytes());// body
        Message ms1=new Message();
        ms1.setTopic("testtopic");
        ms1.setTags("TagB");

        SendResult sendResult = producer.send(msg);
        //务必打印key、sendResult
        System.out.println("key:"+"OrderID001"+",sendResult:"+sendResult);
        System.out.println();
        return  sendResult;
    }

}
