<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.zk.vote.action.UsersAction"%>

<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/msg.css'></c:url>" />
<div
	style="margin-left: 25%; width: 50%; border: 1px solid rgba(122, 164, 207, 0.5);">
	<div
		style="background: rgba(122, 164, 207, 0.5); width: 100%; height: 30px; line-height: 30px;">
		<div
			style="height: 30px; font-weight: bold; color: white; margin-left: 5px;">
			提示</div>
	</div>

	<div>
		<div>
			<label style="font-size: 14px; color: red;"> ${msg} </label>
		</div>
		<div style="text-align: center; margin: 15px 0px;">
			<a style="font-size: 22px; color: rgb(122, 164, 207);" href="<c:url value='${curl}'></c:url>">返回</a>
		</div>
	</div>
</div>
