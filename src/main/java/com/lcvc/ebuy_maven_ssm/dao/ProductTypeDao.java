package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeDao {

    /**
     * 返回所有的产品分类管理
     * @return 以list方式返回
     */
    List<ProductType> getProductTypeList();

    /**
     * 返回所有的产品管理
     * @return 以list方式返回
     */
    List<Product> getProductList();

    /**

     * @param id 主键
     * @return 返回删除的个数
     */
    int deleteProductType(Integer id);


    /**
     * 保存指定账户进数据库
     * @return 返回添加了多少条记录
     */

    int saveProductType(ProductType productType);

    /**
     * 修改产品分类
     * @return
     */
    int updateProductType(ProductType productType);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return
     */
    ProductType getProductType(int id);
}
