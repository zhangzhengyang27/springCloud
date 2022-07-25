package com.lagou.page.controller;

import com.lagou.common.pojo.Products;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

        String url = "http://lagou-service-product/product/query/" + id;

        //4.调用
        Products products = restTemplate.getForObject(url, Products.class);
        System.out.println("从lagou-service-product获得product对象:" + products);
        return products;
    }

    @GetMapping("/loadProductServicePort")
    public String getProductServerPort() {
        String url = "http://lagou-service-product/service/port";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/loadProductServicePort2")
    // 使用@HystrixCommand注解进行熔断控制,针对熔断处理,Hystrix默认维护一个线程池，默认大小为10。
    @HystrixCommand(
            // 线程池标识，要保持唯一，不唯一的话就共用了
            threadPoolKey = "getProductServerPort2",
            // 线程池细节属性配置
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),   // 线程数
                    @HystrixProperty(name = "maxQueueSize", value = "20") // 等待队列长度
            },
            // commandProperties熔断的一些细节属性配置
            commandProperties = {
                    // 每一个属性都是一个HystrixProperty，默认1秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
    )
    public String getProductServerPort2() {
        String url = "http://lagou-service-product/service/port";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
}