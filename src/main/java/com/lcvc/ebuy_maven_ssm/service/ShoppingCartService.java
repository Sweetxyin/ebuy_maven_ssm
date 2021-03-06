package com.lcvc.ebuy_maven_ssm.service;


import com.lcvc.ebuy_maven_ssm.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface ShoppingCartService {

    /**
     * 添加商品到购物车当中
     * @param productId 商品的主键
     * @param number 商品的数量
     */
    int putProduct(Integer productId,Integer number);

    /**
     * 获取购物车中的信息
     * @return
     */
    Map<Product,Integer> getShoppingCart();


    /**
     * 从购物车中移除商品
     * @param productId 商品的主键
     */
    void removeProduct(Integer productId);




}
