package com.lcvc.ebuy_maven_ssm.service;


import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public interface ProductTypeService {

/*
    @Resource
    private ProductTypeDao productTypeDao;*/

    /**
     * 返回所有的产品分类管理集合
     * @return 以list方式返回
     */
    List<ProductType> getProductTypeList();

    /**
     * 删除产品分类
     * @param id 被删除的产品分类id
     * @return flash表示删除失败， true表示删除成功
     */
     boolean deleteProductType(Integer id);


    /**
     * 将产品分类信息存入数据库
     * @param productType
     * @return true表示保存成功，false表示保存失败
     */

    boolean saveProductType(ProductType productType);


    /**
     * 修改产品分类
     * @param productType
     * @return flash表示修改失败， true表示修改成功
     */
     boolean updateProductType(ProductType productType);

    /**
     * 获取产品分类的id
     * @param id
     * @return
     */
    ProductType getProductType(Integer id);




}
