package com.lcvc.ebuy_maven_ssm.web.backstage.adminmanage;

import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminManageController {
	@Resource
	private AdminService adminService;

	//跳转到管理员管理页面
	@RequestMapping(value = "/backstage/adminmanage/toManageAdmin", method = RequestMethod.GET)
	public String toManageAdmin(HttpServletRequest request) {
		request.setAttribute("list",adminService.getAdminList());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}

	//执行删除管理员操作
	@RequestMapping(value = "/backstage/adminmanage/doDeleteAdmin", method = RequestMethod.GET)
	public String doDeleteAdmin(HttpServletRequest request,Integer id) {
		adminService.deleteAdmin(id);
		request.setAttribute("list",adminService.getAdminList());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}
}
