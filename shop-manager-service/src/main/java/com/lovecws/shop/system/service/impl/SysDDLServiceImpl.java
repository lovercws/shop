package com.lovecws.shop.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.dao.SysDDLDao;
import com.lovecws.shop.system.entity.SysDDL;
import com.lovecws.shop.system.service.SysDDLService;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
@Service
public class SysDDLServiceImpl implements SysDDLService{

	@Autowired
	private SysDDLDao ddlDao;
	
	@Override
	public int getSysDDLCount(String ddlCode, String ddlKey,String ddlStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ddlCode", ddlCode);
		paramMap.put("ddlKey", ddlKey);
		paramMap.put("ddlStatus", ddlStatus);
		return ddlDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysDDL> querySysDDLByCondition(String ddlCode, String ddlKey, String ddlStatus, PageParam pageParam) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ddlCode", ddlCode);
		paramMap.put("ddlKey", ddlKey);
		paramMap.put("ddlStatus", ddlStatus);
		paramMap.put("beginIndex", pageParam.getBeginIndex());
		paramMap.put("numPerPage", pageParam.getNumPerPage());
		return ddlDao.listByColumn(paramMap);
	}

	@Override
	@Transactional(readOnly=false)
	public SysDDL addSysDDL(SysDDL ddl) {
		return ddlDao.insert(ddl);
	}

	@Override
	public List<SysDDL> getUniqueSysDDL(String ddlStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ddlStatus", ddlStatus);
		return ddlDao.selectList("getUniqueSysDDL", paramMap);
	}

	@Override
	public SysDDL getSysDDLById(String ddlId) {
		return ddlDao.getById(ddlId);
	}

	@Override
	@Transactional(readOnly=false)
	public SysDDL updateSysDDLById(SysDDL ddl) {
		ddlDao.update(ddl);
		return ddl;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteSysDDLById(String ddlId) {
		ddlDao.delete(ddlId);
	}
}
