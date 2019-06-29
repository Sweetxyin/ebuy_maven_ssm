<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 页头</title>
<link href="resources/css/header.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="header">
		<div class="toolbar">
			<a href="<%=basePath%>shop/index" target="top">&nbsp;首页&nbsp;</a>
			<c:set var="admin" scope="request" value=""/>
			<c:choose>
				<c:when test="${sessionScope.customer.name==null}">
					<a href="<%=basePath%>shop/toSignin" target="top">&nbsp;登录/注册&nbsp;</a>
				</c:when>
				<c:otherwise>
					${sessionScope.customer.name}，你好<a href="<%=basePath%>shop/logout" target="_parent">（退出）</a>
				</c:otherwise>
			</c:choose>

			<a href="<%=basePath%>shop/shopcart.jsp" target="top">&nbsp;购物车&nbsp;</a>
		</div>
		<div class="content">
			<img alt="" src="resources/images/logo.png">
			<form class="search-wrap" target="_top" action="<%=basePath%>shop/toSearchList?name=${product.name}">
				<input type="text" id="s" name="name">
				<button id="submit">搜索</button>
			</form>
		</div>
		<div class="menu">
			<ul>
				<li class="cur"><a href="index.jsp" target="top">全部分类</a></li>
				<li><a href="<%=basePath%>shop/index" target="top">首页</a></li>
				<li><a href="<%=basePath%>shop/toProduct" target="top"<%-- style="color: #d2364c;"--%>>今日新品</a></li>
				<li><a href="<%=basePath%>shop/toProduct" target="top">热门订单</a></li>
				<li><a href="<%=basePath%>shop/toProduct" target="top">限时秒杀</a></li>
				<li><a href="<%=basePath%>shop/toProduct" target="top">拼团</a></li>
				<li><a href="<%=basePath%>shop/toProduct" target="top">特惠</a></li>
			</ul>
		</div>
	</div>
</body>
</html>