package com.lcvc.ebuy_maven_ssm.web.backstage;import javax.annotation.Resource;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpSession;import com.lcvc.ebuy_maven_ssm.model.Admin;import com.lcvc.ebuy_maven_ssm.service.AdminService;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;import java.util.HashMap;import java.util.Map;@Controller@RequestMapping(value = "/backstage")public class LoginLogoutController {	@Resource	private AdminService adminService;	/*	 * 显示登录页面，该登录页面是使用Ajax进行登录	 */	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)	public String toLogin() {		return "/jsp/backstage/login.jsp";	}	/*	 * 用于判断登录	 */	@ResponseBody	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)	public Map<String, Object> doLogin(String username, String password, HttpSession session) {		Map<String, Object> map = new HashMap<String, Object>();		Admin admin = adminService.login(username, password);		if (admin != null) {			session.setAttribute("admin", admin);			map.put("status", 1);			//return "redirect:/backstage/index";		} else {			//request.setAttribute("myMessage", "登录失败:密码错误");			//	return "/jsp/backstage/login.jsp";			map.put("status", 0);			map.put("myMessage", "登录失败:密码错误");		}		return map;	}	/*	 * 显示登录页面，该登录页面是使用Ajax进行登录	 */	@RequestMapping(value = "/index", method = RequestMethod.GET)	public String index() {		return "/jsp/backstage/main.jsp";	}		/*	 * 显示登录页面，该登录页面是使用Ajax进行登录	 */	@RequestMapping(value = "/logout", method = RequestMethod.GET)	public String doLogout(HttpSession session) {		session.removeAttribute("admin");		return "/jsp/backstage/login.jsp";	}}