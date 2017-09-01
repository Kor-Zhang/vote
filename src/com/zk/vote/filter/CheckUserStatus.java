package com.zk.vote.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zk.vote.action.UsersAction;

/**
 * Title:检测用户是否在线
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午10:10:25
 * @version 1.0
 */
public class CheckUserStatus implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = ((HttpServletRequest)req);
		Object o = r.getSession().getAttribute(UsersAction.ONLINE_USER_FIELD);
		if( null == o){
			r.setAttribute("msg", "请先登录");
			r.getRequestDispatcher("/view/login.jsp").forward(r, res);
			return ;
		}else{
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
