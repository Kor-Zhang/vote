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
	 * Title:分页按theme关键字查找votes,及其関信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午1:49:04
	 * @version 1.0
	 * @return
	 */
	public String selectVoteWithCustomFieldByPageAndKW(){
		try{
			
			pageBean = votesService.selectVoteWithCustomFieldByPageAndKW(pageBean);
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
			setRequestAttr("curl","/votes/votesAction!selectVoteWithCustomFieldByPageAndKW.action?page=1&kw=");
			return "msg";
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		
		return "addVotes";
	}
	
	/**
	 * Title:通过id查询一个vote及其相關信息(關聯查詢)
	 * <p>
	 * Description:信息包括:vote.*,vote的总票数,vote的选项数,vote总共有多少人参加
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月1日 下午8:47:41
	 * @version 1.0
	 * @return
	 */
	public String selectVoteWithCustomField(){
		String forward = getRequestParam("forward");
		
		try{
			pageBean = votesService.selectVoteWithCustomField(pageBean.getId());
			
			setRequestAttr("vote", pageBean);
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return forward;
	}
	
	/**
	 * Title:分页按userid查询votes及其其他信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 上午10:54:15
	 * @version 1.0
	 * @return
	 */
	public String selectMyVoteWithCustomFieldByPage(){

		try{
			//获取当前在线的userid
			pageBean.setLauncherId(((Users)getSessionAttr(UsersAction.ONLINE_USER_FIELD)).getId());
			
			pageBean = votesService.selectMyVoteWithCustomFieldByPage(pageBean);
			
			setRequestAttr("votes", pageBean);
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return "myVotesList";
	}
	/**
	 * Title:更新一個vote及其相關信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 下午3:27:36
	 * @version 1.0
	 * @return
	 */
	public String updateVote(){
		setRequestAttr("curl", "/votes/votesAction!selectMyVoteWithCustomFieldByPage.action?page=1");
		try{
			//設置選項
			pageBean.setvItems(getRequest().getParameterValues("vItems"));
			
			String[] vItems = getRequest().getParameterValues("vItems");
			String[] vItemIds = getRequest().getParameterValues("vItemIds");
			String[] delItemIds = getRequest().getParameterValues("delItemIds");
			
			pageBean.setvItems(vItems);
			pageBean.setvItemIds(vItemIds);
			pageBean.setDelItemIds(delItemIds);
			
			votesService.updateVote(pageBean);
			
			setRequestAttr("msg", "修改成功");
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return "msg";
	}
	/**
	 * Title:删除一個vote及其相關信息
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月4日 下午3:27:36
	 * @version 1.0
	 * @return
	 */
	public String deleteVote(){
		setRequestAttr("curl", "/votes/votesAction!selectMyVoteWithCustomFieldByPage.action?page=1");
		try{
			
			votesService.deleteVote(pageBean.getId());
			
			setRequestAttr("msg", "删除成功");
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return "msg";
	}
}
