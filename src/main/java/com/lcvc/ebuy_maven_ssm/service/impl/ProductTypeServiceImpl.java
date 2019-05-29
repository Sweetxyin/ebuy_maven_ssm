package com.lcvc.ebuy_maven_ssm.service.impl;


import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{


    @Resource
    private ProductTypeDao productTypeDao;


    public List<ProductType> getProductTypeList(){
        return productTypeDao.getProductTypeList();
    }


    public boolean deleteProductType(Integer id){
        Boolean status=false;//默认删除失败
        if (id!=null){
                int n=productTypeDao.deleteProductType(id);
                if (n==1){
                    status=true;
                }
            }
        return status;
    }



    public boolean saveProductType(ProductType productType){
        Boolean status=false;//默认添加失败
        int i=productTypeDao.saveProductType(productType);
        if (i>0){
            status=true;
        }
        return status;
    }


    public boolean updateProductType(ProductType productType){
        Boolean status=false;//默认编辑失败

            if (productTypeDao.updateProductType(productType)==1){
                status=true;
            }else {
                status=false;
            }
        return false;
    }


    public ProductType getProductType(Integer id){
       ProductType productType=null;
        if (id!=null){
            productType=productTypeDao.getProductType(id);
        }
        return productType;
    }




}
