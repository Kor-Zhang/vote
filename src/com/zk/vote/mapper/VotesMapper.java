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
	 * Title:分页查询votes,及其相關信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 上午11:05:55
	 * @version 1.0
	 * @param pageBean
	 * @return
	 */
	public List<PageVotes> selectVoteWithCustomFieldByPageAndKW(PageVotes pageBean);
	/**
	 * Title:统计指定theme的关键字的总计路数
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午3:14:01
	 * @version 1.0
	 * @return
	 */
	public Integer selectCountByKW(String kw);
	
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
	 * Title:通过id查询一个vote及其相關信息(關聯查詢)
	 * <p>
	 * Description:信息包括:vote.*,vote的总票数,vote的选项数,vote总共有多少人参加
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:46:22
	 * @version 1.0
	 * @param id
	 * @return
	 */
	public PageVotes selectVoteWithCustomField(String id);
	
	
	
}
