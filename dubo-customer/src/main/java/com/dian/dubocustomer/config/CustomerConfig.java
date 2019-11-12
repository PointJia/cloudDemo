package com.dian.dubocustomer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:config/dubbo-customer.xml")
public class CustomerConfig {
}
