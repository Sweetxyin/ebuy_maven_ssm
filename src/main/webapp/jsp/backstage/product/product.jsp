<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
<link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>jsp/backstage/js/jquery.js"></script>

    <style>
        .pzt{
            color: #9b9b9b;
        }
    </style>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

    $("a[name='deleteProduct']").click(function () {
        var url=$(this).attr("href");
        var name=$(this).attr("id")
        if (window.confirm("确认删除该账户("+name+")吗？")){
            return true;//执行链接跳转
        }else {
            return false;//不执行链接的跳转
        }
    });
});

</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理账户管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
            <a href="<%=basePath%>/backstage/product/toAddProduct">
                <li class="click"><span><img src="<%=basePath%>jsp/backstage/images/t01.png" /></span>添加产品分类</li>
            </a>
       <%-- <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>--%>
        </ul>
        
      <%--
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    --%>
    </div>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>产品图片<i class="sort"></i></th>
            <th>产品名</th>
            <th>产品分类</th>
            <th>产品价格</th>
            <th>发布人</th>
            <th>是否上架</th>
            <th>库存</th>
            <th>点击数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${requestScope.list}">
            <tr>
                <td><input name="" type="checkbox" value=""/></td>
                <td>${product.picUrl}</td>
                <td>${product.name}
                       <p class="pzt"> 发布时间：<fmt:formatDate value="${product.createTime}" pattern="yyyy年MM月dd日 HH:mm" /></p>
                </td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>admin</td>
                <td>上架中</td>
                <td>${product.number}</td>
                <td>${product.click}</td>
                <td><a href="<%=basePath%>backstage/product/toUpdateProduct?id=${product.id}" class="tablelink">修改</a>
                    <a id="${product.name}" name="deleteProduct"
                       href="<%=basePath%>/backstage/product/doDeleteProduct?id=${product.id}" class="tablelink"> 删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${fn:length(list)}</i>条记录<%--，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页--%></div>

    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
