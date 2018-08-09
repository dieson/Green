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

<link rel="shortcut icon" href="${ctx}/static/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" href="${ctx}/static/css/font.css">
<link rel="stylesheet" href="${ctx}/static/css/xadmin.css">
<script type="text/javascript"
	src="${ctx}/static/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/js/xadmin.js"></script>
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="${ctx }/index.do">首页</a>
			<a href="${ctx }/environment/environment_index.do">测试环境</a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>

	<div class="x-body">
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','./order-add.html')">
			<i class="layui-icon"></i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：${fn:length(environments)}
			条</span> </xblock>

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
					<th>地址</th>
					<th>状态</th>
					<th>描述</th>
					<th>创建用户</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${environments }" var="en">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='${en.id }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td><c:out value="${en.id }" /></td>
						<td><c:out value="${en.url }" /></td>
						<td><c:choose>
								<c:when test="${en.status == true}">
									<c:out value="启用" />
								</c:when>
								<c:when test="${en.status == false}">
									<c:out value="禁用" />
								</c:when>
							</c:choose></td>
						<td><c:out value="${en.desc }" /></td>
						<td><c:out value="${en.user.username }" /></td>
						<td class="td-manage"><a title="查看"
							onclick="x_admin_show('编辑','order-view.html')"
							href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
						</a> <a title="删除" onclick="member_del(this,'要删除的id')"
							href="javascript:;"> <i class="layui-icon">&#xe640;</i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<div class="page">
			<div>
		        <div class="right">
			        <c:if test="${currentPage == 1}">
			            <span class="prev" >&lt;&lt;</span> 
			        </c:if>
			        <c:if test="${currentPage != 1}">
			            <a class="prev" href="" onclick="previous_page()">&lt;&lt;</a>
			        </c:if>
			        <c:if test="${currentPage == 1}">
			        <span class="current">1</span>
			        </c:if>
			        <c:if test="${currentPage != 1}">
			        <a href="listUser.do?page=1">1</a>
			        </c:if>
			        <%
			                int pageTimes = (Integer)session.getAttribute("pageTimes");
			                for(int i=1;i<pageTimes;i++)
			                {
			                    request.setAttribute("page", i+1);
			        %>            
			        <c:if test="${currentPage == page}">
			            <span class="current"><%=i+1%></span>       
			        </c:if>
			        <c:if test="${currentPage != page}">
			             <a href="listUser.do?page=<%=i+1%>"><%=i+1%></a>
			        </c:if>
			        <%} %>
			        <c:if test="${currentPage == pageTimes}">
			            <span class="disabled">后一页 >></span>        
			        </c:if>
			        <c:if test="${currentPage != pageTimes}">
			        	<a href="listUser.do?page=${currentPage+1}">后一页 >></a>
			        </c:if>
		        </div>
	        </div>
	        
			<div>
				<a class="prev" href="">&lt;&lt;</a>
				<a class="num" href="">1</a>
				<span class="current">2</span>
				<a class="num" href="">3</a>
				<a class="num" href="">489</a>
				<a class="next" href="">&gt;&gt;</a>
			</div>
		</div>
	</div>

	<script>
		//分页参数设置 这些全局变量关系到分页的功能
		var startAllAppoint = 0;
		var limitAllAppoint = 10;
		var currentPageAllAppoint = 1;
		var totalPageAllAppoint = 0;
		var dataLength = 0;
		
		function previous_page() {
			
		}

		layui.use('laypage', function() {

			//执行一个laypage实例

			/*var laypage = layui.laypage; 
			laypage.render({
				elem : '#layui-laypage' //指定元素
				,count: <c:out value="${fn:length(environments)}" />
				,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
			    ,jump: function(obj){
					console.log(obj)
				}
			}); */
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