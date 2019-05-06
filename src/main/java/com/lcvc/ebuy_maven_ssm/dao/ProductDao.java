package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Product;

import java.util.List;

public interface ProductDao {


    /**
     * 返回所有的产品管理
     * @return 以list方式返回
     */
    List<Product> getProductList();

    /**

     * @param id 主键
     * @return 返回删除的个数
     */
    int deleteProduct(Integer id);


    /**
     * 保存指定账户进数据库
     * @return 返回添加了多少条记录
     */

    int saveProduct(Product product);

    /**
     * 修改产品管理
     * @return
     */
    int updateProduct(Product product);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return
     */
    Product getProduct(int id);
}
