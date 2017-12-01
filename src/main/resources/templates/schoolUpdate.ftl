<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学籍修改界面</title>
</head>
<body>
	<form action="/school/update" method="post">
			<table>
			<tr>
				<input type="hidden" name="id"  value="${school.id}">
				<td>姓名<input type="text" name="name" value="${school.name}"></td>
				<td>性别<input type="text" name="sex" value="${school.sex}"></td>
				<td>学号<input type="text" name="sId" value="${school.sId}"></td>
				
				<td>专业<input type="text" name="professional" value="${school.professional}"></td>
				<td>入学时间<input type="text" name="admissiontime" value="${school.admissiontime}"></td>
				<td>家庭所在地<input type="text" name="address" value="${school.address}"></td>
				<td>学籍状态<input type="text" name="status" value="${school.status}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确认提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>