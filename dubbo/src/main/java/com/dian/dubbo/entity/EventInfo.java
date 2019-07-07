package com.dian.dubbo.entity;

import java.io.Serializable;
import java.util.Date;

public class EventInfo implements Serializable {

    private String name;

    private String desc;

    private Date time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public EventInfo(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.time = new Date();
    }

    public EventInfo(String name, String desc, Date time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", time=" + time +
                '}';
    }
}
