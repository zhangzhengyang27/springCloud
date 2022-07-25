package com.lagou.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients // 开启Feign
public class PageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageApplication.class, args);
    }

    //像容器中注入一个RestTemplate，封装了HttpClient
    @Bean
    @LoadBalanced  // Ribbon负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
