package com.demo.customer.controller;

import com.demo.customer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cus")
public class CustomerController {

    @Autowired
    public ProviderService providerService;

    @RequestMapping(value = "/f")
    public String f(){
        return providerService.first();
    }

    @RequestMapping(value = "/s")
    public String s(){
        return providerService.second();

    }

}
