<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 首页</title>
	<link href="<%=basePath%>jsp/shop/lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>jsp/shop/resources/css/index.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		.wrap .content .block .block-wrap .item {
			width: 265px;
			height: 275px;
			padding: 10px;
			display: inline-block;
			border: 1px solid #cbbb80;
			margin: 8px 15px 0 15px;
		}
	</style>

</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content ">
			<div class="logo ">
				<%--<img alt="" src="<%=basePath%>jsp/shop/resources/images/index-logo.jpg">--%>
					<div id="myCarousel" class="carousel slide container-fluid">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="<%=basePath%>jsp/shop/resources/images/bg3.jpg" alt="First slide">
							</div>
							<div class="item">
								<img src="<%=basePath%>jsp/shop/resources/images/bg2.jpg" alt="Second slide">
							</div>
							<div class="item">
								<img src="<%=basePath%>jsp/shop/resources/images/bg1.jpg" alt="Third slide">
							</div>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="carousel-control left" href="#myCarousel"
						   data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span></a>
						<a class="carousel-control right" href="#myCarousel"
						   data-slide="next">&rsaquo;</a>
					</div>


				<div class="menu">
					<ul>
						<c:forEach var="productType" items="${requestScope.productType}">
							<li><a href="<%=basePath%>shop/toProductType?id=${productType.id}"><img class="left" alt="" src="<%=basePath%>${productType.imageUrl}">${productType.name}<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						</c:forEach>

					</ul>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="new">今日新品</label>
					<a href="<%=basePath%>shop/toProduct">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<c:forEach var="product" items="${requestScope.newProduct}">
					<div class="item">
						<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 240px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
						<label><em> ${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
						<h3>${product.name}</h3>
					</div>
					</c:forEach>

				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="hot">热门订单</label>
					<a href="<%=basePath%>shop/toProduct">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<c:forEach var="product" items="${requestScope.hotProduct}">
					<div class="item">
						<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 240px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
						<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
						<h3>${product.name}</h3>
					</div>
					</c:forEach>

				</div>
			</div>
			<div class="block">
				<div class="title noborder">
					<label class="act">活动推介</label>
					<a href="<%=basePath%>shop/toProduct" style="display: none;">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap border">
					<div class="crumb">
						<ul>
							<li class="cur"><a href="#">限时秒杀</a></li>
							<li><a href="#">拼团</a></li>
							<li><a href="#">特惠</a></li>
							<li><a href="#">热门排行</a></li>
						</ul>
						<a href="<%=basePath%>jsp/shop/shoplists.jsp">更多&gt;&gt;</a>
					</div>
					<c:forEach var="product" items="${requestScope.timerProduct}">
						<div class="item">
							<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 220px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
							<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
							<h3>${product.name}</h3>
						</div>
					</c:forEach>

				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>
	</div>
	<script src="<%=basePath%>jsp/shop/lib/jquery/jquery-1.12.4.js"></script>
	<script src="<%=basePath%>jsp/shop/lib/bootstrap/js/bootstrap.js"></script>

</body>
</html>