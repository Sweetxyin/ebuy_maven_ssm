package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;

import java.util.List;

public interface ProductTypeDao {

    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    List<ProductType> getProductTypeList();
}
