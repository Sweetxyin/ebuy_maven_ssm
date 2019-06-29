package service;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class CustomerServiceTest extends SpringJunitTest {
    @Resource
    private CustomerService customerService;


    @Test
    public void  testSaveProduct(){

        Customer customer=new Customer();
      customer.setUsername("hko");
      customer.setPassword("123");
      customer.setName("刚刚");
      customerService.saveShopCustomer(customer);
    }



}
