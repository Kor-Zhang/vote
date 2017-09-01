package com.zk.vote.action;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.bean.Users;
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
	
	/**
	 * Title:分页查找votes
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午1:49:04
	 * @version 1.0
	 * @return
	 */
	public String selectVotesByPage(){
		try{
			
			pageBean = votesService.selectVotesByPage(pageBean);
			setRequestAttr("votes", pageBean);
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		return "votesList";
	}
	
	/**
	 * Title:添加投票及其选项
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午6:14:19
	 * @version 1.0
	 * @return
	 */
	public String addVotesAndItems(){

			setRequestAttr("curl","/view/addVotes.jsp");
			try{
				//设置launcherid
				Users u = (Users)getSessionAttr(UsersAction.ONLINE_USER_FIELD);
				pageBean.setLauncherId(u.getId());
				
				votesService.insertVotesAndItems(pageBean);

				setRequestAttr("msg", "添加成功");
			}catch(Exception e){
				e.printStackTrace();
				setRequestAttr("msg", e.getMessage());
			}
		
		
		return "msg";
	}
}
