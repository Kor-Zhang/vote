package com.zk.vote.pagebean;

import java.util.List;

import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;

/**
 * Title:与前台交互的Votes
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:00:11
 * @version 1.0
 */
public class PageVotes extends Votes {

	//分页参数
	private Integer page;
	
	private Integer pageSize = 5;
	
	private Integer start;
	
	private Integer end;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return (page-1)*pageSize+1;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = getStart() + pageSize-1;
	}

	public PageVotes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageVotes(String id, String theme, int selectWay, Users launcher,
			List<VoteItems> voteItems) {
		super(id, theme, selectWay, launcher, voteItems);
		// TODO Auto-generated constructor stub
	}
	
	
}
