package com.lcvc.ebuy_maven_ssm.web.backstage.producttype;


import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductTypeController {

	@Resource
	private ProductTypeService productTypeService;

	//跳转到产品分类管理页面
	@RequestMapping(value = "/backstage/producttype/toProductType", method = RequestMethod.GET)
	public String toProductType(HttpServletRequest request) {
		request.setAttribute("list",productTypeService.getProductTypeList());
		return "/jsp/backstage/producttype/producttype.jsp";
	}

	//跳转到添加产品分类页面
	@RequestMapping(value = "/backstage/producttype/toAddProductType", method = RequestMethod.GET)
	public String toAddProductType(HttpServletRequest request) {
		return "/jsp/backstage/producttype/producttypeadd.jsp";
	}
	//执行添加产品分类操作
	@RequestMapping(value = "/backstage/producttype/doAddProductType", method = RequestMethod.POST)
	public String doAddProductType(HttpServletRequest request, HttpSession session,ProductType productType) {
		productType.setName(productType.getName().trim());
		productType.setImageUrl(productType.getImageUrl().trim());
		if (productType.getName().length()==0){
			request.setAttribute("myMessage", "添加产品分类失败：产品分类名称不能为空");
		}else if (productType.getImageUrl().length()==0){
			request.setAttribute("myMessage", "添加产品分类失败：图片不能为空");
		}else if (productType.getOrderNum().equals("")){
			request.setAttribute("myMessage", "添加产品分类失败：优先级不能为空");
		}
		else {
			productTypeService.saveProductType(productType);
			request.setAttribute("myMessage", "添加产品分类成功！");
		}
		return "/jsp/backstage/producttype/producttypeadd.jsp";
	}

	//执行删除产品分类操作
	@RequestMapping(value = "/backstage/producttype/doDeleteProductType", method = RequestMethod.GET)
	public String doDeleteProductType(HttpServletRequest request, HttpSession session,Integer id) {
		ProductType productType=(ProductType) session.getAttribute("productType");
		productTypeService.deleteProductType(id);
		request.setAttribute("list",productTypeService.getProductTypeList());
		return "/jsp/backstage/producttype/producttype.jsp";
	}
	//跳转到产品分类管理修改页面
	@RequestMapping(value = "/backstage/producttype/toUpdateProductType", method = RequestMethod.GET)
	public String toUpdateProductType(HttpServletRequest request,Integer id) {
		request.setAttribute("productType",productTypeService.getProductType(id));
		return "/jsp/backstage/producttype/producttypeupdate.jsp";
	}
	//执行修改产品分类管理的基本信息
	@RequestMapping(value = "/backstage/producttype/doUpdateProductType", method = RequestMethod.POST)
	public String doUpdateProductType(HttpSession session,HttpServletRequest request,ProductType productType){
		productType.setName(productType.getName().trim());
		productType.setImageUrl(productType.getImageUrl().trim());
		if (productType.getName().length()==0){
			request.setAttribute("myMessage", "修改产品分类失败：产品分类名称不能为空");
		}else if (productType.getImageUrl().length()==0){
			request.setAttribute("myMessage", "修改产品分类失败：图片不能为空");
		}else if (productType.getOrderNum().equals("")){
			request.setAttribute("myMessage", "修改产品分类失败：优先级不能为空");
		}else {
			productTypeService.updateProductType(productType);
			request.setAttribute("myMessage", "修改产品分类成功");
		}
		return "/jsp/backstage/producttype/producttypeupdate.jsp";
	}





}
