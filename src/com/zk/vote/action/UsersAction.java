package com.zk.vote.action;

import com.zk.vote.pagebean.PageUsers;
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
public class UsersAction extends BaseAction {
	
	private PageUsers pageBean;
	
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
	public String login(){
		
		Tool.l.info(pageBean);
		
		return "index";
	}
}
