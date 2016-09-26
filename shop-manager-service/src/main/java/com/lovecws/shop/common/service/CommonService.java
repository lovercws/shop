package com.lovecws.shop.common.service;

import java.util.List;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;

public interface CommonService {

	public List<DBTable> getAllTable();

	public List<DBField> getAllField(String tableName);

}
