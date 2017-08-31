<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote</title>
</head>
<body>
	Vote登录
	<label>${msg}</label>
	<form method="post" action="<c:url value='/users/usersAction!login.action'></c:url>">
		<input name="username"/>
		<input name="password"/>
		<input type="submit"/>
	</form>
</body>
</html>