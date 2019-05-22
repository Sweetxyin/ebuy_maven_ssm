package dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class AdminServiceTest extends SpringJunitTest {
    @Resource
    private AdminService adminService;
    @Test
    public void UpdateAdmin() {
        Admin admin=new Admin();
        admin.setId(1);
        admin.setUsername("xyin");
        System.out.println(adminService.updateAdmin(admin));
    }
}
