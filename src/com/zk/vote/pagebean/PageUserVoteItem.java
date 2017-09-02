package com.zk.vote.pagebean;

import com.zk.vote.bean.UserVoteItem;
import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;

/**
 * Title:用户与投票关系
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月2日 上午8:53:02
 * @version 1.0
 */
public class PageUserVoteItem extends UserVoteItem{

	private String onlineUserId;//当前在线用户id
	
	private String itemId;//master的id

	private String voteId;
	
	public String getVoteId() {
		return voteId;
	}

	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}

	public String getOnlineUserId() {
		return onlineUserId;
	}

	public void setOnlineUserId(String onlineUserId) {
		this.onlineUserId = onlineUserId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public PageUserVoteItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageUserVoteItem(String id, Users joiner, VoteItems voteItem,
			Votes vote) {
		super(id, joiner, voteItem, vote);
		// TODO Auto-generated constructor stub
	}

	


	
	
}
