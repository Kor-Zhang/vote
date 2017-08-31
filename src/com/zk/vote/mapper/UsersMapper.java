package com.zk.vote.mapper;

import java.util.List;

import com.zk.vote.bean.Users;

/**
 * Title:users表的mapper
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午7:17:11
 * @version 1.0
 */
public interface UsersMapper {
	/**
	 * Title:查询所有用户
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:20:10
	 * @version 1.0
	 * @return
	 */
	List<Users> selectUsers();
	
	/**
	 * Title:通过userId查询一个User
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:20:32
	 * @version 1.0
	 * @param userId
	 * @return
	 */
	Users selectUserById(String userId);
	/**
	 * Title:通过用户的name查找用户
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午8:17:45
	 * @version 1.0
	 * @param userName
	 * @return
	 */
	Users selectUserByName(String userName);
	
	
	/**
	 * Title:插入一个user
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:21:37
	 * @version 1.0
	 * @param user
	 */
	void insertUser(Users user);
	
	/**
	 * Title:通过userId删除一个用户
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:22:04
	 * @version 1.0
	 * @param userId
	 */
	void deleteUserById(String userId);
	
	/**
	 * Title:更新一条记录
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午7:22:34
	 * @version 1.0
	 * @param user
	 */
	void updateUser(Users user);
}
