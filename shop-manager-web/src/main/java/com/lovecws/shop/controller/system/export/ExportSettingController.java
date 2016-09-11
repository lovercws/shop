package com.lovecws.shop.controller.system.export;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @desc 导出设置
 * @author ganliang
 * @version 2016年9月11日 上午8:46:56
 */
@Controller
@RequestMapping("/system/export")
public class ExportSettingController {

	/**
	 * 进入到导出设置列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(){
		return "system/export/list";
	}
}
