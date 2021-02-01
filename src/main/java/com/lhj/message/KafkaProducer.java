package com.lhj.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author lhj
 * @Classname KafkaProducer
 * @Description
 * @Date 2021/2/1 14:13
 * @Version V1.0
 */

@Component
public class KafkaProducer {

    private static final String TEST_TOPIC_KEY = "DEMO_TOPIC_KEY";
    private static final String TEST_TOPIC = "DEMO_TOPIC";
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String, String>> send(String topic, String key, String json) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, json);
        logger.info("inner kafka send #topic=" + topic + "#key=" + key + "#json=" + json + "#推送成功===========");
        return result;
    }


    public void send(String message) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(TEST_TOPIC, TEST_TOPIC_KEY, message);
    }

}
