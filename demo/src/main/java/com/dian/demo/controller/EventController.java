package com.dian.demo.controller;

import com.dian.demo.common.result.Result;
import com.dian.demo.common.result.ResultUtil;
import com.dian.demo.entity.Event;
import com.dian.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService service;

    @GetMapping(value = "/init")
    public Result events(Integer id){
        try{
            Event event = service.queryById(id);
            return ResultUtil.success(event);
        } catch (Exception e){
            return ResultUtil.fail();
        }
    }

    @GetMapping(value = "/update")
    public Result update(Event e){
        try {
            service.updateEvent(e);
        }catch (Exception ex){
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    @PostMapping(value = "/add")
    public Result add(Event e){
        try {
            service.addEvent(e);
        }catch (Exception ex){
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    @GetMapping(value = "/delete")
    public Result delete(Integer id){
        try {
            service.deleteEvent(id);
        } catch (Exception e){
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }


}
