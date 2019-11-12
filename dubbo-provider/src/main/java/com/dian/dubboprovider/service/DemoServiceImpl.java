package com.dian.dubboprovider.service;

import com.dian.dubbo.entity.EventInfo;
import com.dian.dubbo.service.DemoService;

import java.sql.Date;

public class DemoServiceImpl implements DemoService {

    public DemoServiceImpl() {
        System.out.println("is run");
    }

    @Override
    public String handleMsg() {
        return "OL";
    }

    @Override
    public EventInfo initEventInfo(String name, String desc) {
        return new EventInfo(name,desc);
    }

    @Override
    public EventInfo initEvent(String name, String desc, Date date) {
        return new EventInfo(name,desc,date);
    }

}
