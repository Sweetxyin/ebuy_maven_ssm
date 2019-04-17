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
    public void testUpdatePassword() {

            System.out.println(adminDao.updatePassword("111", 2));
    }
    @Test
    public void UpdateAdmin(){
        System.out.println(adminDao.updateAdmin("user","樱桃小子",1));
    }

    @Test
    public void testExistsAdmin(){
        System.out.println(adminDao.existsAdmin("user",1));

    }
}
