<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<sf:form 
	enctype="multipart/form-data"
	action="${pageContext.request.contextPath}/person/saveOrUpdate.action"
	modelAttribute="p" 
	method="post">
	<sf:hidden path="id"/>

<div style="padding:20px;">
	修改人员信息
</div>

<div style="padding:20px;">
	错误信息：<sf:errors path="*"/>
</div>

  <table>
  <tr>
	<td>name:</td>
	<td><sf:input path="name"/><sf:errors path="name"/></td>
  </tr>
  <tr>
	<td>age:</td>
	<td><sf:input path="age"/></td>
  </tr>
  <tr>
	<td>photo:</td>
	<td><input type="file" name="photo" value=""/></td>
  </tr>
  <tr>
	<td colspan="2"><input type="submit" name="btnOK" value="保存"/></td>
  </tr>
  </table>



</sf:form>

</body>
</html>