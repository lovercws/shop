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
import com.lovecws.shop.system.dao.SysExportModelDao;
import com.lovecws.shop.system.entity.SysExportModel;
import com.lovecws.shop.system.service.SysExportModelService;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class SysExportModelServiceImpl implements SysExportModelService{

	@Autowired
	private SysExportModelDao sysExportModelDao;
	
	@Override
	public int getSysExportModelCount(String qmodelName, String exportModelStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("modelName", qmodelName);
		paramMap.put("modelStatus", exportModelStatus);
		return sysExportModelDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysExportModel> querySysExportModelByCondition(String qmodeleName, String exportModelStatus, PageParam pageParam) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("modelName", qmodeleName);
		paramMap.put("modelStatus", exportModelStatus);
		if(pageParam!=null){
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return sysExportModelDao.listByColumn(paramMap);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteById(String modelId) {
		sysExportModelDao.delete(modelId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addExportModel(SysExportModel exportModel) {
		sysExportModelDao.insert(exportModel);
	}

	@Override
	public SysExportModel getSysExportModelById(String modelId) {
		return sysExportModelDao.getById(modelId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateSysExportModel(SysExportModel exportModel) {
		sysExportModelDao.update(exportModel);
	}

}
