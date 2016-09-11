package com.lovecws.shop.controller.system.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/permission")
public class PermissionController {

	/**
	 * 显示权限列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(){
		return "system/permission/list";
	}
	
	/**
	 * 进入到编辑权限页面
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(){
		return "system/permission/edit";
	}
	
	/**
	 * 进入到编辑权限页面
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(){
		return "system/permission/view";
	}
	
	/**
	 * 进入到编辑权限页面
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		return "system/permission/add";
	}
	
}
