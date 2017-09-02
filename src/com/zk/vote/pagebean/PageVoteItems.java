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
	private Integer totalJoinerNumber;// 該選項參與者個數

	public Integer getTotalJoinerNumber() {
		return totalJoinerNumber;
	}

	public void setTotalJoinerNumber(Integer totalJoinerNumber) {
		this.totalJoinerNumber = totalJoinerNumber;
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
		return "PageVoteItems [totalJoinerNumber=" + totalJoinerNumber
				+ ", toString()=" + super.toString() + ", getId()=" + getId()
				+ ", getMaster()=" + getMaster() + ", getDescription()="
				+ getDescription() + ", getUserVoteItems()="
				+ getUserVoteItems() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
