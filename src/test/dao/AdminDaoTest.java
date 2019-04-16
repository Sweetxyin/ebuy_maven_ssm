package dao;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminDaoTest extends SpringJunitTest {
    @Resource
    private AdminDao adminDao;

    @Test
    public void print(){
        System.out.println("hello");
    }

    @Test
    public void testLogin(){
        Admin admin=adminDao.login("user",  SHA.getResult("123456"));
        System.out.println(admin);
        Admin admin2=adminDao.login("user",  SHA.getResult("12345611"));
        System.out.println(admin2);
    }

    @Test
    public void testUpdatePassword(){
        System.out.println(adminDao.updatePassword("555",2));
    }

    @Test
    public void UpdateAdmin(){System.out.println(adminDao.updateAdmin("lzq","小红",2));
    }

    @Test
    public void testselectUsername(){
        Admin admin=adminDao.selectUsername("user");
        System.out.println(admin);
    }
}
