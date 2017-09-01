package com.zk.vote.action;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.pagebean.PageVotes;
import com.zk.vote.service.VotesServiceI;

/**
 * Title:处理与投票相关的action
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年9月1日 上午10:59:22
 * @version 1.0
 */
public class VotesAction extends BaseAction implements ModelDriven<PageVotes>{
	//pageBean
	private PageVotes pageBean;

	public PageVotes getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageVotes pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public PageVotes getModel() {
		return pageBean;
	}

	//votesService
	private VotesServiceI votesService;

	public VotesServiceI getVotesService() {
		return votesService;
	}

	public void setVotesService(VotesServiceI votesService) {
		this.votesService = votesService;
	}
	
	
	
}
