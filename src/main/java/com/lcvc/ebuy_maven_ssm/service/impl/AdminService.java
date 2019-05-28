package com.lcvc.ebuy_maven_ssm.service.impl;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        Admin admin=new Admin();
        admin.setId(id);
        admin.setPassword(newPass);
        if(adminDao.updateAdmin(admin)>0){
            status=true;
        }
        return status;
    }


    /**
     * 修改账户名和网名
     * 说明：
     * 1、修改后的账户不能与其他账户的账户名重名
     * @return flash表示修改失败， true表示修改成功
     */
    public boolean updateAdmin(Admin admin){
        Boolean status=false;//默认编辑失败
        if (adminDao.existsAdmin(admin.getUsername(),admin.getId())==0){
            if (adminDao.updateAdmin(admin)>0){
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


    /**
     * 删除管理员
     * @param id 被删除的账户id
     * @param adminId 执行删除的管理账户
     * @return flash表示删除失败， true表示删除成功
     */
    public boolean deleteAdmin(Integer id,Integer adminId){
        Boolean status=false;//默认删除失败
        if (id!=null&&adminId!=null){
            if(adminId!=id.intValue()){//如果不是自己删自己
                int n=adminDao.deleteAdmin(id);
                if (n==1){
                    status=true;
                }
            }
        }

        return status;
    }
    /**
     * 查找在数据库中和指定用户名重名的个数（用于账户编辑）
     * @param username 用户名
     * @param id 主键
     * @return ture表示存在重名账户，false表示不存在
     */
    public boolean existsAdmin(String username,Integer id){
        if (adminDao.existsAdmin(username,id)==0){
            return false;
        }else{
            return true;
        }
    }

    /**
     *判断账户名是否存在（用于创建新账户的时候）
     * @param username
     * @return true表示存在，false表示存在
     */
    public boolean existsUsername(String username){
        if (adminDao.existsUsername(username)==0){
            return false;
        }else{
            return true;
        }
    }
    /**
     * 将账户信息存入数据库
     * @param admin
     * @return true表示保存成功，false表示保存失败
     */

    public boolean saveAdmin(Admin admin){
        Boolean status=false;//默认添加失败
        admin.setPassword(SHA.getResult(admin.getPassword()));
        admin.setCreateTime(new Date());
        int i=adminDao.saveAdmin(admin);
        if (i>0){
                status=true;
            }
        return status;
    }


     public Admin getAdmin(Integer id){
         Admin admin=null;
         if (id!=null){
             admin=adminDao.getAdmin(id);
         }
             return admin;
         }


}
