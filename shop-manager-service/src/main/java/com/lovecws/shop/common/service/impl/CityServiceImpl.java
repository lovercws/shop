package com.lovecws.shop.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.shop.common.dao.CityDao;
import com.lovecws.shop.common.entity.City;
import com.lovecws.shop.common.service.CityService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<City> getCityByProvinceCode(String provinceCode) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("provinceCode", provinceCode);
		return cityDao.listByColumn(paramMap);
	}

}
