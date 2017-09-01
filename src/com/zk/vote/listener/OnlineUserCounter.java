package com.zk.vote.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.zk.vote.util.ActionUtil;

/**
 * Title:监听在线人数
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午10:11:38
 * @version 1.0
 */
public class OnlineUserCounter implements HttpSessionListener{
	public static final String USER_NUMBER_FIELD = "onlineUserNumber";
	@Override
	public void sessionCreated(HttpSessionEvent s) {
		ServletContext sc = s.getSession().getServletContext();
		//累加数量
		Object num = sc.getAttribute(USER_NUMBER_FIELD);
		if(null == num){
			num = 0;
		}
		sc.setAttribute(USER_NUMBER_FIELD, ((Integer)num)+1);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
