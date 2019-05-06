package com.lcvc.ebuy_maven_ssm.web.backstage.product;


import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Resource
	private ProductService productService;



	//跳转到产品管理页面
	@RequestMapping(value = "/backstage/product/toProduct", method = RequestMethod.GET)
	public String toProduct(HttpServletRequest request) {
		request.setAttribute("list",productService.getProductList());
		return "/jsp/backstage/product/product.jsp";
	}
	//执行删除产品操作
	@RequestMapping(value = "/backstage/product/doDeleteProduct", method = RequestMethod.GET)
	public String doDeleteProduct(HttpServletRequest request, HttpSession session,Integer id) {
		Product product=(Product) session.getAttribute("product");
		productService.deleteProduct(id);
		request.setAttribute("list",productService.getProductList());
		return "/jsp/backstage/product/product.jsp";
	}

	//跳转到添加产品页面
	@RequestMapping(value = "/backstage/product/toAddProduct", method = RequestMethod.GET)
	public String toAddProduct(HttpServletRequest request) {
		return "/jsp/backstage/product/productadd.jsp";
	}
	//执行添加产品操作
	@RequestMapping(value = "/backstage/product/doAddProduct", method = RequestMethod.POST)
	public String doAddProduct(HttpServletRequest request, HttpSession session,Product product) {

		productService.saveProduct(product);

		return "/jsp/backstage/product/productadd.jsp";
	}



}