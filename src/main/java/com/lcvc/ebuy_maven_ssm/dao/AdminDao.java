package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.annotations.Param;

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
     *修改用户的基本信息
     * @param username 账户名
     * @param name 姓名
     * @param id 主键
     * @return 更改了多少条记录
     */

    int updateAdmin(@Param(value = "username") String username,@Param(value = "name") String name,@Param(value = "id") Integer id);

}
