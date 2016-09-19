package com.lovecws.shop.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.shop.common.dao.ProvinceDao;
import com.lovecws.shop.common.entity.Province;
import com.lovecws.shop.common.service.ProvinceService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;
	@Override
	public List<Province> getAllProvince() {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		return provinceDao.listByColumn(paramMap);
	}

}
