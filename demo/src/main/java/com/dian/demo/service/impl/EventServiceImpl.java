package com.dian.demo.service.impl;

import com.dian.demo.dao.EventDao;
import com.dian.demo.entity.Event;
import com.dian.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao dao;

    @Override
    public boolean addEvent(Event e) {
        dao.addEvent(e);
        return false;
    }

    @Override
    public boolean updateEvent(Event e) {
        dao.updateEvent(e);
        return false;
    }

    @Override
    public boolean deleteEvent(Integer id) {
        dao.deleteEvent(id);
        return false;
    }

    @Override
    public Event queryById(Integer id) {
        return dao.queryById(id);
    }
}
