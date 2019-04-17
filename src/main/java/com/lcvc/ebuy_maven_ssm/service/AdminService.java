package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.SqlSessionFactoryUtil;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {


    @Resource
    private AdminDao adminDao;


    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    public Admin login(String username, String password){
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        Admin admin=adminDao.login(username, password);
        return admin;
    }


    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return true表示密码更改成功，false表示密码更改失败
	 */
    public boolean updatePassword(String newPass,Integer id){
        Boolean status=false;//默认编辑失败
        newPass= SHA.getResult(newPass);
        if(adminDao.updatePassword(newPass,id)>0){
            status=true;
        }
        return status;
    }

    /**
     * 修改账户名和网名
     * 说明：
     * 1、修改后的账户不能与其他账户的账户名重名
     * @param username 账户名
     * @param name 网名
     * @param id
     * @return flash表示修改失败， true表示修改成功
     */
    public boolean updateAdmin(String username, String name,Integer id){
        Boolean status=false;//默认编辑失败
        if (adminDao.existsAdmin(username,id)==0){
            if (adminDao.updateAdmin(username,name,id)==1){
                status=true;

            }else {
                status=false;
            }
        }
            return false;
        }

    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    public List<Admin> getAdminList(){
        return adminDao.getAdminList();
    }

}
