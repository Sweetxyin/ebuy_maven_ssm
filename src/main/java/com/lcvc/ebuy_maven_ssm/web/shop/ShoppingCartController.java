package com.lcvc.ebuy_maven_ssm.web.shop;import com.lcvc.ebuy_maven_ssm.model.Product;import com.lcvc.ebuy_maven_ssm.service.ProductService;import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;import com.sun.javafx.collections.MappingChange;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import javax.annotation.Resource;import javax.servlet.http.HttpSession;import java.math.BigDecimal;import java.util.HashMap;import java.util.Map;@Controllerpublic class ShoppingCartController {	@Resource	private ProductService productService;	@Resource	private ShoppingCartService shoppingCartService;	//跳转到订单页面	@RequestMapping(value = "shop/toShopCart", method = RequestMethod.GET)	public String toShopCart(Model model, Product product, HttpSession session,int number,int id) {		Map<Product,Integer>cart=(Map<Product,Integer>)session.getAttribute("cart");		if (cart==null){			cart=new HashMap<>();//创建购物车map集合			product=productService.getProduct(product.getId());			cart.put(product,1);			session.setAttribute("cart",cart);		}else {			Integer n=cart.get(product);			if (n==null){				product=productService.getProduct(product.getId());				cart.put(product,1);			}else {				cart.put(product,1+n);			}		}		BigDecimal sum =new BigDecimal(0);		for (Product g:cart.keySet()){		}		model.addAttribute("sum",sum);		return "/jsp/shop/shopcart.jsp";	}}