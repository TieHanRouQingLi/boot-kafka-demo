package com.lhj.controller;

import com.lhj.message.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhj
 * @Classname KafkaController
 * @Description
 * @Date 2021/2/1 14:17
 * @Version V1.0
 */

@RestController
@RequestMapping("/kafkaDemo")
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping("/sendMessage")
    public String testMessageSend(String name) {
        kafkaProducer.send("Hello Kafka Demo!");
        return "发送成功";
    }
}
