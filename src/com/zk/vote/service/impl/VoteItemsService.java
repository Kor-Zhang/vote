package com.zk.vote.service.impl;

import java.util.UUID;

import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;
import com.zk.vote.mapper.VoteItemsMapper;
import com.zk.vote.pagebean.PageVoteItems;
import com.zk.vote.service.VoteItemsServiceI;

/**
 * Title:实现VotesServiceI接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:03:58
 * @version 1.0
 */
public class VoteItemsService implements VoteItemsServiceI {
	//voteItemsMapper
	private VoteItemsMapper voteItemsMapper;
	
	
	public VoteItemsMapper getVoteItemsMapper() {
		return voteItemsMapper;
	}

	public void setVoteItemsMapper(VoteItemsMapper voteItemsMapper) {
		this.voteItemsMapper = voteItemsMapper;
	}


}
