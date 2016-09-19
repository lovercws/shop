package com.lovecws.shop.common.service;

import java.util.List;

import com.lovecws.shop.common.entity.City;

public interface CityService {

	/**
	 * 获取城市列表
	 * @param provinceCode 省内码
	 * @return
	 */
	public List<City> getCityByProvinceCode(String provinceCode);

}
