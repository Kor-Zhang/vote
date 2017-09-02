package com.zk.vote.action;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.bean.Users;
import com.zk.vote.pagebean.PageUserVoteItem;
import com.zk.vote.service.impl.UserVoteItemService;
import com.zk.vote.util.Util;

/**
 * Title:用户与投票关系action
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 上午10:59:22
 * @version 1.0
 */
public class UserVoteItemAction extends BaseAction implements
		ModelDriven<PageUserVoteItem> {
	// pageBean
	private PageUserVoteItem pageBean;

	public PageUserVoteItem getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageUserVoteItem pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public PageUserVoteItem getModel() {
		return pageBean;
	}

	// userVoteItemService
	private UserVoteItemService userVoteItemService;

	public UserVoteItemService getUserVoteItemService() {
		return userVoteItemService;
	}

	public void setUserVoteItemService(UserVoteItemService userVoteItemService) {
		this.userVoteItemService = userVoteItemService;
	}
	/**
	 * 投票 Title:
	 * <p>
	 * Description:
	 * <p>
	 * 
	 * @author Kor_Zhang
	 * @date 2017年9月2日 上午8:42:46
	 * @version 1.0
	 * @return
	 */
	public String vote() {
		//设置消息界面返回按钮返回的界面
		setRequestAttr("curl", "/votes/votesAction!selectVoteWithCustomField.action?id="+pageBean.getVoteId());
		try {
			Users u = getSessionAttr(UsersAction.ONLINE_USER_FIELD);
			Util.eject(u == null, "您已离线");
			//获取在线用户
			pageBean.setOnlineUserId(u.getId());
			
			userVoteItemService.vote(pageBean);
			setRequestAttr("msg", "投票成功");
		} catch (Exception e) {
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		return "msg";
	}

}
