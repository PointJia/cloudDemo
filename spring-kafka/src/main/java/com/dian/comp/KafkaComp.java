package com.dian.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@EnableScheduling
public class KafkaComp {

    Logger logger = Logger.getLogger(KafkaComp.class.getName());

    @Autowired
    KafkaTemplate template;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendMsg(){
        try {
            String m = "sendMsg" + new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
//            org.springframework.util.concurrent.ListenableFuture<SendResult<String, String>> send = template.send("test", m);
            logger.info(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
