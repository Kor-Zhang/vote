<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.zk.vote.bean.Users" %>
<%@page import="com.zk.vote.action.UsersAction" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>主页</title>
<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/index.css'></c:url>" />

</head>
<body>
	<div class="content">
		<div class="top">
			<img alt="" src="<c:url value='/img/logo.gif'></c:url>" />
		</div>
		<div class="middle">
			<ul class="navbar">
				<li>
					<span >欢迎,<span style="color: red;">${user.username}</span> 
						,
						<a href="<c:url value='/users/usersAction!logout.action'></c:url>">注销</a>
					</span>
				</li>
				<li>
					<a href="<c:url value='/votes/votesAction!selectVoteWithCustomFieldByPageAndKW.action?page=1&kw='></c:url>" class="backListIcon" target="viewsIframe">投票大厅</a>
				</li>
				<li>
					<a href="<c:url value='/view/protected/addVotes.jsp'></c:url>" class="addVoteIcon" target="viewsIframe">添加新投票</a>
				</li>
				<li>
					<a href="<c:url value='/votes/votesAction!selectMyVoteWithCustomFieldByPage.action?page=1'></c:url>" class="repairIcon" target="viewsIframe">我发起的..</a>
				</li>
				<li>
					<form method="post" class="searchForm" action="<c:url value='/votes/votesAction!selectVoteWithCustomFieldByPageAndKW.action?page=1'></c:url>" target="viewsIframe">
						<input name="kw" placeholder="请输入投票关键字" autoComplete="off" disableAutoComplete="true"/>
						<input type="submit" value="搜索"/>
						
					</form>
				</li>
			</ul>
			<div class="displayOnlineNumber">当前在线人数:${onlineUserNumber}</div>
			<!-- 显示其他jsp -->
			<iframe name="viewsIframe" class="viewsIframe" id="viewsIframe" src="<c:url value='/votes/votesAction!selectVoteWithCustomFieldByPageAndKW.action?page=1&kw='></c:url>">
					
			</iframe>
		</div>
		<div class="bottom">
			<div
				style="background: rgb(122, 164, 207); width: 100%; height: 1px;"></div>
			<div
				style="width: 20%; margin-left: 40%; text-align: center; margin-top: 10px;">Kor_Zhang@版权所有</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<c:url value='/plugin/jquery-3.2.1.min.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/js/global.js'></c:url>"></script>
<script type="text/javascript">
	$(function(){
		
		/*在iframe加载完成后判断用户是否离线*/
		var iframe = document.getElementById("viewsIframe");
		if (iframe.attachEvent) {
			iframe.attachEvent("onload", function() {
				//iframe加载完成后你需要进行的操作    
				afterLoadIframe();
			});
		} else {
			iframe.onload = function() {
				//iframe加载完成后你需要进行的操作    
				afterLoadIframe();
			};
		}
	});
		
	//加载iframe完成后
	function afterLoadIframe(){
		
		
		$.ajax({
			type : "POST",
			timeout : 5000, //超时时间设置，单位毫秒
			url : getHrefPath() + "/users/usersAction!getOnlineUser.action",
			async : true,
			dataType : "json",
			data : {},
			success : function(data) {
				if(data.id == undefined){//离线
					alert("您已离线,请重新登录!");
					window.location.href=getHrefPath()+"/view/login.jsp";
				}
			},
			error : function(data) {
				
			}
		});
	}
</script>
</html>