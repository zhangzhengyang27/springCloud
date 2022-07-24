package com.lagou.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient //将当前项目作为Eureka Client注册到Eureka Server ,只能在Eureka环境中使用
@EnableDiscoveryClient //也是将当前项目表示为注册中心的客户端，向注册中心进行注册，可以在所有的服务注册中心环境下使用
@MapperScan("com.lagou.product.mapper")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
