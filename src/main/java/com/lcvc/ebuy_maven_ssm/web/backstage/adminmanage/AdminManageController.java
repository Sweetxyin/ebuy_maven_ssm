package com.lcvc.ebuy_maven_ssm.web.backstage.adminmanage;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminManageController {
	@Resource
	private AdminService adminService;

	//跳转到管理员管理页面
	@RequestMapping(value = "/backstage/adminmanage/toManageAdmin", method = RequestMethod.GET)
	public String toManageAdmin(Model model, Integer page) {
		if (page==null){//如果页面为空，就显示第一页
			page=1;
		}else {
			if (page<1){
				page=1;
			}
		}

		model.addAttribute("list",adminService.getAdminList(page));
		model.addAttribute("page",page);
		model.addAttribute("maxPage",adminService.maxPage());
		return "/jsp/backstage/adminmanage/adminmanage.jsp";
	}

	//执行删除管理员操作
	@ResponseBody
	@RequestMapping(value = "/backstage/adminmanage/doDeleteAdmin", method = RequestMethod.GET)
	public Map<String,Object> doDeleteAdmin(HttpSession session, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Admin admin=(Admin)session.getAttribute("admin");
		adminService.deleteAdmin(id,admin.getId());
		map.put("status", 1);
		return map;
	}

	//跳转到管理员添加页面
	@RequestMapping(value = "/backstage/adminmanage/toAddAdmin", method = RequestMethod.GET)
	public String toAddAdmin(HttpServletRequest request) {
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}
	//执行添加管理员操作
	@RequestMapping(value = "/backstage/adminmanage/doAddAdmin", method = RequestMethod.POST)
	public String doAddAdmin(Model model,Admin admin) {
		admin.setUsername(admin.getUsername().trim());
		admin.setPassword(admin.getPassword().trim());
		admin.setName(admin.getName().trim());
			if (admin.getUsername().length()==0){
				model.addAttribute("myMessage", "添加管理员账户失败：账户名不能为空");
			}else if (admin.getPassword().length()==0){
				model.addAttribute("myMessage", "添加管理员账户失败：密码不能为空");
			}else if (admin.getName().length()==0){
				model.addAttribute("myMessage", "添加管理员账户失败：网名不能为空");
			}else if (adminService.existsUsername(admin.getUsername())) {
				model.addAttribute("myMessage", "账户创建失败：账户名已存在，请选择其他的账户名！");
			}else {
					adminService.saveAdmin(admin);
				model.addAttribute("myMessage", "添加管理员账户成功！");
			}
		return "/jsp/backstage/adminmanage/adminadd.jsp";
	}

	//跳转到管理员修改页面
	@RequestMapping(value = "/backstage/adminmanage/toUpdateAdmin", method = RequestMethod.GET)
	public String toUpdateAdmin(Model model,Integer id) {
		model.addAttribute("admin",adminService.getAdmin(id));
		return "/jsp/backstage/adminmanage/adminupdate.jsp";
	}
	//执行修改管理账户的基本信息
	@RequestMapping(value = "/backstage/adminmanage/doUpdateAdmin", method = RequestMethod.POST)
	public String doUpdateAdmin(HttpSession session,Model model,Admin admin){
		admin.setUsername(admin.getUsername().trim());
		admin.setName(admin.getName().trim());
		if (admin.getUsername().length()==0){
			model.addAttribute("myMessage","账户名不能为空");
		}else if (admin.getName().length()==0){
			model.addAttribute("myMessage","网名不能为空");
		}else if (adminService.existsAdmin(admin.getUsername(),admin.getId())==true){
			model.addAttribute("myMessage","账户名重名");
		}else {
			adminService.updateAdmin(admin);
			model.addAttribute("myMessage", "基本信息修改成功");
			}
		return "/jsp/backstage/adminmanage/adminupdate.jsp";
	}
}
