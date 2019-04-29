package com.lcvc.ebuy_maven_ssm.web.backstage.adminmanage;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

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
	public String doDeleteAdmin(HttpServletRequest request, HttpSession session,Integer id) {
		Admin admin=(Admin)session.getAttribute("admin");
		adminService.deleteAdmin(id,admin.getId());
		request.setAttribute("list",adminService.getAdminList());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}

	//跳转到管理员添加页面
	@RequestMapping(value = "/backstage/adminmanage/toAddAdmin", method = RequestMethod.GET)
	public String toAddAdmin(HttpServletRequest request) {
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}
	//执行添加管理员操作
	@RequestMapping(value = "/backstage/adminmanage/doAddAdmin", method = RequestMethod.POST)
	public String doAddAdmin(HttpServletRequest request, HttpSession session,Admin admin) {
		//Admin admin=(Admin)session.getAttribute("admin");
		admin.setUsername(admin.getUsername().trim());
		admin.setPassword(admin.getPassword().trim());
		admin.setName(admin.getName().trim());
			if (admin.getUsername().length()==0){
				request.setAttribute("myMessage", "添加管理员账户失败：账户名不能为空");
			}else if (admin.getPassword().length()==0){
				request.setAttribute("myMessage", "添加管理员账户失败：密码不能为空");
			}else if (admin.getName().length()==0){
				request.setAttribute("myMessage", "添加管理员账户失败：网名不能为空");
			}else if (adminService.existsUsername(admin.getUsername())) {
				request.setAttribute("myMessage", "账户创建失败：账户名已存在，请选择其他的账户名！");
			}else {
				/*	admin.setUsername(username);
					admin.setPassword(password);
					admin.setName(name);
					admin.setCreateTime(new Date());*/
					adminService.saveAdmin(admin);

				request.setAttribute("myMessage", "添加管理员账户成功！");
			}
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}

	//跳转到管理员修改页面
	@RequestMapping(value = "/backstage/adminmanage/toUpdateAdmin", method = RequestMethod.GET)
	public String toUpdateAdmin(HttpServletRequest request,Integer id) {
         request.setAttribute("admin",adminService.getAdmin(id));
		return "/jsp/backstage/adminmanage/adminupdate.jsp";
	}
	//执行修改管理账户的基本信息
	@RequestMapping(value = "/backstage/adminmanage/doUpdateAdmin", method = RequestMethod.POST)
	public String doUpdateAdmin(String username,String name,HttpSession session,HttpServletRequest request){
		Admin admin=(Admin)session.getAttribute("admin");
		if (username.equals("")){
			request.setAttribute("myMessage","账户名不能为空");
		}else if (name.equals("")){
			request.setAttribute("myMessage","网名不能为空");
		}else if (adminService.existsAdmin(username,admin.getId())==true){
			request.setAttribute("myMessage","账户名重名");
		}else {
			if (adminService.selectUsername(username)==null||username.equals(admin.getUsername()))

			     admin.setUsername(username);
			     admin.setName(name);
			adminService.updateAdmin(username,name,admin.getId());
			request.setAttribute("myMessage", "基本信息修改成功");
			}
		return "/jsp/backstage/adminmanage/adminupdate.jsp";
	}
}
