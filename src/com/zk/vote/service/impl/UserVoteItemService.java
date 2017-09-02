package com.zk.vote.service.impl;

import java.util.UUID;

import com.zk.vote.bean.UserVoteItem;
import com.zk.vote.bean.Users;
import com.zk.vote.bean.VoteItems;
import com.zk.vote.bean.Votes;
import com.zk.vote.mapper.UserVoteItemMapper;
import com.zk.vote.pagebean.PageUserVoteItem;
import com.zk.vote.service.UserVoteItemServiceI;
import com.zk.vote.util.Util;

/**
 * Title:用户和投票的业务接口实现
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午11:03:58
 * @version 1.0
 */
public class UserVoteItemService implements UserVoteItemServiceI {
	//userVoteItemMapper
	private UserVoteItemMapper userVoteItemMapper;

	public UserVoteItemMapper getUserVoteItemMapper() {
		return userVoteItemMapper;
	}

	public void setUserVoteItemMapper(UserVoteItemMapper userVoteItemMapper) {
		this.userVoteItemMapper = userVoteItemMapper;
	}
	
	

	/**
	 * Title:投票业务
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月2日 上午8:44:01
	 * @version 1.0
	 * @param pageBean
	 * @throws Exception 
	 */
	public void vote(PageUserVoteItem pageBean) throws Exception {
		if(pageBean.getOnlineUserId() == null){
			throw new Exception("您已离线");
		}
		
		
		//设置Users
		Users u = new Users();
		u.setId(pageBean.getOnlineUserId());
		pageBean.setJoiner(u);
		
		//设置VoteItems
		VoteItems vi = new VoteItems();
		vi.setId(pageBean.getItemId());
		
		pageBean.setVoteItem(vi);
		//设置votes
		Votes v = new Votes();
		v.setId(pageBean.getVoteId());
		
		pageBean.setVote(v);

		//通过投票id和用户id获取用户的某个投票记录
		Object o = userVoteItemMapper.selectTheVoteOfUser((UserVoteItem)pageBean);
		Util.eject(null != o, "您已投过了");
		
		
		//设置id
		pageBean.setId(UUID.randomUUID().toString());
		
		
		//VoteItems vi = new VoteItems(UUID.randomUUID().toString(), master, pageBean.getDescription(), userVoteItems)
		//插入数据
		userVoteItemMapper.insertOne((UserVoteItem)pageBean);
	}



}
