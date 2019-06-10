package com.demo.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue initQueue(){
        return new Queue("msg");
    }

    @Bean
    public Queue initByteQueue(){
        return new Queue("bytes_msg");
    }

    @Bean
    public Queue initObjQueue(){
        return new Queue("obj_msg");
    }


}
