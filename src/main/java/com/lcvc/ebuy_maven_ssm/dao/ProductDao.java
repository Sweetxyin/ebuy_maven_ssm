package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Product;
import org.apache.ibatis.annotations.Param;

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

    int getProductTypeID(Product product);

    /**
     * 分页显示数据库记录
     * @param offset 记录开始位置
     * @param length 偏移量
     * @return
     */
    List<Product> getPartlst(@Param(value = "offset")int offset,@Param(value = "length")int length);
    int maxPage();

    /**
     *读取所有产品的记录总数
     * @return
     */
    int total();
}
