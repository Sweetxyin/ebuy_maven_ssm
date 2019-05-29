package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.dao.SqlSessionFactoryUtil;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface AdminService {





    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    public Admin login(String username, String password);


    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return true表示密码更改成功，false表示密码更改失败
	 */
   boolean updatePassword(String newPass,Integer id);


    /**
     * 修改账户名和网名
     * 说明：
     * 1、修改后的账户不能与其他账户的账户名重名
     * @return flash表示修改失败， true表示修改成功
     */
    boolean updateAdmin(Admin admin);

    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    List<Admin> getAdminList();


    /**
     * 删除管理员
     * @param id 被删除的账户id
     * @param adminId 执行删除的管理账户
     * @return flash表示删除失败， true表示删除成功
     */
     boolean deleteAdmin(Integer id,Integer adminId);
    /**
     * 查找在数据库中和指定用户名重名的个数（用于账户编辑）
     * @param username 用户名
     * @param id 主键
     * @return ture表示存在重名账户，false表示不存在
     */
    boolean existsAdmin(String username,Integer id);

    /**
     *判断账户名是否存在（用于创建新账户的时候）
     * @param username
     * @return true表示存在，false表示存在
     */
     boolean existsUsername(String username);
    /**
     * 将账户信息存入数据库
     * @param admin
     * @return true表示保存成功，false表示保存失败
     */

     boolean saveAdmin(Admin admin);


     Admin getAdmin(Integer id);


}
