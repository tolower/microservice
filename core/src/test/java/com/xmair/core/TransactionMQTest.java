package com.xmair.core;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class TransactionMQTest {
    @Autowired
    DefaultMQProducer producer;

    @Test
    public void testProduct() throws  Exception{
        TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer("my-group");
        producer.setCheckThreadPoolMinSize(2);
        producer.setCheckThreadPoolMaxSize(2);
        producer.setCheckRequestHoldMax(2000);
        producer.setNamesrvAddr("11.4.74.44:9876;11.4.74.48:9876");
        producer.setTransactionCheckListener(transactionCheckListener);
        producer.start();

        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        TransactionExecuterImpl tranExecuter = new TransactionExecuterImpl();

            try {
                Message msg =
                        new Message("testtopic",tags[0], "KEY1",
                                ("tranc").getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.sendMessageInTransaction(msg, tranExecuter, null);
                System.out.printf("%s%n", sendResult);

                Thread.sleep(10);
            } catch (MQClientException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }



            Thread.sleep(30000);

        producer.shutdown();
    }
}
