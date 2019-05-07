package com.lcvc.ebuy_maven_ssm.web.backstage.customer;


import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Resource
	private CustomerService customerService;

	//跳转到客户管理页面
	@RequestMapping(value = "/backstage/customer/toCustomer", method = RequestMethod.GET)
	public String toCustomer(HttpServletRequest request) {
		request.setAttribute("list",customerService.getCustomerList());
		return "/jsp/backstage/customer/customer.jsp";
	}

	//跳转到添加客户页面
	@RequestMapping(value = "/backstage/customer/toAddCustomer", method = RequestMethod.GET)
	public String toAddCustomer(HttpServletRequest request) {
		return "/jsp/backstage/customer/customeradd.jsp";
	}

	//执行添加客户操作
	@RequestMapping(value = "/backstage/customer/doAddCustomer", method = RequestMethod.POST)
	public String doAddCustomer(HttpServletRequest request, HttpSession session,Customer customer) {
		customer.setUsername(customer.getUsername().trim());
		customer.setName(customer.getName().trim());
		if (customer.getUsername().length()==0){
			request.setAttribute("myMessage", "添加客户失败：账户名不能为空");
		}else if (customer.getName().length()==0){
			request.setAttribute("myMessage", "添加客户失败：姓名为空");
		}
		else {
			customerService.saveCustomer(customer);
			request.setAttribute("myMessage", "添加客户成功！");
		}
		return "/jsp/backstage/customer/customeradd.jsp";
	}

	//执行删除产品分类操作
	@RequestMapping(value = "/backstage/customer/doDeleteCustomer", method = RequestMethod.GET)
	public String doDeleteCustomer(HttpServletRequest request, HttpSession session,Integer id) {
		Customer customer=(Customer) session.getAttribute("customer") ;
		customerService.deleteCustomer(id);
		request.setAttribute("list",customerService.getCustomerList());
		return "/jsp/backstage/customer/customer.jsp";
	}

}
