<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 首页</title>
<link href="<%=basePath%>jsp/proscenium/resources/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/proscenium/header.html" style="height: 168px;"></iframe>
		<div class="content">
			<div class="logo">
				<img alt="" src="<%=basePath%>jsp/proscenium/resources/images/index-logo.jpg">
				<div class="menu">
					<ul>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>/jsp/proscenium/resources/images/menu-icon01.png">小吃快餐<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<%--<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>/jsp/proscenium/resources/images/menu-icon01.png">小吃快餐<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon02.png">甜点饮品<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon03.png">西&emsp;&emsp;餐<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon04.png">火&emsp;&emsp;锅<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon05.png">汤/粥/炖菜<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon06.png">小&emsp;&emsp;炒<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon07.png">凉菜/时蔬<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon08.png">主&emsp;&emsp;食<img class="right" alt="" src="resources/images/menu-right.png"></a></li>
						<li><a href="shoplists.html"><img class="left" alt="" src="<%=basePath%>jsp/proscenium/resources/images/menu-icon09.png">水&emsp;&emsp;果<img class="right" alt="" src="resources/images/menu-right.png"></a></li>--%>
					</ul>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="new">今日新品</label>
					<a href="shoplists.html">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title">
					<label class="hot">热门订单</label>
					<a href="shoplists.html">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap">
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title noborder">
					<label class="act">活动推介</label>
					<a href="shoplists.html" style="display: none;">更多&gt;&gt;</a>
				</div>
				<div class="block-wrap border">
					<div class="crumb">
						<ul>
							<li class="cur"><a href="#">限时秒杀</a></li>
							<li><a href="#">拼团</a></li>
							<li><a href="#">特惠</a></li>
							<li><a href="#">热门排行</a></li>
						</ul>
						<a href="shoplists.html">更多&gt;&gt;</a>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
					<div class="item">
						<a href="shopdetial.html"><img alt="" src="<%=basePath%>jsp/proscenium/resources/images/foods/01.jpg"></a>
						<label><em>￥18.00</em><span>￥20.00</span>67人付款</label>
						<h3>回锅肉炒西芹</h3>
					</div>
				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/proscenium/footer.html" style="height: 120px;"></iframe>
	</div>
</body>
</html>