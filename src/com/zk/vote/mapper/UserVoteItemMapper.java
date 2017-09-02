package com.zk.vote.mapper;

import com.zk.vote.bean.UserVoteItem;


/**
 * Title:用户和投票的关系
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:04:45
 * @version 1.0
 */
public interface UserVoteItemMapper {
	
	/**
	 * Title:插入一条投票记录
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月2日 上午9:20:20
	 * @version 1.0
	 * @param pageBean
	 */
	void insertOne(UserVoteItem uvi);

}
