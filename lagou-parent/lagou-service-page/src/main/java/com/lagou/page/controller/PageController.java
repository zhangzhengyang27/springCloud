package com.lagou.page.controller;

import com.lagou.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id) {
        Products products = restTemplate.getForObject("http://localhost:9000/product/query/" + id, Products.class);
        System.out.println("从lagou-service-product获得product对象:" + products);
        return products;
    }
}