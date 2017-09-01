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
<link rel="stylesheet" href="<c:url value='/css/addVotes.css'></c:url>" />
<div class="addVotesContentDiv">
	<div class="addVotesTitleDiv">
		添加新投票
	</div>
	<div class="addVotesFormDiv">
		<form class="addVotesForm" action="<c:url value='/votes/votesAction!addVotesAndItems.action'></c:url>">
			<table>
				<tr>
					<td class="tabFirstTd">投票内容:</td>
					<td class="tabSecondTd"><input type="text" name="theme"/></td>
					<td class="tabThirdTd"></td>
				</tr>
				<tr>
					<td class="tabFirstTd">投票類型:</td>
					
					<td class="tabSecondTd">
						<label>
							<input name="selectWay" checked="checked" type="radio" value="0"/>
							單選
						</label>
						<label>
							<input name="selectWay" type="radio" value="1"/>
							多選
						</label>
					</td>
					<td class="tabSecondTd">
						
					</td>
				</tr>
				<tr class="voteItemsTr">
					<td class="tabFirstTd">投票選項:</td>
					<td class="tabSecondTd"><input type="text" name="voteItems"/></td>
					<td class="tabThirdTd"></td>
				</tr>
				
			</table>
			<!-- 控制按鈕 -->
			<div class="controler">
				<input type="submit" value=""/>
				<a id="addVoteItemsBtn" href="javascript:void(0);">添加選項</a>
				<a target="_top" href="<c:url value='/view/index.jsp'></c:url>">取消</a>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value='/plugin/jquery-3.2.1.min.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/js/addVotes.js'></c:url>"></script>