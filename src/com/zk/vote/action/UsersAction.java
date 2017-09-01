package com.zk.vote.action;

import javax.servlet.http.Cookie;

import com.opensymphony.xwork2.ModelDriven;
import com.zk.vote.bean.Users;
import com.zk.vote.pagebean.PageUsers;
import com.zk.vote.service.UsersServiceI;
import com.zk.vote.util.Util;



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
	
	public final static String ONLINE_USER_FIELD = "user";
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
		Users dbUser = null;
		if(null == ( dbUser = usersService.login(pageBean))){
			
			setRequestAttr("msg", "账户或者密码错误");
		
			return "login";
		}
		//设置cookie记住密码
		Cookie usernameCookie = new Cookie("username", "");
		Cookie passwordCookie = new Cookie("password", "");
		if(pageBean.getRememberMe() !=null && pageBean.getRememberMe().equals("on")){
			usernameCookie = new Cookie("username", dbUser.getUsername());
			usernameCookie.setMaxAge(1*60*60*24*31*12);
			
			passwordCookie = new Cookie("password", dbUser.getPassword());
			passwordCookie.setMaxAge(1*60*60*24*31*12);
			
		}

		usernameCookie.setPath("/");
		passwordCookie.setPath("/");
		getResponse().addCookie(usernameCookie);
		getResponse().addCookie(passwordCookie);
		
		//设置用户在线
		setSessionAttr(ONLINE_USER_FIELD, dbUser);
		return "rindex";
	}

	/**
	 * Title:用户注册
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午9:39:19
	 * @version 1.0
	 * @return
	 * @throws Exception
	 */
	public String regist() throws Exception{
		try{
			//注册业务,等待捕获可能的异常
			usersService.regist(pageBean);
			
			//注册成功
			setRequestAttr("username", "");
			setRequestAttr("password", "");
			setRequestAttr("rePassword", "");
			setRequestAttr("msg", "用户名为: "+pageBean.getUsername()+" 的用户注册成功");
			
		}catch(Exception e){
			e.printStackTrace();
			setRequestAttr("msg", e.getMessage());
		}
		
		return "regist";
	}
	/**
	 * Title:账户注销
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午9:56:36
	 * @version 1.0
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		removeSessionAttr(ONLINE_USER_FIELD);
		getSession().invalidate();
		setRequestAttr("msg", "注销成功");
		return "login";
	}
	
}
