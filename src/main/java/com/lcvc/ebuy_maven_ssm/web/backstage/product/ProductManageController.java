package com.lcvc.ebuy_maven_ssm.web.backstage.product;

import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductManageController {

    @Resource
    private ProductTypeService productTypeService;
    //跳转到管理员管理页面
    @RequestMapping(value = "/backstage/product/toTypeProduct", method = RequestMethod.GET)
    public String toTypeProduct(HttpServletRequest request) {
        request.setAttribute("list",productTypeService.getProductList());
        return "/jsp/backstage/product/producttype.jsp";
    }
}
