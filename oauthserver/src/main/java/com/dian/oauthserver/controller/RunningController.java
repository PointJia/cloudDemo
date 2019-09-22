package com.dian.oauthserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/run")
public class RunningController {

    @RequestMapping(value = "/init")
    public String isRunning(){
        return "is running";
    }

}
