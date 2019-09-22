package com.demo.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(serviceId = "EUREKA-PROVIDER")
public interface ProviderService {

    @RequestMapping(value = "/first")
    String first();

    @RequestMapping(value = "/index")
    String second();

}
