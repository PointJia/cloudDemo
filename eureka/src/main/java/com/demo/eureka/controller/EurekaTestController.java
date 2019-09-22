package com.demo.eureka.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eureka")
public class EurekaTestController {


    @RequestMapping(value = "/index")
    public String index(){
        return "test";
    }

}
