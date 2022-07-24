package com.lagou.page.controller;

import com.lagou.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id) {
        // Products products = restTemplate.getForObject("http://localhost:9000/product/query/" + id, Products.class);
        // System.out.println("从lagou-service-product获得product对象:" + products);
        // return products;


        //1.获得Eureka中注册的lagou-service-product实例集合
        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-product");
        // 2.获得实例集合中的第一个
        ServiceInstance instance = instances.get(0);

        //3.根据实例信息拼接IP地址
        String host = instance.getHost();
        int port = instance.getPort();
        // String url = "http://" + host + ":" + port + "/product/query/" + id;

        String url = "http://lagou-service-product/product/query/"+ id;

        //4.调用
        Products products = restTemplate.getForObject(url, Products.class);
        System.out.println("从lagou-service-product获得product对象:" + products);
        return products;
    }

    @GetMapping("/loadProductServicePort")
    public String getProductServerPort() {
        String url = "http://lagou-service-product/service/port";
        String result =restTemplate.getForObject(url, String.class);
        return result;
    }
}