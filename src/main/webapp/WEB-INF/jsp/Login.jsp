<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<b>登录</b>
	<table border="1">
		<tr>
			<th>测试结果</th>
			<th>请求地址</th>
			<th>测试数据</th>
			<th>期望结果</th>
			<th>实际结果</th>
		</tr>
		<c:forEach items="${login}" var="p">
			<tr>
				<c:choose>
					<c:when test="${p.result=='pass'}">
						<td style="background-color: Green">${p.result}</td>
					</c:when>
					<c:otherwise>
						<td style="background-color: Red">${p.result}</td>
					</c:otherwise>
				</c:choose>
				<td>${p.url}</td>
				<td>${p.postData}</td>
				<td>${p.expectStr}</td>
				<td>${p.actualStr}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>