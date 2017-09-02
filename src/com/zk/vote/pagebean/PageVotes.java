package com.zk.vote.pagebean;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;

/**
 * Title:与前台交互的Votes
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:00:11
 * @version 1.0
 */
public class PageVotes extends Votes {

	// 分页参数
	private Integer page;

	private Integer pageSize = 5;

	private Integer start;//通过page获取

	private Integer end;//通过page获取

	private Integer maxSize;
	
	private Integer maxPage;//通过maxSize获取
	
	private List<Votes> votes;
	
	private String launcherId;
	//前台的投票选项
	private String[] vItems;

	//保存投票選項的相關信息
	private List<PageVoteItems> totalVoteItems;//總的選項
	private Integer totalItemNumber;//總的選項數量
	private Integer totalVoteNumber;//所有的選項的所有投票數
	
	
	
	public PageVotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageVotes(String id, String theme, int selectWay, Users launcher,
			Date time, List<VoteItems> voteItems) {
		super(id, theme, selectWay, launcher, time, voteItems);
		// TODO Auto-generated constructor stub
	}
	public Integer getTotalVoteNumber() {
		return totalVoteNumber;
	}
	public void setTotalVoteNumber(Integer totalVoteNumber) {
		this.totalVoteNumber = totalVoteNumber;
	}
	public Integer getTotalItemNumber() {
		return totalItemNumber;
	}
	public void setTotalItemNumber(Integer totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}
	public List<PageVoteItems> getTotalVoteItems() {
		return totalVoteItems;
	}
	public void setTotalVoteItems(List<PageVoteItems> totalVoteItems) {
		this.totalVoteItems = totalVoteItems;
	}
	public String[] getvItems() {
		return vItems;
	}
	public void setvItems(String[] vItems) {
		this.vItems = vItems;
	}
	
	public String getLauncherId() {
		return launcherId;
	}
	public void setLauncherId(String launcherId) {
		this.launcherId = launcherId;
	}
	public Integer getMaxPage() {
		return maxSize%pageSize>0?((maxSize/pageSize)+1):(maxSize/pageSize);
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	
	
	public List<Votes> getVotes() {
		return votes;
	}
	public void setVotes(List<Votes> votes) {
		this.votes = votes;
	}
	//***重点****,请勿删除***//
	public Integer getStart() {
		return (page - 1) * pageSize + 1;
	}
	public Integer getEnd() {
		return getStart() + pageSize - 1;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}

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

	public void setStart(Integer start) {
		this.start = start;
	}

	

	public Integer getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}
	@Override
	public String toString() {
		return "PageVotes [page=" + page + ", pageSize=" + pageSize
				+ ", start=" + start + ", end=" + end + ", maxSize=" + maxSize
				+ ", maxPage=" + maxPage + ", votes=" + votes + ", launcherId="
				+ launcherId + ", vItems=" + Arrays.toString(vItems)
				+ ", toString()=" + super.toString() + "]";
	}
	
}
