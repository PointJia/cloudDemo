package com.dian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/t")
public class TestController {

    @GetMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "OK";
    }

}
