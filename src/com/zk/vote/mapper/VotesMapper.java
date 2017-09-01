package com.zk.vote.mapper;

import java.util.List;

import com.zk.vote.bean.Votes;
import com.zk.vote.pagebean.PageVotes;

/**
 * Title:votes的mapper接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:04:45
 * @version 1.0
 */
public interface VotesMapper {
	/**
	 * Title:分页查询votes
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 上午11:05:55
	 * @version 1.0
	 * @param pageBean
	 * @return
	 */
	public List<Votes> selectVotesByPage(PageVotes pageBean);
}
