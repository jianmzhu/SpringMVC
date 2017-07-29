<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 以下为mvc的form特有标签，在这里需要引用该taglib -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC表单处理</title>
</head>
<body>
	<h2>Student Information</h2>
	<!-- 记得填写完整的项目路径/SpringMVC/ -->
	<form:form method="POST" action="/SpringMVC/addStudent">
		<table>
			<tr>
				<td><form:label path="name">名字：</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="age">年龄：</form:label></td>
				<!-- 等同于<input id="age" name="age" type="text" value=""/>的效果 -->
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><form:label path="id">编号：</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="password">密码：</form:label></td>
				<!-- 等同于<input id="password" name="password" type="password" value=""/>的效果 -->
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="address">地址：</form:label></td>
				<!-- 等同于<textarea id="address" name="address" rows="5" cols="30">的效果 -->
				<td><form:textarea path="address" rows="5" cols="30" /></td>
			</tr>
			<tr>
				<td><form:label path="isMaster">是否主任：</form:label></td>
				<!-- 等同于
				<input id="receivePaper1" name="receivePaper" type="checkbox" value="true"/>
				<input type="hidden" name="_receivePaper" value="on"/>
				注意类里面该值应该为boolean值，不然会报错
				的效果 -->
				<td><form:checkbox path="isMaster"/></td>
			</tr>
			<tr>
				<td><form:label path="restLessons">课外选课：</form:label></td>
				<!-- 等同于
				<span>
				<input id="restLessons1" name="restLessons" type="checkbox" value="chinese" checked="checked"/>
				<label for="restLessons1">chinese</label>
				</span>
				<span>
				<input id="restLessons2" name="restLessons" type="checkbox" value="English"/>
				<label for="restLessons2">English</label>
				</span>
				<span>
				<input id="restLessons3" name="restLessons" type="checkbox" value="Math" checked="checked"/>
				<label for="restLessons3">Math</label>
				</span>
				<span>
				<input id="restLessons4" name="restLessons" type="checkbox" value="music"/>
				<label for="restLessons4">music</label>
				</span>
				<input type="hidden" name="_restLessons" value="on"/>
				的效果 -->
				<td><form:checkboxes items="${restLessonList}" path="restLessons"/></td>
			</tr>
			<tr>
				<td><form:label path="gender">性别：</form:label></td>
				<!-- 等同于
					<input id="gender1" name="gender" type="radio" value="M" checked="checked"/>
					<label for="gender1">男</label>
					<input id="gender2" name="gender" type="radio" value="F"/>
					<label for="gender2">女</label>
					的效果 -->
				<td>
					<form:radiobutton path="gender" value="M" label="男" />
					<form:radiobutton path="gender" value="F" label="女" />
				</td>
			</tr>
			<tr>
				<td><form:label path="favoriteNumber">喜欢数字：</form:label></td>
				<!-- 等同于
				<span>
					<input id="favoriteNumber1" name="favoriteNumber" type="radio" value="1"/>
					<label for="favoriteNumber1">1</label>
				</span>
				<span>
					<input id="favoriteNumber2" name="favoriteNumber" type="radio" value="2"/>
					<label for="favoriteNumber2">2</label>
				</span>
				<span>
					<input id="favoriteNumber3" name="favoriteNumber" type="radio" value="3"/>
					<label for="favoriteNumber3">3</label>
				</span>
				<span>
					<input id="favoriteNumber4" name="favoriteNumber" type="radio" value="4"/>
					<label for="favoriteNumber4">4</label>
				</span>
				的效果 -->
				<td><form:radiobuttons items="${favoriteNumberList}" path="favoriteNumber"/></td>
			</tr>
			<tr>
				<td><form:label path="country">国家：</form:label></td>
				<!-- 等同于
					<select id="country" name="country">
					   <option value="NONE">请选择...</option>
					   <option value="US">United States</option>
					   <option value="CH">China</option>
					   <option value="MY">Malaysia</option>
					   <option value="SG">Singapore</option>
					</select>
				的效果 -->
				<!-- form:select需要使用Map来传递select中的option -->
				<td><form:select path="country">
						<form:option value="" label="==请选择=="/>
						<form:options items="${countryList}"/>
					</form:select>
				</td>
				<!-- 或者下面这种写法 -->
				<%-- <td><form:select path="country" items="${countryList}"/>
				</td> --%>
			</tr>
			<tr>
				<td><form:label path="skills">技能：</form:label></td>
				<!-- 等同于
					<select id="skills" name="skills" multiple="multiple">
					   <option value="Struts">Struts</option>
					   <option value="Hibernate">Hibernate</option>
					   <option value="Apache Wicket">Apache Hadoop</option>
					   <option value="Spring">Spring</option>
					</select>
					<input type="hidden" name="_skills" value="1"/>
				的效果 -->
				<!-- form:select需要使用Map来传递select中的items -->
				<td><form:select path="skills" items="${skillsList}" multiple="true"/>
				</td>
			</tr>
			<tr>
				<!-- 等同于
					<input id="hiddenId" name="hiddenId" type="hidden" value="你猜不到"/>
				的效果 -->
				<td><form:hidden path="hiddenId" value="你猜不到"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交表单" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>