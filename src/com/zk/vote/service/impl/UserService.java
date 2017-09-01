package com.zk.vote.service.impl;

import java.util.UUID;

import com.zk.vote.bean.Users;
import com.zk.vote.mapper.UsersMapper;
import com.zk.vote.pagebean.PageUsers;
import com.zk.vote.service.UsersServiceI;
import com.zk.vote.util.Util;

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
	public Users login(PageUsers pageBean) throws Exception{
		Users dbUser = usersMapper.selectUserByName(pageBean.getUsername());
		
		return (dbUser !=null && (dbUser.getPassword().equals(pageBean.getPassword()))) ? dbUser : null;
	}

	@Override
	public void regist(PageUsers pageBean)  throws Exception{
		
		if(null == pageBean){
			throw new Exception("信息不能为空");
		}
		if(null == pageBean.getUsername() || pageBean.getUsername().equals("")){
			throw new Exception("用户名不能为空");
		}

		if(null == pageBean.getPassword() || pageBean.getPassword().equals("")){
			throw new Exception("密码不能为空");
		}
		
		if(null == pageBean.getRePassword() || pageBean.getRePassword().equals("")){
			throw new Exception("请确认密码");
		}
		
		if(!pageBean.getRePassword().equals(pageBean.getPassword())){
			throw new Exception("两次输入的密码不一致");
		}
		
		if(null != usersMapper.selectUserByName(pageBean.getUsername())){
			throw new Exception("该用户名已存在");
		}
		//设置其id
		pageBean.setId(UUID.randomUUID().toString());
		
		usersMapper.insertUser(pageBean);
	}

	

}
