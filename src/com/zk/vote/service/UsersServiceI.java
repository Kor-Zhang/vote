package com.zk.vote.service;

import com.zk.vote.bean.Users;
import com.zk.vote.pagebean.PageUsers;

/**
 * Title:users的业务接口
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午7:33:51
 * @version 1.0
 */
public interface UsersServiceI {
	
	/**
	 * Title:登录业务
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:42:06
	 * @version 1.0
	 * @param pageBean
	 * @return	返回数据库中的用户信息
	 */
	Users login(PageUsers pageBean) throws Exception;

	
	/**
	 * Title:注册一个用户
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午9:42:18
	 * @version 1.0
	 * @param pageBean
	 * @throws Exception 
	 */
	void regist(PageUsers pageBean) throws Exception;
}
