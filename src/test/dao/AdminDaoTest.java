package dao;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class AdminDaoTest extends SpringJunitTest {
    @Resource
    private AdminDao adminDao;

    @Test
    public void print() {
        System.out.println("hello");
    }

    @Test
    public void testLogin() {
        Admin admin = adminDao.login("user", SHA.getResult("123456"));
        System.out.println(admin);
        Admin admin2 = adminDao.login("user", SHA.getResult("12345611"));
        System.out.println(admin2);
    }






    @Test
    public void testExistsAdmin() {
        System.out.println(adminDao.existsAdmin("user", 1));
    }

    @Test
    public void testGetAdminList(){
        List<Admin> list=adminDao.getAdminList();
        for (int i=0;i<list.size();i++){
            Admin admin=list.get(i);
            System.out.println(admin.getUsername());
        }
    }

    @Test
    public void testDeleteAdmin(){
        System.out.println(adminDao.deleteAdmin(67));
        System.out.println(adminDao.deleteAdmin(0));
    }
    @Test
    public void testSaveAdmin(){
      //System.out.println(adminDao.saveAdmin( "hhhhhh","123","ccccc","2019:4.24"));
      Admin admin=new Admin();
        admin.setUsername("xyyin");
        admin.setPassword("123");
        admin.setName("蜡笔小新");
        admin.setCreateTime(new Date());
        adminDao.saveAdmin(admin);
    }
    @Test
   public void testGetAdmin(){
        System.out.println(adminDao.getAdmin(2));
       System.out.println(adminDao.getAdmin(100));
   }

    /*@Test
    public void testGetProductTypeList(){
        List<ProductType> list=adminDao.getProductTypeList();
        for (int i=0;i<list.size();i++){
           ProductType productType=list.get(i);
            System.out.println(productType.getName());
        }
    }*/
}
