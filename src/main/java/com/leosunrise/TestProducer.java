package com.leosunrise;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @Description: The description of the file.
 * @Author: Dominic
 * @Date: 2017/2/10
 */
public class TestProducer {
    private final KafkaProducer<String, String> producer;
    private final String topic;
    private final Boolean isAsync;

    public TestProducer(String topic, Boolean isAsync) {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("metadata.fetch.timeout.ms", 6000);
        producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.isAsync = isAsync;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        TestProducer testProducer = new TestProducer(KafkaProperties.TOPIC, true);
        String messageNo;
        String messageStr;
        while(true){
            messageNo = "messageNo" + System.currentTimeMillis();
            messageStr = "msg:"+new Date();
            testProducer.producer.send(new ProducerRecord<String,String>(testProducer.topic, messageNo, messageStr)).get();
            System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
            Thread.sleep(1000);
         }
    }
}