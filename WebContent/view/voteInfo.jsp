<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//防止用户登陆后回退
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/voteInfo.css'></c:url>" />
<div class="voteInfoContentDiv">
	<div class="titleDiv">
		<img src="<c:url value='/img/title_ico.gif'></c:url>" />
		<div class="titleFont">投票列表</div>
	</div>
	<div class="displayVoteInfo">
		<div class="theme">
			<label>${vote.theme}</label>
		</div>
		<div class="detail">
			<div>
				<label>
				已有5人投票，共5個選項
				</label>
			</div>
			<table>
				<c:forEach items="${vote.voteItems}" var="item">
					<tr>
						<td>
							${item.description}
						</td>
						<td>
							<div class="processBar">
								
							</div>
						</td>
						<td>
							共 20票(33%)
						</td>
						<td>
							<a class="toVoteBtn" href="<c:url value='/userVoteItem/userVoteItemAction!vote.action?itemId=${item.id}'></c:url>">投票</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
	<%-- ${vote} --%>
</div>