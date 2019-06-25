package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerDao customerDao;


    public List<Customer> getCustomerList(){
        return customerDao.getCustomerList();
    }


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

    public boolean updateCustomer(Customer customer){
        Boolean status=false;//默认编辑失败

        if (customerDao.updateCustomer(customer)==1){
            status=true;
        }else {
            status=false;
        }
        return false;
    }

    @Override
    public Customer getCustomer(Integer id) {
        Customer customer=null;
        if (id!=null){
            customer=customerDao.getCustomer(id);
        }
        return customer;
    }

    @Override
    public Customer login(String username, String password) {
        if (password.length()!=32){
            //将密码加密后再进行比对
            password= SHA.getResult(password);
        }
        Customer customer=customerDao.login(username, password);
        return customer;
    }

    @Override
    public boolean existsCustomer(String username) {
        if (customerDao.existsCustomer(username)==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean saveShopCustomer(Customer customer) {

        Boolean status=false;//默认添加失败
        customer.setPassword(SHA.getResult(customer.getPassword()));
        customer.setCreateTime(new Date());
        int i=customerDao.saveShopCustomer(customer);
        if (i>0){
            status=true;
        }
        return status;
    }


}
