<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="description" content="Login page">
<meta name="author" content="Dieson Zuo">
<link rel="icon"
	href="${pageContext.request.contextPath}/static/img/favicon.ico">
<title>Green automation test - Login</title>

<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/css/signin.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputUsername" class="sr-only">Username</label> 
			<input type="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="login()">Sign in</button>
		</form>
		<form class="form-signin" action="${pageContext.request.contextPath }/user/test.do">
			<button class="btn btn-lg btn-primary btn-block" type="submit">test</button>
		</form>
	</div>
	<!-- /container -->

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="http://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>

	<script type="text/javascript">
		function login() {
			window.event.returnValue=false;
			var username = document.getElementById('inputUsername').value;
			var password = document.getElementById('inputPassword').value;

			var user = {};
			user['username'] = username;
			user['password'] = password;
			$.ajax({
                url: '${pageContext.request.contextPath }/user/login.do',
                type: 'post',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                dataType: 'json',
                data: JSON.stringify(user),
                success: function (data) {
					 if (data['code'] == 200) { 
						 debugger;
						 alert('${pageContext.request.contextPath}/home/home.jsp');
						 window.location.href = '${pageContext.request.contextPath}/home/home.jsp';
						 window.event.returnValue=false;
					}
                },error: function (responseText){
                	alert("后台异常,执行注册时再检查用户是否存在");
                }
            }); 
		}
	</script>
</body>
</html>