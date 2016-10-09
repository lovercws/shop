package com.lovecws.shop.controller.portal.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/portal/account")
public class RegisterController {

	/**
	 * 跳转到注册界面
	 * @return
	 */
	@RequestMapping(value={"/register"},method=RequestMethod.GET)
	public String register(){
		return "portal/account/register";
	}
	
	/**
	 * 跳转到注册详情页面
	 * @return
	 */
	@RequestMapping(value={"/register"},method=RequestMethod.POST)
	public String registerDetail(){
		return "portal/account/registerDetail";
	}
}
