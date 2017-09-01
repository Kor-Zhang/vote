<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.zk.vote.action.UsersAction"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//防止用户登陆后回退
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/regist.css'></c:url>" />

</head>
<body>
	<div class="content">
		<div class="top">
			<img alt="" src="<c:url value='/img/logo.gif'></c:url>" />
		</div>
		<div class="middle">
			<form class="registForm" method="post"
				action="<c:url value='/users/usersAction!regist.action'></c:url>">
				<table>
					<tr>
						<td>用戶名:</td>
						<td><input name="username" placeholder="请输入用户名"
							value="" /></td>
					</tr>
					<tr>
						<td>密碼:</td>
						<td><input name="password" placeholder="请输入密码"
							type="password" value="" /></td>
					</tr>
					<tr>
						<td>密碼:</td>
						<td><input name="rPassword" placeholder="请再次输入密码"
							type="password" value="" /></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="2"><input
							type="submit" /> 
					</tr>
				</table>

			</form>
		</div>
		<div class="bottom">
			<div
				style="background: rgb(122, 164, 207); width: 100%; height: 1px;"></div>
			<div
				style="width: 20%; margin-left: 40%; text-align: center; margin-top: 10px;">Kor_Zhang@版权所有</div>
		</div>
	</div>
</body>
</html>