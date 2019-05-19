package com.dian.demo.dao;

import com.dian.demo.entity.Event;

public interface EventDao {

    void addEvent(Event event);

    void updateEvent(Event event);

    void deleteEvent(Integer eventId);

    Event queryById(Integer id);

}
