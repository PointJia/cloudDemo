package com.dian.kafka.provider;

import com.dian.kafka.common.util.TimeUtile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@EnableScheduling
public class KafkaProvider {

    Logger logger = LoggerFactory.getLogger(KafkaProvider.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "1/10 * * * * *")
    public void sendMsgI(){
        sendMsg(0);
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void sendMsgT(){
        sendMsg(1);
    }

    @Scheduled(cron = "2/10 * * * * *")
    public void sendMsgF(){
        sendMsg(2);
    }

    void sendMsg(Integer partition){
        String now = TimeUtile.initNow();
        String msg = "send Msg --- " + now;
        kafkaTemplate.send("test",partition,"justOne",msg);

//        logger.info("result : {}" ,test);
    }





}
