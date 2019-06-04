package com.lcvc.ebuy_maven_ssm.web.backstage.product;


import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
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
public class ProductController {

	@Resource
	private ProductService productService;


	//跳转到产品管理页面,并执行分页操作
	@RequestMapping(value = "/backstage/product/toProduct", method = RequestMethod.GET)
	public String toProduct(Model model, Integer page) {
		if (page==null){//如果页面为空，就显示第一页
			page=1;
		}else {
			if (page < 1) {
				page = 1;
			}
		}
		model.addAttribute("list",productService.getProductList(page));
		model.addAttribute("page",page);
		model.addAttribute("maxPage",productService.maxPage());
		return "/jsp/backstage/product/product.jsp";
	}
	//执行删除产品操作
	@ResponseBody
	@RequestMapping(value = "/backstage/product/doDeleteProduct", method = RequestMethod.GET)
	public Map<String,Object> doDeleteProduct(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Product product=(Product) session.getAttribute("product");
		productService.deleteProduct(id);
		map.put("status", 1);
		return map;
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

	//跳转到产品管理修改页面
	@RequestMapping(value = "/backstage/product/toUpdateProduct", method = RequestMethod.GET)
	public String toUpdateProduct(Model model,Integer id) {
		model.addAttribute("product",productService.getProduct(id));
		return "/jsp/backstage/product/productupdate.jsp";
	}
	//执行修改产品管理的基本信息
	@RequestMapping(value = "/backstage/product/doUpdateProduct", method = RequestMethod.POST)
	public String doUpdateProduct(HttpSession session,Model model,Product product){
		  productService.updateProduct(product);
		model.addAttribute("myMessage", "修改产品分类成功");

		return "/jsp/backstage/product/productupdate.jsp";
	}



}
