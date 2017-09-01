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
	
	/**
	 * Title:统计总计路数
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午3:14:01
	 * @version 1.0
	 * @return
	 */
	public Integer selectCount();
	
	/**
	 * Title:添加一个投票
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午6:16:50
	 * @version 1.0
	 * @param vote
	 */
	public void insertVote(Votes vote);
	
	
	/**
	 * Title:通过id查询一个vote
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:46:22
	 * @version 1.0
	 * @param id
	 * @return
	 */
	public Votes selectVoteById(String id);
}
