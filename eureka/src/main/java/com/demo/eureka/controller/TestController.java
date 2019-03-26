package com.demo.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/t")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    public TestController(){
        logger.info("init TestController");
    }

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "eureka resign center is running";
    }

}
