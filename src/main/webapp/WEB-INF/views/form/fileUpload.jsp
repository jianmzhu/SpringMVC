<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC上传文件示例</title>
</head>
<style>
	.error {
	    color: #ff0000;
	}
	
	.errorStyle {
	    color: #000;
	    background-color: #ffEEEE;
	    border: 3px solid #ff0000;
	    padding: 8px;
	    margin: 16px;
	}
</style>
<body>
	<form:form method="POST" modelAttribute="fileUpload"
		enctype="multipart/form-data" commandName="fileModel">
		<form:errors path="*" cssClass="errorStyle" element="div" />
	      请选择一个文件上传 : 
	      <input type="file" name="file" />
	      <form:errors path="file" cssClass="error" />
		<input type="submit" value="提交上传" />
	</form:form>
</body>
</html>