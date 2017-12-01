<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学籍信息管理界面</title>
     <!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
</head>
<body>
<div class="container">
	<div class="row">
		<div class="span12">
			<h3 class="text-center text-info">
				学生学籍管理信息
			</h3>
		</div>
	</div>
</div>


<!-- 增加div -->
<div class="row">
		<div class="span12">
			 <button class="btn btn-warning" type="button"><a href="/add.html">新增</a></button>
		</div>
</div>

<form method="post" action="/school/list2">
		姓名：<input type="text" name="name" />&nbsp;
		专业：<input type="text" name="professional" />&nbsp;
	<input type="submit" value="搜索"/>
</form>
			<table class="table table-bordered table-hover table-condensed">
				<thead>
					<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>学号</th>
		
			<th>专业</th>
			<th>入学时间</th>
			<th>家庭所在地</th>
			<th>学籍状态（在读/休学）</th>
			<th>操作</th>
		</tr>
				</thead>
				<#list pageInfo.content as list>
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.sex}</td>
				<td>${list.sId}</td>
				<td>${list.professional}</td>
				<td>${list.admissiontime}</td>
				<td>${list.address}</td>
				<td>${list.status}</td>
				<td><a href="/school/preUpdate/${list.id}">修改</a>||<a href="/school/delete?id=${list.id}">删除</a></td>
				
			
			</tr>
		
		
		</#list>
				
				
				</tbody>
			</table>
		</div>
		<span>
					当前是第${pageInfo.number}页,总${pageInfo.totalPages }页,总有${pageInfo.totalElements }条记录</td>
		</spqn>
		<a href="list?pn=0">首页</a>
		<#if !pageInfo.first>
		<a href="list?pn=${pageInfo.number-1}">上一页</a>
		</#if>
		<#if !pageInfo.last>
		<a href="list?pn=${pageInfo.number+1}">下一页</a>
		</#if>
	</div>
</div>
</body>
</html>