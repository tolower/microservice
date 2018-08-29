package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


import java.util.Properties;

public class KafkaAppender extends AppenderBase<ILoggingEvent> {

    public   static  int applicationStatus=0;

    private String topic;
    private String zookeeperHost;
    private Producer<String, String> producer;
    private Formatter formatter;
    private String brokerList;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getZookeeperHost() {
        return zookeeperHost;
    }

    public void setZookeeperHost(String zookeeperHost) {
        this.zookeeperHost = zookeeperHost;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    @Override
    public void start() {
        if(this.formatter == null){
            this.formatter = new MessageFormatter();
        }
        super.start();
        Properties props = new Properties();
        props.put("bootstrap.servers", this.brokerList);
        props.put("producer.type","async");
        props.put("linger.ms","50");
        props.put("max.block.ms","0");
        props.put("acks", "all");
        props.put("retries", 1);
        props.put("batch.size", 400);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        this.producer = new KafkaProducer<String, String>(props);


    }

    @Override
    public void stop() {
        super.stop();
        this.producer.close();
    }
    @Override
    protected void append(ILoggingEvent event) {
        if(applicationStatus==0){
            return;
        }
        String payload = this.formatter.format(event);
        ProducerRecord<String, String> data = new ProducerRecord<String, String>(this.topic, payload);
        this.producer.send(data);
    }
}