package com.zk.vote.service.impl;

import java.util.List;

import com.zk.vote.bean.Votes;
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
	
	public VotesMapper getVotesMapper() {
		return votesMapper;
	}

	public void setVotesMapper(VotesMapper votesMapper) {
		this.votesMapper = votesMapper;
	}

	@Override
	public List<Votes> selectVotesByPage(PageVotes pageBean) {
		return null;
	}

}
