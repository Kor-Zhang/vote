package com.zk.vote.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Title:vote_item表的bean
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:05:33
 * @version 1.0
 */
public class VoteItems implements Serializable {
	private String id;
	private Votes master;
	private String description;
	private List<UserVoteItem> userVoteItems;
	public VoteItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoteItems(String id, Votes master, String description,
			List<UserVoteItem> userVoteItems) {
		super();
		this.id = id;
		this.master = master;
		this.description = description;
		this.userVoteItems = userVoteItems;
	}
	@Override
	public String toString() {
		return "VoteItems [id=" + id + ", master=" + master + ", description="
				+ description + ", userVoteItems=" + userVoteItems + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Votes getMaster() {
		return master;
	}
	public void setMaster(Votes master) {
		this.master = master;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UserVoteItem> getUserVoteItems() {
		return userVoteItems;
	}
	public void setUserVoteItems(List<UserVoteItem> userVoteItems) {
		this.userVoteItems = userVoteItems;
	}
	
	
}
