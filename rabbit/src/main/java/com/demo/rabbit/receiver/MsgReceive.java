package com.demo.rabbit.receiver;

import com.demo.rabbit.entity.EventInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgReceive {

    Logger logger = LoggerFactory.getLogger(MsgReceive.class);

    @RabbitListener(queues = {"msg"})
    public void receive(String message){
        logger.info("MSG-->消费消息");
        logger.info(message);
    }

    @RabbitListener(queues = {"bytes_msg"})
    public void receive(byte[] bytes){
        logger.info("bytes_msg-->消费消息");
        logger.info(new String(bytes));
    }

    @RabbitListener(queues = {"obj_msg"})
    public void receive(EventInfo event){
        logger.info("obj_msg-->消费消息");
        logger.info("event -- > {}",event);
    }


}
