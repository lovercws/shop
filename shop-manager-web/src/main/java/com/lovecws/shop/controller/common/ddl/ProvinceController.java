package com.lovecws.shop.controller.common.ddl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.shop.common.entity.Province;
import com.lovecws.shop.common.service.ProvinceService;

@Controller
@RequestMapping("/common/province")
public class ProvinceController {

	private static final Logger log = Logger.getLogger(ProvinceController.class);
	@Autowired
	private ProvinceService provinceService;

	/**
	 * 获取所有的省
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Province> getProvince() {
		log.info("获取省份列表");
		List<Province> provinces = provinceService.getAllProvince();
		return provinces;
	}
}
