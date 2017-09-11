package com.zk.vote.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Title:votes标的bean
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:04:02
 * @version 1.0
 */
public class Votes implements Serializable {
	private String id;
	private String theme;
	private int selectWay;
	private Users launcher;
	private Timestamp time;
	private List<VoteItems> voteItems;
	public Votes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Votes(String id, String theme, int selectWay, Users launcher,
			Timestamp time, List<VoteItems> voteItems) {
		super();
		this.id = id;
		this.theme = theme;
		this.selectWay = selectWay;
		this.launcher = launcher;
		this.time = time;
		this.voteItems = voteItems;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getSelectWay() {
		return selectWay;
	}
	public void setSelectWay(int selectWay) {
		this.selectWay = selectWay;
	}
	public Users getLauncher() {
		return launcher;
	}
	public void setLauncher(Users launcher) {
		this.launcher = launcher;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public List<VoteItems> getVoteItems() {
		return voteItems;
	}
	public void setVoteItems(List<VoteItems> voteItems) {
		this.voteItems = voteItems;
	}
	@Override
	public String toString() {
		return "Votes [id=" + id + ", theme=" + theme + ", selectWay="
				+ selectWay + ", launcher=" + launcher + ", time=" + time
				+ ", voteItems=" + voteItems + "]";
	}
	
	
	
}	
