package com.lagou.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 标识当前项目为Eureka Server
@EnableEurekaServer
public class EurekaApplication9201 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication9201.class, args);
    }
}
