package com.dian.demo.service;

import com.dian.demo.entity.Event;

public interface EventService {

    boolean addEvent(Event e);

    boolean updateEvent(Event e);

    boolean deleteEvent(Integer id);

    Event queryById(Integer id);

}
