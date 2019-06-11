package com.lcvc.ebuy_maven_ssm.web.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForAdminInterceptor extends HandlerInterceptorAdapter {
    /*
    在执行action里面的处理逻辑之前执行，它返回的是Boolean，这里如果我们返回true在接着执行postHandle和afterCompletion,如果我们返回false则中断执行。
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean judge=false;//默认登录失败
        HttpSession session=request.getSession();
        if (session.getAttribute("admin")!=null){//如果已经登录并且登录状态未失败
            judge=true;
        }else {
            String path=request.getContextPath();
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            response.sendRedirect(basePath+"backstage/toLogin");
        }
        return judge;
    }
}
