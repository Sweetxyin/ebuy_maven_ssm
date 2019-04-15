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
        /*//打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            AdminDao adminDao = session.getMapper(AdminDao.class);*/
            System.out.println(adminDao.updatePassword("111", 2));
       /*     session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }*/
    }
}
