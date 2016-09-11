package com.lovecws.shop.controller.system.role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/role")
public class RoleController {

	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list() {
		return "system/role/list";
	}
	
	/**
	 * 进入到编辑角色页面
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(){
		return "system/role/edit";
	}
	
	/**
	 * 进入到编辑角色页面
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(){
		return "system/role/view";
	}
	
	/**
	 * 进入到编辑角色页面
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		return "system/role/add";
	}
}
