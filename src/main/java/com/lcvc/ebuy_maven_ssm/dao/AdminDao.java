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


    /**
     * 修改账户名
     * @return
     */
    int updateAdmin(Admin admin);


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


    /**
     * 分页显示数据库记录
     * @param offset 记录开始位置
     * @param length 偏移量
     * @return
     */
    List<Admin> getPartlst(@Param(value = "offset")int offset,@Param(value = "length")int length);
    int maxPage();

    /**
     *读取所有产品的记录总数
     * @return
     */
    int total();

}
