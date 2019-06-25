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

		/*设置左上角图片的位置和宽高*/
		.navbar-brand>img {
			height: auto;
			width: 250px;
			margin-right: 5px;
			margin-top: 5px;
		}
		/*设置选项卡菜单的字体颜色*/
		.nav-pills>li>a {
			color: #8e908d;
		}
		/*设置选项卡菜单鼠标悬停和获取焦点时背景色和字体颜色*/
		.nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover {
			color: #fff;
			background-color: #5A9522;
		}
		.choose {
			border: 1px solid silver;
		}
		/*设置选项卡内容的位置*/
		.tab-content {
			margin: 5px;
			text-align: center;/*居中显示*/
		}
	</style>

</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content">
			<div class="logo">
				<img alt="" src="<%=basePath%>jsp/shop/resources/images/index-logo.jpg">
				<div class="menu">
					<ul>

						<c:forEach var="productType" items="${requestScope.productType}">
							<li><a href="<%=basePath%>shoplists.html"><img class="left" alt="" src="<%=basePath%>${productType.imageUrl}"<%--/jsp/shop/resources/images/menu-icon01.png"--%>>${productType.name}<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						</c:forEach>
						<%--<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-icon01.png">小吃快餐<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon02.png">甜点饮品<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon03.png">西&emsp;&emsp;餐<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon04.png">火&emsp;&emsp;锅<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon05.png">汤/粥/炖菜<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon06.png">小&emsp;&emsp;炒<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon07.png">凉菜/时蔬<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon08.png">主&emsp;&emsp;食<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-icon09.png">水&emsp;&emsp;果<img class="right" alt="" src="<%=basePath%>/jsp/shop/resources/images/menu-right.png"></a></li>--%>

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
						<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 220px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
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
						<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 220px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
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
						<ul class="nav nav-pills" role="tablist" >
							<li role="presentation" class="cur active "><a href="#xsms" role="tab" data-toggle="tab">限时秒杀</a></li>
							<li role="presentation"><a href="#pt" role="tab" data-toggle="tab">拼团</a></li>
							<li role="presentation"><a href="#th" role="tab" data-toggle="tab">特惠</a></li>
							<li role="presentation"><a href="#rmph" role="tab" data-toggle="tab">热门排行</a></li>
						</ul>
						<a href="<%=basePath%>jsp/shop/shoplists.jsp">更多&gt;&gt;</a>
					</div>
					<%--限时秒杀的商品--%>

					<c:forEach var="product" items="${requestScope.timerProduct}">
					<div role="tabpanel" class="tab-pane active item"   id="xsms">
							<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 220px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
							<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
							<h3>${product.name}</h3>
					</div>
					</c:forEach>


					<%--拼团的商品--%>
					<c:forEach var="product" items="${requestScope.hotProduct}">
						<div role="tabpanel" class="tab-pane item hide" id="pt">
							<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 250px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
							<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
							<h3>${product.name}</h3>
						</div>
					</c:forEach>

					<%--特惠的商品--%>
					<c:forEach var="product" items="${requestScope.timerProduct}">
						<div role="tabpanel" class="tab-pane item hide" id="th">
							<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 250px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
							<label><em>${product.price}</em><span>${product.originalPrice}</span>67人付款</label>
							<h3>${product.name}</h3>
						</div>
					</c:forEach>

					<%--热门排行的商品--%>
					<c:forEach var="product" items="${requestScope.timerProduct}">
						<div role="tabpanel" class="tab-pane item hide" id="rmph">
							<a href="<%=basePath%>shop/toShopDetial?id=${product.id}"><img alt="" style="width: 250px;height: 180px;" src="<%=basePath%>${product.picUrl}"></a>
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
	<script src="<%=basePath%>jsp/shop/lib/bootstrap/jquery-1.12.4.js"></script>
	<script src="<%=basePath%>jsp/shop/lib/jquery/js/bootstrap.js"></script>

</body>
</html>