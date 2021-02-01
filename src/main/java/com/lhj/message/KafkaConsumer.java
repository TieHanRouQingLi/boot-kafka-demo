package com.lhj.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.lhj.config.KafkaConfig.KAFKA_LISTENER_CONTAINER_FACTORY;

/**
 * @author lhj
 * @Classname KafkaConsumer
 * @Description
 * @Date 2021/2/1 14:05
 * @Version V1.0
 */

@Component
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String TEST_TOPIC = "DEMO_TOPIC";


    @KafkaListener(topics = {TEST_TOPIC}, containerFactory = KAFKA_LISTENER_CONTAINER_FACTORY)
    public void demoTopicListener(ConsumerRecord<String, String> record) throws Exception {
        String msg = record.value();
        logger.info("监听消息体为：" + msg);
    }

}
