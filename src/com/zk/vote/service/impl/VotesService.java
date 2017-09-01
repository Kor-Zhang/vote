package com.zk.vote.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;
import com.zk.vote.mapper.VoteItemsMapper;
import com.zk.vote.mapper.VotesMapper;
import com.zk.vote.pagebean.PageVotes;
import com.zk.vote.service.VotesServiceI;

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
		
		
		if(pageBean.getLauncherId() == null || pageBean.getLauncherId().equals("")){
			throw new IllegalArgumentException("您已离线");
		}
		if(pageBean.getTheme() ==null || pageBean.getTheme().equals("")){
			throw new IllegalArgumentException("主题不能为空");
		}
		if(pageBean.getvItems() == null || pageBean.getvItems().length==0 ||pageBean.getvItems()[0].equals("")){

			throw new IllegalArgumentException("至少需要一个选项");
		}
		
		String auncherId = pageBean.getLauncherId();
		
		Votes vote = pageBean;
		
		Users u = new Users();
		u.setId(auncherId);
		
		vote.setLauncher(u);
		
		vote.setId(UUID.randomUUID().toString());
		
		vote.setTime(new Date(new java.util.Date().getTime()));
		
		votesMapper.insertVote(vote);
		
		//添加选项
		String[] vItems = pageBean.getvItems();
		
		for (int i = 0; i < vItems.length; i++) {
			String vt = vItems[i];
			if(null != vt && !vt.equals("")){
				VoteItems voteItem = new VoteItems(UUID.randomUUID().toString(), vote, vt, null);
				
				voteItemsMapper.insertVoteItem(voteItem);
			}
			
			
		}
		
	}

	@Override
	public PageVotes selectVoteById(String id) {
		
		PageVotes vote = new PageVotes();
		
		//查询投票
		Votes dbV = votesMapper.selectVoteById(id);
		
		BeanUtils.copyProperties(dbV, vote);
		
		//查询选项
		List<VoteItems> voteItems = voteItemsMapper.selectVoteItemsByVoteId(id);
		
		vote.setVoteItems(voteItems);
		
		return vote;
	}

}
