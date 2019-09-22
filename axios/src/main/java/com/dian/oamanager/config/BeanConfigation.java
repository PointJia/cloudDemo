package com.dian.oamanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class BeanConfigation {


    @Bean
    public CommonsMultipartResolver initCommonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(104857600);
        resolver.setMaxInMemorySize(4096);
        return resolver;
    }

}
