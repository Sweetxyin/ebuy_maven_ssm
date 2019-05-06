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
     * 返回所有的产品分类管理集合
     * @return 以list方式返回
     */
    public List<ProductType> getProductTypeList(){
        return productTypeDao.getProductTypeList();
    }

    /**
     * 删除产品分类
     * @param id 被删除的产品分类id
     * @return flash表示删除失败， true表示删除成功
     */
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

    /**
     * 将产品分类信息存入数据库
     * @param productType
     * @return true表示保存成功，false表示保存失败
     */

    public boolean saveProductType(ProductType productType){
        Boolean status=false;//默认添加失败
        int i=productTypeDao.saveProductType(productType);
        if (i>0){
            status=true;
        }
        return status;
    }

    /**
     * 修改产品分类
     * @param productType
     * @return flash表示修改失败， true表示修改成功
     */
    public boolean updateProductType(ProductType productType){
        Boolean status=false;//默认编辑失败

            if (productTypeDao.updateProductType(productType)==1){
                status=true;
            }else {
                status=false;
            }
        return false;
    }

    /**
     * 获取产品分类的id
     * @param id
     * @return
     */
    public ProductType getProductType(Integer id){
       ProductType productType=null;
        if (id!=null){
            productType=productTypeDao.getProductType(id);
        }
        return productType;
    }




}
