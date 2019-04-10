package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.SqlSessionFactoryUtil;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    public Admin login(String username, String password){
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        Admin admin=null;
        //打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            AdminDao adminDao = session.getMapper(AdminDao.class);
            admin=adminDao.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return admin;
    }

    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return null表示密码更改成功，false表示密码更改失败
	 */
    public boolean updatePassword(String newPass,Integer id){
        Boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);

        //打开数据库，耗费资源巨大，建议项目中只打开一次
        SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        //创建SqlSession，SqlSession类似于JDBC中的Connection，
        SqlSession session = sessionFactory.openSession();
        try {
            //获取mapper接口代理对象
            AdminDao adminDao = session.getMapper(AdminDao.class);
            // 编写代码，判断是否编辑成功
            if(adminDao.updatePassword(newPass,id)>0){
                status=true;
            }
            session.commit();//提交事务，提交事务之后对数据库做的所有变更才能生效
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return status;
    }

    public static void main(String[] args) {

    }
}
