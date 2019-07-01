<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 购物车</title>
<link href="<%=basePath%>jsp/shop/resources/css/shopcart.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>jsp/shop/lib/jquery/jquery-1.12.4.js"></script>
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

            /*  $("a[name='deleteProduct']").click(function () {
                  var url=$(this).attr("href");
                  var name=$(this).attr("id")
                  if (window.confirm("确认删除该账户("+name+")吗？")){
                      return true;//执行链接跳转
                  }else {
                      return false;//不执行链接的跳转
                  }
             */
            $("a[name='deleteProduct']").click(function () {
                $this=$(this);
                var name=$(this).attr("id");
                if(window.confirm("确认删除该商品("+name+")吗？删除后无法恢复！")){
                    var url=$(this).attr("href");
                    $.get(url,
                        function (data) {
                            if(data.status==1){
                                //alert("删除成功");
                                $this.parent().parent().remove();
                            }
                        }
                    );
                }
                return false;
            });
        });

	</script>
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 118px;"></iframe>
		<div class="content">
			<div class="thead">
				<em class="th1">购物车</em>
				<em class="th2">单价</em>
				<em class="th3">数量</em>
				<em class="th4">总价</em>
				<em class="th5">操作</em>
			</div>
			<c:set var="product " scope="request" value=""/>
			<c:choose>
				<c:when test="${sessionScope.product.id==null}">
					<div class="tbody">
						<c:forEach var="product" items="${cart}">
							<div class="tr">
					<span class="td td1">
						<input type="checkbox" class="check">
					</span>
								<span class="td td2">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>${product.key.picUrl}"></a>
						<span> ${product.key.name}</span>
					</span>
								<span class="td td3">
						<span>${product.key.originalPrice}</span>
						<b>${product.key.price}</b>
					</span>
								<span class="td td4">
						<div class="input-wrap">
							<button class="sub">-</button>
							<input type="text" class="number" value="1">
							<button class="add">+</button>
						</div>
					</span>
								<span class="td td5">
						<b>${product.key.price}</b>
					</span>
								<span class="td td6">
						<%--<a href="#" class="delete">删除</a>--%>
									<a id="${product.key.name}" name="deleteProduct"
									   href="<%=basePath%>/backstage/product/doDeleteProduct?id=${product.key.id}" class="tablelink"> 删除</a>
					</span>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>
					<a href="/shop/index">购物车是空的哦，请先购物</a>
				</c:otherwise>
			</c:choose>

			<div class="tfoot">
				<em class="tf tf1">
					<input type="checkbox" class="checks">
				</em>
				<em class="tf tf2">
					<a href="#" class="check-all">全选</a>
					<a href="#" class="check-delete">删除</a>
				</em>
				<em class="tf tf3">
					&nbsp;
				</em>
				<em class="tf tf4">
					已选择<span class="numbers">4</span>件&nbsp;&nbsp;&nbsp;&nbsp;合计：<span class="amounts">￥48.00</span>
				</em>
				<em class="tf tf5">
					<button class="btn-submit">结算</button>
				</em>
			</div>
			<hr color="#d2364c">

		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.html" style="height: 120px;"></iframe>

	</div>
	<script type="text/javascript">
		// 获取全选复选框
		var checks = document.getElementsByClassName("checks");
		// 获取全选超链接a
		var checkall = document.getElementsByClassName("check-all");
		// 获取全部tr里面的复选框
		var check = document.getElementsByClassName("check");
		// 全选点击事件
		function fn_checkall() {
			alert(checks);
			if(checks.checked) {
				check.checked = true;
			} else {
				check.checked = false;
			}
		}
		// 绑定全选事件
		checks.onclick = function() {
			fn_checkall();
		}
		checkall.onclick = function() {
			fn_checkall();
		}
		// 获取遍历tr行数据
		var trs = document.getElementsByClassName("tr");
		for(var i = 0; i < trs.length; i++) {
			trs[i].getElementsByClassName('sub').onclick = function() {
				var input = this.parentNode.getElementsByClassName('number');
				var num = Number(input.value || '0');
				if(num == 1) {
					num = 1;
				} else {
					num = num - 1;
				}
				alert(num);
			};
		}
	</script>
</body>
</html>