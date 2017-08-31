package com.zk.vote.service.impl;

import com.zk.vote.bean.Users;
import com.zk.vote.mapper.UsersMapper;
import com.zk.vote.pagebean.PageUsers;
import com.zk.vote.service.UsersServiceI;
import com.zk.vote.tool.Tool;

/**
 * Title:users的业务实现类
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午7:36:11
 * @version 1.0
 */
public class UserService implements UsersServiceI {
	/*usersMapper*/
	private UsersMapper usersMapper;
	
	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public boolean login(PageUsers pageBean) throws Exception{
		Users dbUser = usersMapper.selectUserByName(pageBean.getUsername());
		
		return (dbUser !=null && (dbUser.getPassword().equals(pageBean.getPassword()))) ? true : false;
	}

	

}
