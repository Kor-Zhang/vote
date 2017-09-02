package com.zk.vote.service;

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
	 * @date 2017年9月1日 下午3:22:33
	 * @version 1.0
	 * @param pageBean
	 * @return
	 */
	public PageVotes selectVoteWithCustomFieldByPageAndKW(PageVotes pageBean);

	/**
	 * Title:添加投票及其选项
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午6:15:44
	 * @version 1.0
	 * @param pageBean
	 * @return
	 * @throws Exception 
	 */
	public void insertVotesAndItems(PageVotes pageBean) throws Exception;

	/**
	 * Title:通过id查询一个vote及其相關信息(關聯查詢)
	 * <p>
	 * Description:信息包括:vote.*,vote的总票数,vote的选项数,vote总共有多少人参加
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:49:21
	 * @version 1.0
	 * @param id
	 * @return
	 */
	public PageVotes selectVoteWithCustomField(String id);

}
