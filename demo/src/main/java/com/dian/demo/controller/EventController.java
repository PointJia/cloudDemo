package com.dian.demo.controller;

import com.dian.demo.entity.Event;
import com.dian.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService service;

    @GetMapping(value = "/init")
    public String events(Integer id){
        Event event = service.queryById(id);
        return event.toString();
    }

}
