package com.xmair.core.configuration.kafka;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;



import java.util.Properties;

public class KafkaAppender extends AppenderBase<ILoggingEvent> {


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
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", this.brokerList);
        props.setProperty("producer.type","async");
        props.setProperty("linger.ms","50");
        //props.setProperty()
        ProducerConfig config = new ProducerConfig(props);


        this.producer = new Producer<String, String>(config);


    }

    @Override
    public void stop() {
        super.stop();
        this.producer.close();
    }
    @Override
    protected void append(ILoggingEvent event) {
        String payload = this.formatter.format(event);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>(this.topic, payload);
        this.producer.send(data);
    }
}