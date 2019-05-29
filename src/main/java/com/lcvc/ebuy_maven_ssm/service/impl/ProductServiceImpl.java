package com.lcvc.ebuy_maven_ssm.service.impl;


import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Resource
    private ProductDao productDao;



    public List<Product> getProductList(){
        return productDao.getProductList();
    }



    public boolean deleteProduct(Integer id){
        Boolean status=false;//默认删除失败
        if (id!=null){
                int n=productDao.deleteProduct(id);
                if (n==1){
                    status=true;
                }
            }
        return status;
    }


    public boolean saveProduct(Product product){
        Boolean status=false;//默认添加失败
        int i=productDao.saveProduct(product);
        if (i>0){
            status=true;
        }
        return status;
    }

    public boolean updateProduct(Product product){
        Boolean status=false;//默认编辑失败

            if (productDao.updateProduct(product)==1){
                status=true;
            }else {
                status=false;
            }
        return false;
    }


    public Product getProduct(Integer id){
       Product product=null;
        if (id!=null){
          product=productDao.getProduct(id);
        }
        return product;
    }


}
