package com.zk.vote.action;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.pagebean.PageVoteItems;
import com.zk.vote.service.VoteItemsServiceI;

/**
 * Title:处理与投票相关的action
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年9月1日 上午10:59:22
 * @version 1.0
 */
public class VoteItemsAction extends BaseAction implements
		ModelDriven<PageVoteItems> {
	// pageBean
	private PageVoteItems pageBean;

	public PageVoteItems getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageVoteItems pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public PageVoteItems getModel() {
		return pageBean;
	}

	// voteItemsService
	private VoteItemsServiceI voteItemsService;

	public VoteItemsServiceI getVoteItemsService() {
		return voteItemsService;
	}

	public void setVoteItemsService(VoteItemsServiceI voteItemsService) {
		this.voteItemsService = voteItemsService;
	}

	

}
