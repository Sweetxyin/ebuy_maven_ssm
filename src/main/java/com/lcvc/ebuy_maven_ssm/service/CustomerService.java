package com.lcvc.ebuy_maven_ssm.service;

import javax.annotation.Resource;
import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Resource
    private CustomerDao customerDao;

    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    public List<Customer> getCustomerList(){
        return customerDao.getCustomerList();
    }

    /**
     * 删除管理员
     * @param id 被删除的账户id
     * @return flash表示删除失败， true表示删除成功
     */
    public boolean deleteCustomer(Integer id){
        Boolean status=false;//默认删除失败
        if (id!=null){
            int n=customerDao.deleteCustomer(id);
            if (n==1){
                status=true;
            }
        }
        return status;
    }

    /**
     * 将账户信息存入数据库
     * @param
     * @return true表示保存成功，false表示保存失败
     */

    public boolean saveCustomer(Customer customer){
        Boolean status=false;//默认添加失败
        customer.setCreateTime(new Date());
        if (customerDao.saveCustomer(customer)==1){
            status=true;
        }else {
            status=false;
        }
        return status;
    }

    /**
     * 修改产品分类
     * @param
     * @return flash表示修改失败， true表示修改成功
     */
    public boolean updateCustomer(Customer customer){
        Boolean status=false;//默认编辑失败

        if (customerDao.updateCustomer(customer)==1){
            status=true;
        }else {
            status=false;
        }
        return false;
    }

    public Customer getCustomer(Integer id){
       Customer customer=null;
        if (id!=null){
            customer=customerDao.getCustomer(id);
        }
        return customer;
    }



}
