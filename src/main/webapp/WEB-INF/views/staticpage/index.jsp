<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Spring Landing Page</title>
	</head>
	<body>
		<h2>Spring Landing Page</h2>
		<p>点击下面的按钮获得一个简单的HTML页面</p>
		<!-- 记得填写完整的项目路径/SpringMVC/ -->
		<form:form method="GET" action="/SpringMVC/staticpages/staticpage">
			<table>
				<tr>
					<td><input type="submit" value="获取HTML页面" /></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>