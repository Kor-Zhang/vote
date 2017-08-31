package com.zk.vote.pagebean;

import java.util.List;

import com.zk.vote.bean.UserVoteItem;
import com.zk.vote.bean.Users;
import com.zk.vote.bean.Votes;

/**
 * Title:与前台交互使用的bean
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:13:22
 * @version 1.0
 */
public class PageUsers {
	private String id;
	private String username;
	private String password;
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
	@Override
	public String toString() {
		return "PageUsers [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	public PageUsers(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public PageUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
