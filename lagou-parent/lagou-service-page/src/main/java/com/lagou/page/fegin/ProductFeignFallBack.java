package com.lagou.page.fegin;

import com.lagou.common.pojo.Products;
import org.springframework.stereotype.Component;

/**
 * 熔断器出发之后的回调逻辑
 */
@Component
public class ProductFeignFallBack implements ProductFeign{
    @Override
    public Products queryById(Integer id) {
        return null;
    }

    @Override
    public String getPort() {
        return "-1";
    }
}
