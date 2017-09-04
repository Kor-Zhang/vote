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
<link rel="stylesheet" href="<c:url value='/css/editVote.css'></c:url>" />
<div class="addVotesContentDiv">
	<div class="addVotesTitleDiv">
		修改投票：共${vote.itemNum}个选项,${vote.joinerNum}人参与,共${vote.voteNum}票,
		<label style="font-size: 14px; color: red;"> ${msg} </label>
	</div>
	<div class="addVotesFormDiv">
		<form class="addVotesForm" action="<c:url value='/votes/votesAction!updateVote.action'></c:url>">
		 
			<input type="hidden" name="id" value="${vote.id}"/>
			<table>
				<tr>
					<td class="tabFirstTd">投票内容:</td>
					<td class="tabSecondTd"><input type="text" name="theme" value="${vote.theme}" autocomplete="off" disableautocomplete/></td>
					<td class="tabThirdTd"></td>
				</tr>
				<tr>
					<td class="tabFirstTd">投票類型:</td>
					
					<td class="tabSecondTd">
						<c:choose>
							<c:when test="${vote.selectWay eq 0}">
								<label>
									<input name="selectWay" checked="checked" type="radio" value="0"/>
									單選
								</label>
								<label>
									<input name="selectWay" type="radio" value="1"/>
									多選
								</label>
							</c:when>
							<c:when test="${vote.selectWay eq 1}">
									<label>
										<input name="selectWay" type="radio" value="0"/>
										單選
									</label>
									<label>
										<input name="selectWay" checked="checked" type="radio" value="1"/>
										多選
									</label>
							</c:when>
							<c:otherwise>
								
								<label>
									<input name="selectWay" checked="checked" type="radio" value="0"/>
									單選
								</label>
								<label>
									<input name="selectWay" type="radio" value="1"/>
									多選
								</label>
							</c:otherwise>
						</c:choose>
						
					</td>
					<td class="tabSecondTd">
						
					</td>
				</tr>
				<!-- 选项 -->
				<c:forEach varStatus="idxStatus" var="item" items="${vote.pageItems}">
				
					<tr class="voteItemsTr">
						<td class="tabFirstTd">投票選項:</td>
						<td class="tabSecondTd">
						
							<input value="${item.description}" type="text" name="vItems" autocomplete="off" disableautocomplete/>
							<input value="${item.id}" type="hidden" name="vItemIds"/>
						</td>
						<td class="tabThirdTd">
							<a class='removeVoteItemsBtn' href='javascript:void(0);'>删除投票选项及其记录</a>
						</td>
					</tr>
				</c:forEach>
				
				
			</table>
			<!-- 控制按鈕 -->
			<div class="controler">
				<input type="submit" value=""/>
				<a id="addVoteItemsBtn" href="javascript:void(0);">添加選項</a>
				<a onclick="return confirm('确认删除？');" href="<c:url value='/votes/votesAction!deleteVote.action?id=${vote.id}'></c:url>">删除</a>
				<a target="viewsIframe" href="<c:url value='/votes/votesAction!selectMyVoteWithCustomFieldByPage.action?page=1'></c:url>">取消</a>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value='/plugin/jquery-3.2.1.min.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/js/global.js'></c:url>"></script>
<script type="text/javascript" src="<c:url value='/js/editVote.js'></c:url>"></script>

