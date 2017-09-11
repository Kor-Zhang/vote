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
	
	/**
	 * Title:分页按userid查询votes及其其他信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 上午11:05:55
	 * @version 1.0
	 * @param pageBean
	 * @return
	 */
	public List<PageVotes> selectMyVoteWithCustomFieldByPage(PageVotes pageBean);
	/**
	 * Title:通过userid获取votes总数
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 上午10:58:49
	 * @version 1.0
	 * @param userId
	 * @return
	 */
	public Integer selectCountByUserId(String userId);
	/**
	 * Title:通過id更新投票名字，選項類型
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 下午3:39:13
	 * @version 1.0
	 * @param pageBean
	 */
	public void updateVote(PageVotes pageBean);
	/**
	 * Title:删除一个vote
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 下午3:57:09
	 * @version 1.0
	 * @param id
	 */
	public void deleteVote(String id);
	
	
}
