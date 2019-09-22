package com.dian.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

public class KafkaConsumer implements MessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Override
    public void onMessage(Object data) {

        logger.info("handle msg : {} " , data);


    }
}
