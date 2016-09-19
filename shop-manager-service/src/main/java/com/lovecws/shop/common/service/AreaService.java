package com.lovecws.shop.common.service;

import java.util.List;

import com.lovecws.shop.common.entity.Area;

public interface AreaService {

	/**
	 * 获取地区列表
	 * @param cityCode 城市内码
	 * @return
	 */
	public List<Area> getAreaByCityCode(String cityCode);

}
