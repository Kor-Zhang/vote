package com.zk.vote.util;

import org.apache.log4j.Logger;

/**
 * Title:工具类
 * <p>
 * Description:
 * <p>
 * 
 * @author Kor_Zhang
 * @date 2017年8月31日 下午3:14:15
 * @version 1.0
 */
public class Util extends ActionUtil{
	public static final Logger l = Logger.getLogger(Util.class);
	
	
	/**
	 * Title:如果表达式成立,抛出异常
	 * <p>
	 * Description:
	 * <p>
	 * @author Kor_Zhang
	 * @date 2017年9月2日 上午9:43:52
	 * @version 1.0
	 * @param expr
	 */
	public static void eject(Boolean expr,String msg) throws Exception{
		if(expr){
			throw new Exception(msg);
		}
	}
}
