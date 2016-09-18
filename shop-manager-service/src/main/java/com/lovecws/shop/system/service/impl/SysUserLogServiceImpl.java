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
import com.lovecws.shop.system.dao.SysUserLogDao;
import com.lovecws.shop.system.entity.SysUserLog;
import com.lovecws.shop.system.service.SysUserLogService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class SysUserLogServiceImpl implements SysUserLogService {

	@Autowired
	private SysUserLogDao userLogDao;

	@Override
	@Transactional(readOnly = false)
	public void addSysUserLog(SysUserLog sysUserLog) {
		userLogDao.insert(sysUserLog);
	}

	@Override
	public int getSysUserLogCount(String startDate, String endDate, String userLogStatus) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("userLogStatus", userLogStatus);
		return userLogDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysUserLog> querySysUserLogByCondition(String startDate, String endDate, String userLogStatus,
			PageParam pageParam) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("userLogStatus", userLogStatus);
		if(pageParam!=null){
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return userLogDao.listByColumn(paramMap);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteSysUserLogById(String userLogId) {
		userLogDao.delete(userLogId);
	}

}
