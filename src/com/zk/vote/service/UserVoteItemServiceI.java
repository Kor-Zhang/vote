package com.zk.vote.service;

import com.zk.vote.pagebean.PageUserVoteItem;

/**
 * Title:用户和投票的业务接口
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:01:52
 * @version 1.0
 */
public interface UserVoteItemServiceI {
	/**
	 * Title:投票
	 * <p>
	 * Description:
	 * <p>
	 * 
	 * @author Kor_Zhang
	 * @date 2017年9月2日 上午8:48:29
	 * @version 1.0
	 * @param pageBean
	 * @throws Exception
	 */
	public void vote(PageUserVoteItem pageBean) throws Exception;
}
