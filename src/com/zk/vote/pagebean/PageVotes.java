package com.zk.vote.pagebean;

import java.sql.Date;
import java.sql.Timestamp;
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

	//存放PageVotes
	private List<PageVotes> pageVotes;
	
	
	//保存投票選項的相關信息
	private List<PageVoteItems> pageItems;
	private Integer itemNum;//vote選項數目
	private Integer voteNum;//vote的縂得票數
	private Integer joinerNum;//vote的參加者數量
	
	
	
	
	
	
	public PageVotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageVotes(String id, String theme, int selectWay, Users launcher,
			Timestamp time, List<VoteItems> voteItems) {
		super(id, theme, selectWay, launcher, time, voteItems);
		// TODO Auto-generated constructor stub
	}
	public List<PageVotes> getPageVotes() {
		return pageVotes;
	}
	public void setPageVotes(List<PageVotes> pageVotes) {
		this.pageVotes = pageVotes;
	}
	public List<PageVoteItems> getPageItems() {
		return pageItems;
	}
	public void setPageItems(List<PageVoteItems> pageItems) {
		this.pageItems = pageItems;
	}
	public Integer getItemNum() {
		return itemNum;
	}
	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}
	public Integer getVoteNum() {
		return voteNum;
	}
	public void setVoteNum(Integer voteNum) {
		this.voteNum = voteNum;
	}
	public Integer getJoinerNum() {
		return joinerNum;
	}
	public void setJoinerNum(Integer joinerNum) {
		this.joinerNum = joinerNum;
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
	public Integer getMaxPage() {
		return maxSize%pageSize>0?((maxSize/pageSize)+1):(maxSize/pageSize);
	}

	//***重点****,请勿删除***//
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
				+ ", pageVotes=" + pageVotes + ", pageItems=" + pageItems
				+ ", itemNum=" + itemNum + ", voteNum=" + voteNum
				+ ", joinerNum=" + joinerNum + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
