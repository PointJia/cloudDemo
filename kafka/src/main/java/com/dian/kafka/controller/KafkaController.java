package com.dian.kafka.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/k")
public class KafkaController {


    @GetMapping(value = "/index")
    public String index(){
        return "OL";
    }


}
