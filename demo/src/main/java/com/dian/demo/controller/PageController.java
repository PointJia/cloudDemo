package com.dian.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PageController {

    @GetMapping(value = "/index")
    public String index(){
        return "page/index";
    }

    @GetMapping(value = "/indexJSP")
    public String indexJSP(){
        return "page/indexJSP";
    }

}
