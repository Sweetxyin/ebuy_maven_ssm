package com.lcvc.ebuy_maven_ssm.service;


import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ProductService {



    /**
     * 返回所有的产品管理集合
     * @return 以list方式返回
     */
     List<Product> getProductList();




    /**
     * 删除产品
     * @param id 被删除的产品id
     * @return flash表示删除失败， true表示删除成功
     */
    boolean deleteProduct(Integer id);

    /**
     * 将产品信息存入数据库
     * @param product
     * @return true表示保存成功，false表示保存失败
     */

    boolean saveProduct(Product product);

    /**
     * 修改产品
     * @param product
     * @return flash表示修改失败， true表示修改成功
     */
    boolean updateProduct(Product product);

    /**
     * 获取产品=的id
     * @param id
     * @return
     */
     Product getProduct(Integer id);

    /**
     * 执行数据库分页操作
     * @param page 页面
     * @return
     */
     List<Product> getProductList(Integer page);

     int maxPage();
    /**
     * 返回最新发布的N条记录
     * @return 以list方式返回
     */
    List<Product> getNewTopProductList(Integer pageSize);

    /**
     * 返回热门订单的N条记录
     * @return
     */
    List<Product> getHotProductList(int pageSize);
    /**
     * 返回限时秒杀的N条记录
     * @return
     */
    List<Product> getTimerProduct(int pageSize);


    /**
     * 返回前台的模糊查询的产品管理
     * @return 以list方式返回
     */
    List<Product> searchProduct(Product product);

    /**
     * 返回前台的产品分类的产品
     * @return 以list方式返回
     */
    List<Product> getProductTypeList(int id);
}
