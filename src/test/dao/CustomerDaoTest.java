package dao;


import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class CustomerDaoTest extends SpringJunitTest {
    @Resource
    private CustomerDao customerDao;

    @Test
    public void testSaveCustomer(){
        Customer customer=new Customer();
        customer.setUsername("xyin");
        customer.setPassword("123");
        customer.setName("蜡笔小新");
        customer.setTel("1246566");
        customer.setAddress("广西");
        customer.setZip("222");
        customer.setEmail("123@qq.com");
        customer.setPicUrl("kjghj");
        customer.setIntro("nhgjnhgk");
        customer.setCreateTime(new Date());
        customerDao.saveCustomer(customer);
    }


}
