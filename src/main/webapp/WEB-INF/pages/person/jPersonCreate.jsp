<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/person/saveOrUpdate.action" method="post">

<div style="padding:20px;">
	新增人员信息
</div>

  <table>
  <tr>
	<td>name:</td>
	<td><input type="text" name="name" value=""/></td>
  </tr>
  <tr>
	<td>age:</td>
	<td><input type="text" name="age" value=""/></td>
  </tr>
  <tr>
	<td colspan="2"><input type="submit" name="btnOK" value="保存"/></td>
  </tr>
  </table>



</form>

</body>
</html>