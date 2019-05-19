package com.dian.demo.entity;

public class Event {

    private Integer id;
    private String event_creater;
    private String event_desc;
    private String event_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent_creater() {
        return event_creater;
    }

    public void setEvent_creater(String event_creater) {
        this.event_creater = event_creater;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event_creater='" + event_creater + '\'' +
                ", event_desc='" + event_desc + '\'' +
                ", event_name='" + event_name + '\'' +
                '}';
    }
}
