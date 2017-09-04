/**
 * AddVotes對象
 */
var addVotes = {
	addVoteItemsBtn : undefined,
	removeVoteItemsBtn: undefined,
	voteItemsTr : undefined,
	/**
	 * 初始化
	 */
	init : function() {
		this.initDom();
		this.initLis();
	},
	initDom : function() {
		// 添加按钮的dom
		addVoteItemsBtn = $("#addVoteItemsBtn");
		removeVoteItemsBtn = $(".removeVoteItemsBtn");
	},
	initLis : function() {

		voteItemsNum = $(".voteItemsTr").length;
		console.info(voteItemsNum);
		maxItem = 6;
		// 添加新的选项
		addVoteItemsBtn.on("click", function() {
			if(voteItemsNum>=maxItem){
				alert("最多只能"+maxItem+"个选项");
				return ;
			}
			// 一行选项的dom
			voteItemsTr = $(".voteItemsTr:last-child");
			var newTr = $(voteItemsTr.clone());
			//清空内容
			newTr.find("input[type=text]").val("");
			//添加删除按钮
			newTr.find(".tabThirdTd").html("").append("<a class='removeVoteItemsBtn' href='javascript:void(0);'>删除</a>");
			console.info(newTr.find("input[name='vItemIds']"));
			//清空id
			newTr.find("input[name='vItemIds']").val("");
			voteItemsTr.after(newTr);
			
			++voteItemsNum;
		});
		
		//删除按钮
		$(document).on("click",'.removeVoteItemsBtn',function(){
			$(this).parent().parent().remove();
			
			--voteItemsNum;
			
		});
	}

}
/**
 * 延时加载
 */
$(function() {

	addVotes.init();

});
