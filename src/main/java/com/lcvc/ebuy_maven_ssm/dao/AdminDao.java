package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    /**
     * 根据账户名和密码去数据库查询
     * @param username 账户名
     * @param password 密码
     * @return null表示没有找到记录
     */
    Admin login(@Param(value = "username") String username, @Param(value = "password") String password);

    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return 更改了多少条记录
	 */
    int updatePassword(@Param(value = "password") String newpass, @Param(value = "id") Integer id);

    /**
     * 修改账户名
     * @param username 用户名
     * @param name 网名
     * @param id 主键
     * @return
     */
    int updateAdmin(@Param(value = "username")String username,@Param(value = "name")String name,@Param(value = "id")Integer id);


    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username 用户名
     * @param id 主键
     * @return 返回重名的个数 0表示不重名
     */
    int existsAdmin(@Param(value = "username")String username,@Param(value = "id")Integer id);

    /**
     * 查找在数据库中和指定用户名重名的个数
     * @param username 用户名
     * @return 返回重名的个数 0表示不重名
     */
    int existsUsername(@Param(value = "username")String username);

    /**
     * 返回所有的管理账户集合
     * @return 以list方式返回
     */
    List<Admin> getAdminList();

    /**

     * @param id 主键
     * @return 返回删除的个数
     */
    int deleteAdmin(Integer id);

    /**
     * 保存指定账户进数据库
     * @return 返回添加了多少条记录
     */
    //int saveAdmin(@Param(value = "username")String username, @Param(value = "password") String password,@Param(value = "name")String name,@Param(value = "createTime") String createTime);
    int saveAdmin(Admin admin);

    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return
     */
    Admin getAdmin(int id);


}
