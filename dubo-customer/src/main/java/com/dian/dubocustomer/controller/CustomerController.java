package com.dian.dubocustomer.controller;

import com.dian.dubbo.entity.EventInfo;
import com.dian.dubbo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class CustomerController {

    @Autowired
    DemoService demoService;

    @GetMapping(value = "/run")
    public String isRun(){
        return "customer project is running ...";
    }

    @GetMapping(value = "/event")
    public EventInfo initEvent(String name,String desc){
        demoService.handleMsg();
        return demoService.initEventInfo(name,desc);
    }


}
