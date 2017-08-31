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
public class PageUsers extends Users {
	private boolean isOnline;

	public PageUsers() {
		super();
	}

	public PageUsers(String id, String username, String password,
			List<Votes> votes, List<UserVoteItem> userVoteItems) {
		super(id, username, password, votes, userVoteItems);
	}

	public PageUsers(boolean isOnline) {
		super();
		this.isOnline = isOnline;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	@Override
	public String toString() {
		return "PageUsers [isOnline=" + isOnline + "]";
	}
	
}
