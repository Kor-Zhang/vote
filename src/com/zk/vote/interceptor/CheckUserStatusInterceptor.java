package com.zk.vote.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 
 * Title:字符编码拦截器
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午2:34:02
 * @version 1.0
 */
public class CheckUserStatusInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		return invocation.invoke();
	}

}
