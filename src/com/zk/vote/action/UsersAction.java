package com.zk.vote.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.pagebean.PageUsers;
import com.zk.vote.service.UsersServiceI;
import com.zk.vote.tool.Tool;



/**
 * 
 * Title:关于用户的action
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年8月31日 下午2:30:20
 * @version 1.0
 */
public class UsersAction extends BaseAction implements ModelDriven<PageUsers>{
	/*pageBean*/
	private PageUsers pageBean;
	

	public PageUsers getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageUsers pageBean) {
		this.pageBean = pageBean;
	}
	@Override
	public PageUsers getModel() {
		return pageBean;
	}

	/*usersService*/
	private UsersServiceI usersService;
	
	public UsersServiceI getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersServiceI usersService) {
		this.usersService = usersService;
	}




	/**
	 * Title:用户登录
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午3:26:52
	 * @version 1.0
	 * @return
	 */
	public String login() throws Exception{
		
		if(!usersService.login(pageBean)){
			
			ServletActionContext.getRequest().setAttribute("msg", "账户或者密码错误");
		
			return "login";
		}
		
		return "index";
	}

	
}
