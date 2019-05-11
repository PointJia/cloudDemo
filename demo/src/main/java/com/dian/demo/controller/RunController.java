package com.dian.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/p")
public class RunController {

    @RequestMapping(value = "/isrun")
    public String isRun(){
        return "this project is running";
    }

}
