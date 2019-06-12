<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 详情</title>
<link href="<%=basePath%>jsp/shop/resources/css/shopdetail.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content">
			<div class="block">
				<div class="crumb">
					<ul>
						<li><a href="<%=basePath%>shop/index">首页</a></li>
						<li><span>/</span></li>
						<li><a id="types" href="#">今日新品</a></li>
						<li><span>/</span></li>
						<li><a id="lists" href="#">商品详情</a></li>
					</ul>
				</div>
				<div class="block-wrap">
					<h3> ${requestScope.product.name} </h3>
					<div>
						<div class="images">
							<div class="img-wrap">
								<img alr="" src="<%=basePath%>${product.picUrl}">
							</div>
							<ul>
								<li><a class="item" href="shopdetial.html"><img alr="" src="<%=basePath%>${product.picUrl}"></a></li>
								<li><a class="item" href="shopdetial.html"><img alr="" src="<%=basePath%>${product.picUrl}"></a></li>
								<li><a class="item" href="shopdetial.html"><img alr="" src="<%=basePath%>${product.picUrl}"></a></li>
								<li><a class="item" href="shopdetial.html"><img alr="" src="<%=basePath%>${product.picUrl}"></a></li>
							</ul>
						</div>
						<div class="detials">
							<ul>
								<li class="hot">优惠活动：11:30-14:30点餐7折</li>
								<li>促销价：<em class="hot">${requestScope.product.price}</em></li>
								<li>
									<div class="item-wrap">
										<div class="item">原价：<span>${product.originalPrice}</span></div>
										<div class="item">累计销量：1320 份</div>
									</div>
								</li>
								<li class="detial-wrap">
									<label>详情：</label>
									<div class="detial">
										<%--“西湖醋鱼”是杭州名菜中的看家菜。如今烹制西湖醋鱼最为有名的是孤山南麓的百年老店“楼外楼”。西湖醋鱼，又称"叔嫂传珍"，传说是古时嫂嫂给小叔烧过一碗加糖加醋的鱼而来的。选用体态适中的草鱼，最好先在清水氽熟，要掌握火候。装盘后淋上糖醋芡汁。成菜色泽红亮，肉质鲜嫩，酸甜可口，略带蟹味。--%>
											${product.description}
									</div>
								</li>
								<li class="form-wrap">
									<form <%--action="<%=basePath%>shop/toShopCart?id=${product.productId}?number=${product.number}" method="post"--%>>
										数量：
										<div class="input-wrap">
											<button name="toReduceCart" class="sub">-</button>
											<input name="numberOfSale" type="text" class="number" value="1">
											<button name="toAddCart" class="add">+</button>
											<%--<button class="sub">-</button>
											<input  type="text" class="number" value="1">
											<button class="add">+</button>--%>
										</div> 
										库存<span class="numbers">${product.number}</span>份
										<div class="btn-wrap">
											<%--<button class="buy">立刻购买</button>
											<button class="add">加入购物车</button>--%>
												<button class="buy" disabled="true">立刻购买</button>
												<button name="putCart" class="add">加入购物车</button>
										</div>
									</form>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr color="#e3e3e2">
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>
	</div>
</body>
</html>