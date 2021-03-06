<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Green automation test - User</title>
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

<body class="layui-anim layui-anim-up">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input type="text" name="username" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','./member-add.html',600,400)">
			<i class="layui-icon"></i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：88 条</span> </xblock>

		<table class="layui-table">
			<thead>
				<tr>
					<th width="20">
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th width="50">ID</th>
					<th>用户名</th>
					<th>邮箱</th>
					<th>项目</th>
					<th>状态</th>
					<th>管理员</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${uqv }" var="up">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='${up.id }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td><c:out value="${up.id }" /></td>
						<td><c:out value="${up.username }" /></td>
						<td><c:out value="${up.userEmail }" /></td>
						<td><c:forEach items="${up.projects }" var="project">
								<c:out value="${project.projectName }" />
							</c:forEach></td>
						<td><c:choose>
								<c:when test="${up.status == true}">
									<c:out value="启用" />
								</c:when>
								<c:when test="${up.status == false}">
									<c:out value="禁用" />
								</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${up.isSpre == true}">
									<c:out value="是" />
								</c:when>
								<c:when test="${up.isSpre == false}">
									<c:out value="否" />
								</c:when>
							</c:choose></td>
						<td class="td-manage"><a title="启用"
							onclick="member_stop(this,'${up.id }')" href="javascript:;">
								<i class="layui-icon">&#xe6b1;</i>
						</a> <a title="编辑"
							onclick="x_admin_show('编辑','member-edit.jsp',600,400)"
							href="javascript:;"> <i class="layui-icon">&#xe642;</i>
						</a> <a title="修改密码"
							onclick="x_admin_show('修改密码','member-password.html',600,400)"
							href="javascript:;"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除" onclick="member_del(this,'${up.id }')"
							href="javascript:;"> <i class="layui-icon">&#xe640;</i>
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
		</div>
	</div>

	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});
			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});

		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {

				if ($(obj).attr('title') == '启用') {
					//发异步把用户状态进行更改
					$(obj).attr('title', '停用')
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span')
							.addClass('layui-btn-disabled').html('已停用');
					layer.msg('已停用!', {
						icon : 5,
						time : 1000
					});
				} else {
					$(obj).attr('title', '启用')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span')
							.removeClass('layui-btn-disabled').html('已启用');
					layer.msg('已启用!', {
						icon : 5,
						time : 1000
					});
				}
			});
		}

		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {
			var data = tableCheck.getData();
			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
	</script>

</body>

</html>