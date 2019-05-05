package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Customer;

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
}
