package com.lovecws.shop.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.shop.common.dao.AreaDao;
import com.lovecws.shop.common.entity.Area;
import com.lovecws.shop.common.service.AreaService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> getAreaByCityCode(String cityCode) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("cityCode", cityCode);
		return areaDao.listByColumn(paramMap);
	}

}
