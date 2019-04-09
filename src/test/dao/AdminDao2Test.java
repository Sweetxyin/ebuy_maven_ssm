package dao;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao2;
import com.lcvc.ebuy_maven_ssm.dao.SqlSessionFactoryUtil;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class AdminDao2Test {

    @Test
    public void testLogin(){
        Admin admin=null;
        //打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            AdminDao2 adminDao = session.getMapper(AdminDao2.class);
            admin=adminDao.login("user", "1234567");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println(admin);
        System.out.println(admin.getName());
    }
}
