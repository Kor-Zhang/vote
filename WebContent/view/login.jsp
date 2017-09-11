<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.zk.vote.action.UsersAction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//防止用户登陆后回退
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
	Boolean isOnline = (null != session.getAttribute(UsersAction.ONLINE_USER_FIELD));
	//判断用户是否在线,如果在线,那么直接转发到主页
	if(isOnline){
		//转发到主页
		request.getRequestDispatcher("/view/protected/index.jsp").forward( request,response);
		return;
	}
	//获取cookie
	String username = "";
	String password = "";
	Cookie[] cs = request.getCookies();
	if(null != cs){
		for(Cookie c :cs){
			if(null != c){
				if(c.getName().equals("username")){
					username = c.getValue();
				}
				if(c.getName().equals("password")){
					password = c.getValue();
				}
			}
			
		}
	}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote</title>
<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/login.css'></c:url>" />

</head>
<body>
	<div class="content">
		<div class="top">
			<img alt="" src="<c:url value='/img/logo.gif'></c:url>" />
		</div>
		<div class="middle">
			<div>
				<img alt="" src="<c:url value='/img/voteBanner.jpg'></c:url>" />
				<div class="loginDiv">
					<div class="loginTitle">用戶登陸
						<span class="arrow_down"></span>
						<label style="font-size: 14px;color: red;">
							${msg}
						</label>
					</div>
					<div style="width:100%;height:2px;background:rgb(205,205,205); ;margin:5px 0px;"></div>
					
					<form method="post" action="<c:url value='/users/usersAction!login.action'></c:url>">
						<table>
							<tr>
								<td>用戶名:</td>
								<td>
									<input name="username" placeholder="请输入用户名"  value="<%=username %>" autocomplete="off" disableautocomplete 
									/>
								</td>
							</tr>
							<tr>
								<td>密碼:</td>
								<td>
									<input name="password" placeholder="请输入密码" type="password" value="<%=password %>" autocomplete="off" disableautocomplete 
									/>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="2">
									<label><input name="rememberMe" checked="checked" type="checkbox"/>记住我</label>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="2">
									<input value="提交" style="cursor: pointer;" type="submit"/>
									<a href="<c:url value='/view/regist.jsp'></c:url>">新用户注册</a>
								</td>
							</tr>
						</table>
						
					</form>
			
				</div>
			</div>
		</div>
		<div class="bottom">
			<div style="background: rgb(122,164,207);width:100%;height:1px;"></div>
			<div style="width:20%;margin-left:40%;text-align: center;margin-top: 10px;">Kor_Zhang@版权所有</div>
		</div>
	</div>
</body>
</html>