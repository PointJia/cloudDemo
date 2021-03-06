package com.dian.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"test"},groupId="one")
    public void receiveMsg(String msg){
        logger.info("receiveMsg consume Msg : {} " , msg);
    }

    @KafkaListener(topics = {"test"},groupId="one")
    public void receiveMsgO(String msg){
        logger.info("receiveMsgO consume Msg : {} " , msg);
    }

    @KafkaListener(topics = {"test"},groupId="two")
    public void receiveMsgT(String msg){
        logger.info("receiveMsgT consume Msg : {} " , msg);
    }




}
