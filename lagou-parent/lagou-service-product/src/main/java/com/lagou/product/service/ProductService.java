package com.lagou.product.service;

import com.lagou.common.pojo.Products;

public interface ProductService {
    /**
     * 通过商品ID查询商品信息
     * @param id
     * @return
     */
    Products queryById(Integer id);

}
