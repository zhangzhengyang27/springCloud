package com.lagou.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign客户端功能
public class PageApplication9101 {

    public static void main(String[] args) {
        SpringApplication.run(PageApplication9101.class,args);
    }

}
