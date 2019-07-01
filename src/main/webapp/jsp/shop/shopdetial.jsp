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
<script>
	$('.add').click(function () {

    });

</script>
<style>
	.item1{
		text-decoration: none;
		color: #f0f9fd;
	}
</style>
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

											${product.description}
									</div>
								</li>
								<li class="form-wrap">
									<form <%--action="<%=basePath%>shop/toShopCart?id=${product.productId}?number=${product.number}" method="post"--%>>
										数量：
										<div class="input-wrap">
											<input type="button"  name="toReduceCart" class="sub" value="-"></input>
											<input name="numberOfSale" type="text" class="number" value="1">
											<input type="button" name="toAddCart" class="add" value="+"></input>
											<%--<button class="sub">-</button>
											<input  type="text" class="number" value="1">
											<button class="add">+</button>--%>
										</div> 
										库存<span class="numbers">${product.number}</span>份
										<div class="btn-wrap">
											<%--<button class="buy">立刻购买</button>
											<button class="add">加入购物车</button>--%>
												<button class="buy" disabled="true">立刻购买</button>
												<button name="putCart" class="add"><a class="item1" href="<%=basePath%>shop/toShopCart?id=${product.id}&number=1">加入购物车</a></button>
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
<script>
/*    var t = $(".number");
    $(function(){
        $(".add").click(function() {
            t.val(parseInt(t.val()) + 1); //点击加号输入框数值加1
        });
        $(".sub").click(function(){
            t.val(parseInt(t.val())-1); //点击减号输入框数值减1
            if(t.val()<=0){
                t.val(parseInt(t.val())+1); //最小值为1
            }
        });
    });*/

    $(document).ready(function(){
        $('.sub').click(function(){
            var value=parseInt($('.number').val())-1;
            $('.number').val(value);
        });
        $('.add').click(function(){
            var value=parseInt($('.number').val())+1;
            $('.number').val(value);
        });
    });

</script>
</body>
</html>