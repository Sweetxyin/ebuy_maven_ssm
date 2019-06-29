<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 列表</title>
<link href="<%=basePath%>jsp/shop/resources/css/shoplists.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content">
			<div class="block">
				<div class="crumb">
					<ul>
						<li><a href="index">首页</a></li>
						<li><span>/</span></li>
						<li><a id="types" href="#">今日新品</a></li>
						<li><span>/</span></li>
						<li><a id="lists" href="#">商品列表</a></li>
					</ul>
				</div>
				<div class="quick">
					<button class="all cur">全部</button>
					<button class="buy">已定</button>
					<button class="price">价格</button>
					<button class="sales">销量</button>
				</div>
				<div class="block-wrap">
					<c:forEach var="product" items="${requestScope.product}">
					<div class="item">
					<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 250px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
					<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
					<h3>${product.name}<button class="buy">购买</button></h3>
				</div>
					</c:forEach>

				</div>
				<div class="pager">
			        <button>&lt;&lt;</button>
					<button onclick="javascritpt:window.location.href='<%=basePath%>/shop/toProduct?page=1'">首页</button>
					<button onclick="javascritpt:window.location.href='<%=basePath%>/shop/toProduct?page=${requestScope.page-1}'">上一页</button>
					<button onclick="javascritpt:window.location.href='<%=basePath%>/shop/toProduct?page=${requestScope.page+1}'">下一页</button>
					<button onclick="javascritpt:window.location.href='<%=basePath%>/shop/toProduct?page=${requestScope.maxPage}'">尾页</button>

					<button>&gt;&gt;</button>









				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>
	</div>
</body>
</html>