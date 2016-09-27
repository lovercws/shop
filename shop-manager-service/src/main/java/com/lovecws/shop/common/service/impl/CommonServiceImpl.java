package com.lovecws.shop.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;
import com.lovecws.shop.common.dao.CommonDao;
import com.lovecws.shop.common.service.CommonService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public List<DBTable> getAllTable(){
		return commonDao.getAllTable();
	}
	
	@Override
	public List<DBField> getAllField(String tableName){
		return commonDao.getAllField(tableName);
	}

	@Override
	public List<List<Object>> getAllData(String tableName, String fields,String params) {
		return commonDao.getAllData(tableName, fields,params);
	}
	
}
