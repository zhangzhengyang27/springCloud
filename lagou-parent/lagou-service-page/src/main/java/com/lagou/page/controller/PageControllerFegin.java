package com.lagou.page.controller;

import com.lagou.common.pojo.Products;
import com.lagou.page.fegin.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pageFegin")
public class PageControllerFegin {

    @Autowired
    private ProductFeign productFeign;

    @GetMapping("/getProduct/{id}")
    public Products getProduct(@PathVariable Integer id) {
        return productFeign.queryById(id);
    }

    @GetMapping("/loadProductServicePort")
    public String getProductServerPort() {
        return productFeign.getPort();
    }
}
