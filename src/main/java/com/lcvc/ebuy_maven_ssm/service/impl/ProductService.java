package com.lcvc.ebuy_maven_ssm.service.impl;


import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {


    @Resource
    private ProductDao productDao;


    /**
     * 返回所有的产品管理集合
     * @return 以list方式返回
     */
    public List<Product> getProductList(){
        return productDao.getProductList();
    }


    /**
     * 删除产品
     * @param id 被删除的产品id
     * @return flash表示删除失败， true表示删除成功
     */
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

    /**
     * 将产品信息存入数据库
     * @param product
     * @return true表示保存成功，false表示保存失败
     */

    public boolean saveProduct(Product product){
        Boolean status=false;//默认添加失败
        int i=productDao.saveProduct(product);
        if (i>0){
            status=true;
        }
        return status;
    }

    /**
     * 修改产品
     * @param product
     * @return flash表示修改失败， true表示修改成功
     */
    public boolean updateProduct(Product product){
        Boolean status=false;//默认编辑失败

            if (productDao.updateProduct(product)==1){
                status=true;
            }else {
                status=false;
            }
        return false;
    }

    /**
     * 获取产品=的id
     * @param id
     * @return
     */
    public Product getProduct(Integer id){
       Product product=null;
        if (id!=null){
          product=productDao.getProduct(id);
        }
        return product;
    }


}
