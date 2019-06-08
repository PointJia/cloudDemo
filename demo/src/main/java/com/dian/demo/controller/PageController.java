package com.dian.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PageController {

    @GetMapping(value = "/{pageName}")
    public String newII(@PathVariable("pageName") String name){
        return "page/"+name;
    }
}
