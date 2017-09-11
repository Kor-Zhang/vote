package com.zk.vote.pagebean;

import java.util.List;

import com.zk.vote.bean.UserVoteItem;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;

/**
 * Title:与前台交互的voteitems
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 下午6:19:27
 * @version 1.0
 */
public class PageVoteItems extends VoteItems {
	private Integer voteNum;// 该选项的票数個數

	public Integer getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}

	public PageVoteItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageVoteItems(String id, Votes master, String description,
			List<UserVoteItem> userVoteItems) {
		super(id, master, description, userVoteItems);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PageVoteItems [voteNum=" + voteNum + ", toString()="
				+ super.toString() + "]";
	}


}
