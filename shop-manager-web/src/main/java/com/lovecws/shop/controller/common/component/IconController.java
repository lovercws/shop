package com.lovecws.shop.controller.common.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/common/component")
public class IconController {
	
	/**
	 * 进入到图标选择界面
	 * @return
	 */
	@RequestMapping(value = { "/icon" }, method = RequestMethod.GET)
	public String icon() {
		return "common/component/icon";
	}
}
