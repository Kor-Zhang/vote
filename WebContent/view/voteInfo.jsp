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
				<%-- 共${v.itemNum}个选项,${v.joinerNum}人参与,共${v.voteNum}票 --%>
				已有${vote.itemNum}人投票，共${vote.joinerNum}個選項，共${vote.voteNum}票
				</label>
				
			</div>
			<table>
				<c:forEach items="${vote.pageItems}" var="item">
					
					<tr>
						<td>
							${item.description}
						</td>
						<td>
							<div class="processBar">
								
							</div>
						</td>
						<td>
							共${item.voteNum}票(33%)
						</td>
						<td>
							<a class="toVoteBtn" href="<c:url value='/userVoteItem/userVoteItemAction!vote.action?itemId=${item.id}&voteId=${vote.id}'></c:url>">投票</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>
	<%-- ${vote} --%>
</div>