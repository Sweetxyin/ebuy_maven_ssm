package com.lcvc.ebuy_maven_ssm.service;

import javax.annotation.Resource;
import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface CustomerService {


    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    List<Customer> getCustomerList();

    /**
     * 删除管理员
     * @param id 被删除的账户id
     * @return flash表示删除失败， true表示删除成功
     */
   boolean deleteCustomer(Integer id);

    /**
     * 将账户信息存入数据库
     * @param
     * @return true表示保存成功，false表示保存失败
     */

    boolean saveCustomer(Customer customer);

    /**
     * 修改产品分类
     * @param
     * @return flash表示修改失败， true表示修改成功
     */
     boolean updateCustomer(Customer customer);


     Customer getCustomer(Integer id);


    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    Customer login(String username, String password);

    /**
     * 查找在数据库中和指定用户名重名的个数（用于账户编辑）
     * @param username 用户名
     * @return ture表示存在重名账户，false表示不存在
     */
    boolean existsCustomer(String username);
    /**
     * 将账户信息存入数据库
     * @param customer
     * @return true表示保存成功，false表示保存失败
     */

    boolean saveShopCustomer(Customer customer);

}
