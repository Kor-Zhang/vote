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
public class PageUsers extends Users{
	private String rememberMe;

	public String getRememberMe() {
		return rememberMe;
	}

	//注册使用的"再次输入密码"
	private String rePassword;
	
	
	

	public PageUsers(String rememberMe, String rePassword) {
		super();
		this.rememberMe = rememberMe;
		this.rePassword = rePassword;
	}
	

	public PageUsers(String id, String username, String password,
			List<Votes> votes, List<UserVoteItem> userVoteItems) {
		super(id, username, password, votes, userVoteItems);
		// TODO Auto-generated constructor stub
	}


	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public PageUsers() {
		super();
	}


	public PageUsers(String rememberMe) {
		super();
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "PageUsers [rememberMe=" + rememberMe + ", rPassword="
				+ rePassword + ", toString()=" + super.toString() + "]";
	}
	
}
