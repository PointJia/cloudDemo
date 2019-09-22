package com.dian.oamanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping(value = "/page/**")
    public String page(HttpServletRequest request){
        return request.getRequestURI();
    }

}
