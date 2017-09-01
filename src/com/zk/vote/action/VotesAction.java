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

		try{
			
			String[] vItems = getRequest().getParameterValues("vItems");
			
			pageBean.setvItems(vItems);
			//设置launcherid
			Users u = (Users)getSessionAttr(UsersAction.ONLINE_USER_FIELD);
			
			if(u == null){
				throw new Exception("您已离线,请重新登录");
			}
			pageBean.setLauncherId(u.getId());
			
			votesService.insertVotesAndItems(pageBean);

			setRequestAttr("msg", "添加成功");
			setRequestAttr("curl","/votes/votesAction!selectVotesByPage.action?page=1");
			return "msg";
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		
		return "addVotes";
	}
	
	/**
	 * Title:查询一个vote
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:47:41
	 * @version 1.0
	 * @return
	 */
	public String selectVoteById(){

		try{
			pageBean = votesService.selectVoteById(pageBean.getId());
			
			setRequestAttr("vote", pageBean);
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return "voteInfo";
	}
}
