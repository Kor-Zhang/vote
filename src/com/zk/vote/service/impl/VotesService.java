package com.zk.vote.service.impl;

import java.sql.Date;
import java.util.UUID;

import com.zk.vote.bean.Users;
import com.zk.vote.bean.Votes;
import com.zk.vote.mapper.VoteItemsMapper;
import com.zk.vote.mapper.VotesMapper;
import com.zk.vote.pagebean.PageVotes;
import com.zk.vote.service.VotesServiceI;
import com.zk.vote.util.Util;

/**
 * Title:实现VotesServiceI接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:03:58
 * @version 1.0
 */
public class VotesService implements VotesServiceI {
	//votesMapper
	private VotesMapper votesMapper;
	//voteItemsMapper
	private VoteItemsMapper voteItemsMapper;
	
	
	public VoteItemsMapper getVoteItemsMapper() {
		return voteItemsMapper;
	}

	public void setVoteItemsMapper(VoteItemsMapper voteItemsMapper) {
		this.voteItemsMapper = voteItemsMapper;
	}

	public VotesMapper getVotesMapper() {
		return votesMapper;
	}

	public void setVotesMapper(VotesMapper votesMapper) {
		this.votesMapper = votesMapper;
	}

	@Override
	public PageVotes selectVotesByPage(PageVotes pageBean) {
		//获取并且设置数据库总记录数
		Integer count = votesMapper.selectCount();
		
		pageBean.setMaxSize(count);
		
		//获取并且设置返回集合
		pageBean.setVotes(votesMapper.selectVotesByPage(pageBean));
		
		return pageBean;
	}

	@Override
	public void insertVotesAndItems(PageVotes pageBean) throws Exception {
		
		if(pageBean.getTheme() ==null || pageBean.getTheme().equals("")){
			throw new Exception("主题不能为空");
		}
		if(pageBean.getLauncherId() == null || pageBean.getLauncherId().equals("")){
			throw new Exception("您已离线");
		}
		Util.l.info(pageBean);
		
		Votes vote = pageBean;
		
		Users u = new Users();
		u.setId(pageBean.getId());
		
		vote.setLauncher(u);
		
		vote.setId(UUID.randomUUID().toString());
		
		vote.setTime(new Date(new java.util.Date().getTime()));
		
		votesMapper.insertVote(vote);
		
		
		
	}

}
