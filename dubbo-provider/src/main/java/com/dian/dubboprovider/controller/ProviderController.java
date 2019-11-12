package com.dian.dubboprovider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class ProviderController {

    @GetMapping(value = "/run")
    public String isRun(){
        return "provider project is running ...";
    }

}
