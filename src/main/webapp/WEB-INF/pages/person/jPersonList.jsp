<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script language="javascript">
		//批量提交
		function deleteMuch(){
			document.forms[0].action = "${pageContext.request.contextPath}/person/deleteMuch.action";
			document.forms[0].submit();			//手动提交
		}
	</script>
</head>
<body>

<form method="post">

<div style="padding:20px;">
	人员列表
</div>
<div style="padding-left:40px;pading-bottom:10px;">
	<a href="tocreate.action">新增</a>
	<a href="#" onclick="deleteMuch();">批量删除</a>
</div>
  <table border="1">
  <tr>
	<td>选择</td>
	<td>photo:</td>
	<td>id:</td>
	<td>name:</td>
	<td>age:</td>
	<td>option</td>
  </tr>
  
  <c:forEach items="${personList}" var="p">
  <tr>
	<td><input type="checkbox" name="id" value="${p.id}"/></td>
	<td><img src="${pageContext.request.contextPath}${p.photoPath}"/></td>
	<td>${p.id}</td>
	<td>${p.name}</td>
	<td>${p.age}</td>
	<td>
		<a href="toupdate.action?id=${p.id}">修改</a>
		<a href="deleteById.action?id=${p.id}">删除</a>
	</td>
  </tr>
  </c:forEach>
  
  </table>



</form>

</body>
</html>