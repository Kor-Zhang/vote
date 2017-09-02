package com.zk.vote.mapper;

import java.util.List;

import com.zk.vote.bean.VoteItems;
import com.zk.vote.pagebean.PageVoteItems;

/**
 * Title:voteitems的mapper接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:04:45
 * @version 1.0
 */
public interface VoteItemsMapper {
	/**
	 * Title:插入一个投票选项
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:54:59
	 * @version 1.0
	 * @param voteItem
	 */
	public void insertVoteItem(VoteItems voteItem);
	
	/**
	 * Title:通过投票的id查询投票选项的基本信息,并且查詢其票数
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:55:32
	 * @version 1.0
	 * @param id
	 * @return
	 */
	public List<PageVoteItems> selectVoteItemsWithCustomField(String id);
}
