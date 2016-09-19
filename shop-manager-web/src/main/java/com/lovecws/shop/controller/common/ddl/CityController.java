package com.lovecws.shop.controller.common.ddl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.shop.common.entity.City;
import com.lovecws.shop.common.service.CityService;

@Controller
@RequestMapping("/common/city")
public class CityController {

	private static final Logger log=Logger.getLogger(CityController.class);
	@Autowired
	private CityService cityService;
	
	/**
	 * 获取省下面的城市列表
	 * @param provinceCode 省内码
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<City> getCityByProvinceCode(String provinceCode) {
		log.info("获取城市列表[provinceCode="+provinceCode+"]");
		List<City> citys=cityService.getCityByProvinceCode(provinceCode);
		return citys;
	}
}
