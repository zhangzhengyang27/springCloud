package com.lagou.product.controller;


import com.lagou.common.pojo.Products;
import com.lagou.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/query/{id}")
    public Products queryById(@PathVariable Integer id){
        return productService.queryById(id);
    }

}
