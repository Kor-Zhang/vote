package com.zk.vote.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Title:users表的bean
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:02:54
 * @version 1.0
 */
public class Users implements Serializable{
	private String id;
	private String username;
	private String password;
	private List<Votes> votes;
	private List<UserVoteItem> userVoteItems;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + ", votes=" + votes + ", userVoteItems="
				+ userVoteItems + "]";
	}
	public Users(String id, String username, String password,
			List<Votes> votes, List<UserVoteItem> userVoteItems) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.votes = votes;
		this.userVoteItems = userVoteItems;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Votes> getVotes() {
		return votes;
	}
	public void setVotes(List<Votes> votes) {
		this.votes = votes;
	}
	public List<UserVoteItem> getUserVoteItems() {
		return userVoteItems;
	}
	public void setUserVoteItems(List<UserVoteItem> userVoteItems) {
		this.userVoteItems = userVoteItems;
	}
	
}
