package com.demo.rabbit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

    @GetMapping(value = "/isRun")
    public String isRun(){
        return "this project is running";
    }

}
