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
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.*;

public class TransactionMQTest {
    @Autowired
    DefaultMQProducer producer;

    @Test
    public void testProduct() throws  Exception{
        TransactionListener transactionListener = new TransactionListenerImpl();
        //一般情况下，produergroup都是没什么卵用的，但是事务消息就有卵用，因为要回查
        TransactionMQProducer producer = new TransactionMQProducer("transactiontest");
        producer.setNamesrvAddr("11.4.74.45:9876;11.4.74.48:9876");
        producer.setSendLatencyFaultEnable(true);
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });



        producer.setInstanceName(InetAddress.getLocalHost().getHostAddress());
        producer.setExecutorService(executorService);
        producer.setTransactionListener(transactionListener);
        producer.start();


        String[] tags = new String[] {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            try {
                Message msg =
                        new Message("testtopic1", tags[i % tags.length], "KEY" + i,
                                ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.sendMessageInTransaction(msg, null);
                System.out.printf("%s%n", sendResult);

                Thread.sleep(10);
            } catch (MQClientException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 200 ; i++) {
            Thread.sleep(1000);
        }
        producer.shutdown();
    }

}
