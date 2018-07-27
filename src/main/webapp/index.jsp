<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="Login page">
<meta name="author" content="Dieson Zuo">
<link rel="icon" href="${ctx}/static/images/favicon.ico">
<title>Green automation test - Login</title>

<link rel="stylesheet" href="${ctx}/static/css/font.css">
<link rel="stylesheet" href="${ctx}/static/css/xadmin.css">
<script type="text/javascript"
	src="${ctx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/js/xadmin.js"></script>
</head>

<body class="login-bg">

	<div class="login layui-anim layui-anim-up">
		<div class="message">Green auto test-Login</div>
		<div id="darkbannerwrap"></div>

		<form id="loginForm" action="${ctx }/index.do" method="post"
			class="layui-form">
			<input name="username" id="username" placeholder="Username"
				type="text" lay-verify="required" class="layui-input">
			<hr class="hr15">
			<input name="password" id="password" lay-verify="required"
				placeholder="Password" type="password" class="layui-input">
			<hr class="hr15">
			<input value="Login" lay-submit lay-filter="login"
				style="width: 100%;" type="submit">
			<hr class="hr20">
		</form>
	</div>

	<script>
		layui.use('form', function() {
			var form = layui.form;
			/* layer.msg('Please waiting...', function(){
			  //关闭后的操作
			}); */
			//监听提交
			form.on('submit(login)', function(data) {
				var user = {};
				user['username'] = data.field.username;
				user['password'] = data.field.password;
				var datas = new Object();
				$.ajax({
					url : '${pageContext.request.contextPath }/user/login.do',
					type : 'post',
					contentType : 'application/json;charset=UTF-8',
					async : false,
					dataType : 'json',
					data : JSON.stringify(user),
					success : function(result, textStatus, request) {
						datas = result;
					}
				});
				if (datas.code != 200) {
					layer.tips(datas.msg, "#username", {
						tips : [ 2, "red" ]
					});
					return false;
				}
			});

		});
	</script>

</body>
</html>