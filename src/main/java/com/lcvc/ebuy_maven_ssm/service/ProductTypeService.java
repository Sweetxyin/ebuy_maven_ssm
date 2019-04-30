package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeService {


    @Resource
    private ProductTypeDao productTypeDao;


    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    public List<ProductType> getProductList(){
        return productTypeDao.getProductTypeList();
    }


}
