package com.demo.rabbit.controller;

import com.demo.rabbit.entity.EventInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/msg")
public class MsgController {

    @Autowired
    AmqpTemplate template;

    @RequestMapping(value = "/hi")
    public String sendHi(String msg){
        template.convertAndSend("msg",msg);
        return "SUCCESS";
    }

    @RequestMapping(value = "/hello")
    public String sendHello(String msg){
        template.convertAndSend("bytes_msg",msg.getBytes());
        return "SUCCESS";
    }

    @RequestMapping(value = "/obj")
    public String sendObj(EventInfo event){
        template.convertAndSend("obj_msg",event);
        return "SUCCESS";
    }

}
