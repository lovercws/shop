package com.lovecws.shop.common.dao;

import java.util.List;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;

public interface CommonDao{

	public List<DBTable> getAllTable();

	public List<DBField> getAllField(String tableName);

	public List<List<Object>> getAllData(String tableName,String fields, String params);

}
