package com.lovecws.shop.controller.system.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/menu")
public class MenuController {

	/**
	 * 显示菜单列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(){
		return "system/menu/list";
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(){
		return "system/menu/edit";
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(){
		return "system/menu/view";
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		return "system/menu/add";
	}
	
}
