<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//防止用户登陆后回退
	response.setHeader("Cache-Control","no-store");   
	response.setHeader("Pragma","no-cache");   
	response.setDateHeader("Expires",0);   
%>
<link rel="stylesheet" href="<c:url value='/css/global.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/css/votesList.css'></c:url>" />
<%-- ${votes} --%>
<div class="contentDiv">

	<div class="titleDiv">
		<img src="<c:url value='/img/title_ico.gif'></c:url>"/>
		<div class="titleFont">投票列表</div>
	</div>
	<div class="votesTabDiv">
		<table>
			<c:forEach items="${votes.votes}" var="v">
				<tr>
					<td class="firstTd">
						
						<a class="vote_icon" href="">
							${v.theme}
							<!-- 描述 -->
							<div class="drecDiv">
								共12个选项,45人参与
							</div>
						</a>
						
					</td>
					<td class="secondTd">
						<a class="join_icon" href="">我要参与</a>
					</td>
				</tr>
			</c:forEach>
		
		</table>
		
	</div>
	<div class="pager">
		<c:if test="${votes.page gt 1}"><!-- 下载已经是最后一页 -->
			<a href="<c:url value='/votes/votesAction!selectVotesByPage.action?page=${votes.page-1}'></c:url>">上一页</a>
		</c:if>
		<c:if test="${votes.page lt votes.maxPage}"><!-- 下载已经是最后一页 -->
			<a href="<c:url value='/votes/votesAction!selectVotesByPage.action?page=${votes.page+1}'></c:url>">下一页</a>
		</c:if>
		[${votes.page}/${votes.maxPage}]
	</div>

</div>