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
	private String id;
	private Users joiner;
	private VoteItems voteItem;
	@Override
	public String toString() {
		return "UserVoteItem [id=" + id + ", joiner=" + joiner + ", voteItem="
				+ voteItem + "]";
	}
	public UserVoteItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserVoteItem(String id, Users joiner, VoteItems voteItem) {
		super();
		this.id = id;
		this.joiner = joiner;
		this.voteItem = voteItem;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Users getJoiner() {
		return joiner;
	}
	public void setJoiner(Users joiner) {
		this.joiner = joiner;
	}
	public VoteItems getVoteItem() {
		return voteItem;
	}
	public void setVoteItem(VoteItems voteItem) {
		this.voteItem = voteItem;
	}
	
}
