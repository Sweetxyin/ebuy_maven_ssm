package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerDao {



    /**
     * 返回所有的客户管理
     * @return 以list方式返回
     */
    List<Customer> getCustomerList();

    /**

     * @param id 主键
     * @return 返回删除的个数
     */
    int deleteCustomer(Integer id);


    /**
     * 保存指定账户进数据库
     * @return 返回添加了多少条记录
     */

    int saveCustomer(Customer customer);

    /**
     * 修改产品分类
     * @return
     */
    int updateCustomer(Customer customer);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return
     */
    Customer getCustomer(int id);

    /**
     * 根据账户名和密码去数据库查询
     * @param username 账户名
     * @param password 密码
     * @return null表示没有找到记录
     */
    Customer login(@Param(value = "username") String username, @Param(value = "password") String password);
    /**
     * 保存指定账户进数据库
     * @return 返回添加了多少条记录
     */
    int saveShopCustomer(Customer customer);
    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username 用户名
     * @return 返回重名的个数 0表示不重名
     */
    int existsCustomer(@Param(value = "username")String username);
}
