<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 登录</title>
<link href="<%=basePath%>jsp/shop/resources/css/signin.css" rel="stylesheet" type="text/css">
	<script language="JavaScript" src="<%=basePath%>jsp/backstage/js/jquery.js"></script>
	<script src="<%=basePath%>jsp/backstage/js/cloud.js" type="text/javascript"></script>

	<script language="javascript">
        //用于弹出窗口，将服务器返回的数据提交，本处用于账户提交后的状态
        function alert_myMessage(){
            var message="${requestScope.myMessage}";
            if(message!=""){
                alert(message);
            }
        }
        $(function(){
            //用于弹出窗口，将服务器返回的数据提交，本处用于账户提交后的状态
            //alert_myMessage();

            //不在任何frame里面显示该页面
            if(self.location!=top.location){
                top.location.href=self.location.href;
            }


            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })


            //处理登录按钮点击之后的事件
            $("#login_button").click(function () {
                $.post("<%=basePath%>shop/doSignin",
                    $("#myForm").serialize(),
                    function (data) {
                        if(data.status==1){
                            // alert("登录成功");
                            window.location.href="<%=basePath%>shop/index"
                        }else{
                            alert(data.myMessage);
                        }

                    }
                );

            });
        });
	</script>
</head>
<div class="wrap signin">
	<div class="content">
		<div class="title">
			<a href="<%=basePath%>shop/index">&nbsp;首页&nbsp;</a>
			<a href="<%=basePath%>shop/toSignin">&nbsp;登录/注册&nbsp;</a>
			<a href="shopcart.html">&nbsp;购物车&nbsp;</a>
		</div>
		<div class="main">
			<div class="header">
				<a href="<%=basePath%>shop/signup">注册</a>
			</div>
			<div class="logo">
				<div>
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-logo.png">
					<span>用户登陆</span>
				</div>
			</div>
			<form  id="myForm" method="post">
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-user.png">
					<input name="username" type="text" id="u" placeholder="请输入账户名">
				</div>
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-pwd.png">
					<input name="password" type="password" id="p" placeholder="请输入密码">
				</div>
				<%--<div class="input-wrap">
					<img alt="" src="resources/images/signin-cpt.png">
					<input class="sort" type="text" id="c" placeholder="请输入验证码">
					<img class="signin-cpt" alt="" src="resources/images/signin-cpts.png">
				</div>--%>
				<div class="input-wrap nobg">
					<%--<button  class="btn-inline lbtn" id="submit" >登录</button>--%>
					<input id="login_button" type="button" class="<%--loginbtn--%> btn-inline lbtn" value="登录" />
					<button  class="btn-inline" id="pback">找回密码</button>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h1>订餐热线：0772-1234567</h1>
		<p>版权所有@ 2012-2019 南方橙汁园连锁有限公司   桂ICP备90887766号  桂餐证字2010110108002888<br>
地址：桂柳市文林区中文苑路1号橙汁园大厦B座111层11号</p>
	</div>
</div>
</html>