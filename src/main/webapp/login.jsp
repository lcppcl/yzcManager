<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<LINK rel="Bookmark" href="/pig.png" >
<LINK rel="Shortcut Icon" href="/pig.png" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
	type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>养殖场 - 后台登录</title>
<style>
	#reset{
		margin-left: 88px;
	}
</style>
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" id="loginFormData">
				<input type="hidden" value="" id="code" />
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="account" name="account" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<%--<div class="row cl">--%>
					<%--<div class="formControls col-xs-8 col-xs-offset-3">--%>
						<%--<input class="input-text size-L" name="verify" id="verify"--%>
							<%--onkeyup="sendCode(this.value);" type="text" maxlength="4" placeholder="验证码"--%>
							<%--style="width: 150px;"> <img style="margin-left:30px;width: 120px;height: 39px" src="code.do"--%>
							<%--onclick="changeCode(this)"> <label style="margin-left: 15px" id="res"></label>--%>
					<%--</div>--%>
				<%--</div>--%>
				<%--<div class="row cl">--%>
					<%--<div class="formControls col-xs-8 col-xs-offset-3">--%>
						<%--<label for="online"> <input type="checkbox" name="online"--%>
							<%--id="online" value=""> 记住密码--%>
						<%--</label>--%>
					<%--</div>--%>
				<%--</div>--%>
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="login" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input id="reset" type="reset" class="btn btn-default radius size-L" value="&nbsp;清&nbsp;&nbsp;&nbsp;&nbsp;空&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright @2016 ：环球畜牧养殖中心</div>
<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="../lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="../lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="../lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="../static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="../static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginFormData").validate({
			rules:{
				account:{
                    minlength:5,
                    maxlength:18,
					required:true,
				},
				password:{
                    minlength:5,
                    maxlength:18,
					required:true,
				}
			},
			onkeyup:false,
			focusCleanup:true,
			success:"valid",
			submitHandler:function(){
				var account = $("#account").val();
				var password = $("#password").val();
				$.post("/user/checkLogin.do", {
					"account" : account,
					"password" : password
				}, function(data) {
					if(data.messageCode == 906){
						sessionStorage.setItem("username", data.result.emp_name);
						sessionStorage.setItem("userId", data.result.emp_id);
						sessionStorage.setItem("deptId", data.result.emp_dept_id);
						window.location.href = "index.jsp";
					} else {
                        layer.msg(data.message,{icon:1,time:1000});
                        $("#account").focus();
					}
				}, "json");
			}
		});
	});
</script>
</body>
</html>