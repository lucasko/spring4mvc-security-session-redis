<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>


</head>
<body>
	Login Form：
	<form id="dataForm" action="<c:url value='/j_spring_security_check' />"
		method="POST">
		<p>
			<input id="username" name="username" value="admin">
		</p>

		<p>
			<input type="password" class="form-control" placeholder="Password"
				id="password" name="password" value="P@ssw0rd">
		</p>


		<p>
			<button type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
		</p>
	</form>
	<font style="color: red;">${error}</font>

</body>
</html>