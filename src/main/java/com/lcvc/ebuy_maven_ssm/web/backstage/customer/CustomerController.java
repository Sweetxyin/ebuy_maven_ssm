package com.lcvc.ebuy_maven_ssm.web.backstage.customer;


import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {

	@Resource
	private CustomerService customerService;

	//跳转到客户管理页面
	@RequestMapping(value = "/backstage/customer/toCustomer", method = RequestMethod.GET)
	public String toCustomer(Model model) {
		model.addAttribute("list",customerService.getCustomerList());
		return "/jsp/backstage/customer/customer.jsp";
	}

	//跳转到添加客户页面
	@RequestMapping(value = "/backstage/customer/toAddCustomer", method = RequestMethod.GET)
	public String toAddCustomer(HttpServletRequest request) {
		return "/jsp/backstage/customer/customeradd.jsp";
	}

	//执行添加客户操作
	@RequestMapping(value = "/backstage/customer/doAddCustomer", method = RequestMethod.POST)
	public String doAddCustomer( Model model, HttpSession session, Customer customer) {
		customer.setUsername(customer.getUsername().trim());
		customer.setName(customer.getName().trim());
		if (customer.getUsername().length()==0){
			model.addAttribute("myMessage", "添加客户失败：账户名不能为空");
		}else if (customer.getName().length()==0){
			model.addAttribute("myMessage", "添加客户失败：姓名为空");
		}
		else {
			customerService.saveCustomer(customer);
			model.addAttribute("customer",null);
			model.addAttribute("myMessage", "添加客户成功！");
		}
		return "/jsp/backstage/customer/customeradd.jsp";
	}

	//执行删除客户操作
	@ResponseBody
	@RequestMapping(value = "/backstage/customer/doDeleteCustomer", method = RequestMethod.GET)
	public Map<String,Object> doDeleteCustomer(Model model, HttpSession session, Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer customer=(Customer) session.getAttribute("customer") ;
		customerService.deleteCustomer(id);
		model.addAttribute("list",customerService.getCustomerList());
		map.put("status", 1);
		return map;

	}


	//跳转到客户信息修改页面
	@RequestMapping(value = "/backstage/customer/toUpdateCustomer", method = RequestMethod.GET)
	public String toUpdateCustomer(Model model,Integer id) {
		model.addAttribute("customer",customerService.getCustomer(id));
		return "/jsp/backstage/customer/customerupdate.jsp";
	}
	//执行修改客户的基本信息
	@RequestMapping(value = "/backstage/customer/doUpdateCustomer", method = RequestMethod.POST)
	public String doUpdateCustomer(HttpSession session,Model model,Customer customer){
		customer.setUsername(customer.getUsername().trim());
		customer.setName(customer.getName().trim());
		if (customer.getUsername().length()==0){
			model.addAttribute("myMessage", "编辑客户信息失败：账户名不能为空");
		}else if (customer.getName().length()==0){
			model.addAttribute("myMessage", "编辑客户信息失败：姓名为空");
		}
		else {
			customerService.updateCustomer(customer);
			model.addAttribute("myMessage", "修改客户信息成功！");
		}
		return "/jsp/backstage/customer/customerupdate.jsp";
	}

}
