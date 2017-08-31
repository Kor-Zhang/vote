package com.zk.vote.bean;

import java.io.Serializable;

/**
 * Title:user_vote_item表的bean
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:07:05
 * @version 1.0
 */
public class UserVoteItem implements Serializable {
	private Users user;
	private VoteItems voteItem;
	public UserVoteItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVoteItem(Users user, VoteItems voteItem) {
		super();
		this.user = user;
		this.voteItem = voteItem;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public VoteItems getVoteItem() {
		return voteItem;
	}
	public void setVoteItem(VoteItems voteItem) {
		this.voteItem = voteItem;
	}
	@Override
	public String toString() {
		return "UserVoteItem [user=" + user + ", voteItem=" + voteItem + "]";
	}
	
}
