<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单处理</title>
</head>
<body>

	<h2>提交的学生信息如下 </h2>
		<h5>-${studentModel}</h5>
	<table>
		<tr>
			<td>名称：</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td>${age}</td>
		</tr>
		<tr>
			<td>编号：</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td>${password}</td>
		</tr>
		<tr>
			<td>地址：</td>
			<td>${address}</td>
		</tr>
		<tr>
			<td>是否主任：</td>
			<td>${isMaster}</td>
		</tr>
		<tr>
			<td>喜欢的技术/框架</td>
			<td>
				<% String[] restLessons = (String[])request.getAttribute("restLessons");
		            for(String restLesson: restLessons) {
		               out.println(restLesson);
		            }
		         %>
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>${gender}</td>
		</tr>
		<tr>
			<td>喜欢的数字：</td>
			<td>${favoriteNumber}</td>
		</tr>
		<tr>
			<td>国家：</td>
			<td>${country}</td>
		</tr>
		<tr>
			<td>技能项</td>
			<td>
				<% String[] skills = (String[])request.getAttribute("skills");
		            for(String skill: skills) {
		               out.println(skill);
		            }
		         %>
			</td>
		</tr>
		<tr>
			<td>隐藏信息：</td>
			<td>${hiddenId}</td>
		</tr>
	</table>
</body>
</html>