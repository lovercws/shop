package com.lovecws.shop.controller.system.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/layout")
public class LayoutController {

	/**
	 * 跳转到后台系统布局页面
	 * @return
	 */
	@RequestMapping(value={"/main"},method=RequestMethod.GET)
	public String main(){
		return "system/layout/main";
	}
	
	/**
	 * 头部功能栏
	 * @return
	 */
	@RequestMapping(value={"/header"},method=RequestMethod.GET)
	public String header(){
		return "system/layout/header";
	}
	
	/**
	 * 功能菜单栏
	 * @return
	 */
	@RequestMapping(value={"/menu"},method=RequestMethod.GET)
	public String menu(){
		return "system/layout/menu";
	}
	
	/**
	 * 底部功能栏
	 * @return
	 */
	@RequestMapping(value={"/footer"},method=RequestMethod.GET)
	public String footer(){
		return "system/layout/footer";
	}
}
