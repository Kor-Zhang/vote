package com.zk.vote.service;

import java.util.List;

import com.zk.vote.bean.Votes;
import com.zk.vote.pagebean.PageVotes;

/**
 * Title:处理votes的业务接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:01:52
 * @version 1.0
 */
public interface VotesServiceI {
	/**
	 * Title:分页查询votes
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 上午11:02:54
	 * @version 1.0
	 * @param pageBean
	 * @return
	 */
	public List<Votes> selectVotesByPage(PageVotes pageBean);
}
