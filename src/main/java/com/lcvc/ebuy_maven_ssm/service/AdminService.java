package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;

public class AdminService {
    private AdminDao adminDao=new AdminDao();
    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return true表示登录成功,false表示登录失败
     */
    public Admin login(String username, String password) {
        //将密码加密后再进行比对
        password= SHA.getResult(password);
        Admin admin=adminDao.login(username,password);
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
        //编写代码，判断是否编辑成功
        if(adminDao.updatePassword(newPass,id)>0){
            status=true;
        }
        return status;
    }
}
