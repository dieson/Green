<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Green automation test - Login</title>
<meta name="description" content="Login page">
<meta name="author" content="Dieson Zuo">

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/static/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/xadmin.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>

</head>

<body>

	<%@ include file="/WEB-INF/views/layouts/top.jsp"%>
	<%@ include file="/WEB-INF/views/layouts/left.jsp"%>

	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='./welcome.html' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->

	<%@ include file="/WEB-INF/views/layouts/footer.jsp"%>

</body>
</html>