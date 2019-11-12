package com.demo.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping(value = "/first")
    public String firstApi(){
        return "this provider api...";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "provider is running...";
    }


}
