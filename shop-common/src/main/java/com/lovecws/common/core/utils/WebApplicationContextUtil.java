package com.lovecws.common.core.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @desc spring WebApplicationContext工具类
 * @author ganliang
 * @version 2016年9月27日 上午11:51:37
 */
public class WebApplicationContextUtil {

	/**
	 * 获取bean 实体
	 * @param clazz 字节码对象
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz){
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext(); 
		return applicationContext.getBean(clazz);
	}
}
