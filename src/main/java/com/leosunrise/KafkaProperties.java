package com.leosunrise;

/**
 * @Description: The description of the file.
 * @Author: Dominic
 * @Date: 2017/2/15
 */
public class KafkaProperties {
    public static final String TOPIC = "kafka_test";
    public static final String KAFKA_SERVER_URL = "10.1.200.134";
    public static final int KAFKA_SERVER_PORT = 9092;
    public static final int KAFKA_PRODUCER_BUFFER_SIZE = 64 * 1024;
    public static final int CONNECTION_TIMEOUT = 100000;
    public static final String TOPIC2 = "topic2";
    public static final String TOPIC3 = "topic3";
    public static final String CLIENT_ID = "SimpleConsumerDemoClient";

    private KafkaProperties() {}
}
