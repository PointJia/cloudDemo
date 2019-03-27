package com.dian.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/k")
public class KafkaController {

    Logger logger = Logger.getLogger(KafkaController.class.getName());

    @Autowired
    KafkaTemplate<String,String> template;

    @GetMapping(value = "/send")
    @ResponseBody
    public String send(String msg){
        try {
            String m = msg + new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
            org.springframework.util.concurrent.ListenableFuture<SendResult<String, String>> send = template.send("test", m);
            logger.info(m);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERR";
        }
        return "OL";
    }
}
