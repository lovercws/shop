package com.lovecws.shop.controller.system.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/system/user")
public class UserController {

	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list() {
		return "system/user/list";
	}
	
	/**
	 * 进入到编辑用户页面
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(){
		return "system/user/edit";
	}
	
	/**
	 * 进入到编辑用户页面
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(){
		return "system/user/view";
	}
	
	/**
	 * 进入到编辑用户页面
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		return "system/user/add";
	}
}
