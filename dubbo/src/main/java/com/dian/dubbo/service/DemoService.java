package com.dian.dubbo.service;

import com.dian.dubbo.entity.EventInfo;

import java.sql.Date;

public interface DemoService {

    String handleMsg();

    EventInfo initEventInfo(String name,String desc);

    EventInfo initEvent(String name, String desc, Date date);


}
