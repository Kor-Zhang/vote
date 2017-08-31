package com.zk.vote.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Title:基础action
 * <p>
 * Description:
 * <p>
 * @author Kor_Zhang
 * @date 2017年8月31日 下午2:48:18
 * @version 1.0
 */
public class BaseAction extends ActionSupport {

	/**
	 * Title:返回一个json到返回流
	 * <p>
	 * Description:
	 * <p>
	 * 
	 * @author Kor_Zhang
	 * @date 2017年8月31日 下午2:49:58
	 * @version 1.0
	 * @param o
	 */
	protected void writeJSON(Object o) {
		PrintWriter pt = null;
		try {
			// 获取输出流
			pt = ServletActionContext.getResponse().getWriter();
			// 序列化对象
			String json = JSON.toJSONStringWithDateFormat(o,
					"yyyy-MM-dd HH:mm:ss",
					SerializerFeature.DisableCircularReferenceDetect);
			// 写入对象
			pt.write(json);
			pt.flush();
			pt.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			pt.close();
		}
	}
}
