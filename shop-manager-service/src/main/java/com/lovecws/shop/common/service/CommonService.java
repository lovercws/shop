package com.lovecws.shop.common.service;

import java.util.List;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;

public interface CommonService {

	/**
	 * 获取当前连接数据库所有的表
	 * @return
	 */
	public List<DBTable> getAllTable();

	/**
	 * 获取表下的所有字段
	 * @param tableName 表名
	 * @return
	 */
	public List<DBField> getAllField(String tableName);

	/**
	 * 获取表下的所有数据
	 * @param tableName 表名(sys_user)
	 * @param fields 字段(id,name,status)
	 * @param params 参数（where status=1）
	 * @return
	 */
	public List<List<Object>> getAllData(String tableName,String fields,String params);
}
