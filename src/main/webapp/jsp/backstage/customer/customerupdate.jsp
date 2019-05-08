<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css" />
<script>
 var message='${requestScope.myMessage}';
 //如果没有收到服务端发来的信息，那么就不弹出对话框
 if(message!=''){
    alert(message);
 }

</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">客户编辑</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>编辑客户</span></div>
    <form action="<%=basePath%>/backstage/customer/doUpdateCustomer" method="post">
    <ul class="forminfo">
        <li><label></label><input name="id" type="hidden" class="dfinput" value="${requestScope.customer.id}"/><i></i></li>
        <li><label>*账户名</label><input name="username" type="text" class="dfinput" value="${requestScope.customer.username}"/><i></i></li>
        <li><label>*姓名</label><input name="name" type="text" class="dfinput" value="${requestScope.customer.name}"/><i></i></li>
        <li><label>头像</label><input name="picUrl" type="text" class="dfinput" value="${requestScope.customer.picUrl}"/><i></i></li>
        <li><label>电话</label><input name="tel" type="text" class="dfinput" value="${requestScope.customer.tel}"/><i></i></li>
        <li><label>地址</label><input name="address" type="text" class="dfinput" value="${requestScope.customer.address}"/><i></i></li>
        <li><label>邮编</label><input name="zip" type="text" class="dfinput" value="${requestScope.customer.zip}"/><i></i></li>
        <li><label>电子邮箱</label><input name="email" type="text" class="dfinput" value="${requestScope.customer.email}"/><i></i></li>
        <li><label>客户简介</label><input name="intro" type="text" class="dfinput" value="${requestScope.customer.intro}"/><i></i></li>
    <li><label>&nbsp;</label>

        <input name="" type="submit" class="btn" value="编辑客户"/>

    </li>
    </ul>
    </form>
    
    </div>
</body>
</html>
