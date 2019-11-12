package com.demo.rabbit.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {

    @Autowired
    AmqpTemplate template;

    public void sendHi(){
        template.convertAndSend("hi","hi");
    }

}
