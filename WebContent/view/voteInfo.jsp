<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
				共${vote.itemNum}个选项,${vote.joinerNum}人参与,共${vote.voteNum}票
				</label>
				
			</div>
			<table>
				<c:forEach items="${vote.pageItems}" var="item">
					
					<tr>
						<td>
							${item.description}
						</td>
						<td>
							<c:set var="flt" value="0"/>
							<c:if test="${vote.voteNum ne 0}">
								<c:set var="flt" value="${100*item.voteNum/vote.voteNum}"/>
								
							</c:if>
							
							
							<c:set var="static_radius" value="99"></c:set>
							<c:set var="radius" value="${static_radius}"></c:set>
							<c:if test="${flt lt 100}">
								<c:set var="radius" value="0"/>
							</c:if>
							
							
							
							<div style="width:100%;background:rgb(120,120,120);height:10px;border-radius:${static_radius}px;">
								<div style="width:${flt}%;background:rgb(255,236,0);height:10px;border-top-left-radius:${static_radius}px;border-bottom-left-radius:${static_radius}px;border-top-right-radius:${radius}px;border-bottom-right-radius:${radius}px;"></div>
							</div>
							<div>
								
							
								共${item.voteNum}票(<fmt:formatNumber value="${flt}" type="currency" pattern="0"/>%)
							</div>
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