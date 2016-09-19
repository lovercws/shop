package com.lovecws.shop.controller.common.ddl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.shop.common.entity.Area;
import com.lovecws.shop.common.service.AreaService;

@Controller
@RequestMapping("/common/area")
public class AreaController {

	private static final Logger log=Logger.getLogger(AreaController.class);
	@Autowired
	private AreaService areaService;
	
	/**
	 * 获取城市下的所有区域
	 * @param cityCode 城市内码
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Area> getAreaByCityCode(String cityCode) {
		log.info("获取地区列表[cityCode="+cityCode+"]");
		List<Area> areas=areaService.getAreaByCityCode(cityCode);
		return areas;
	}
}
