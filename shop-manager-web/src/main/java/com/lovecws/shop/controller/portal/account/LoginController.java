package com.lovecws.shop.controller.portal.account;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portal/account")
public class LoginController {

	/**
	 * 跳转到登陆界面
	 * @return
	 */
	@RequestMapping(value={"/logining"},method=RequestMethod.GET)
	public String login(){
		return "portal/account/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(value = { "/login" },method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView login(HttpServletRequest request) {
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)){
			error = "输入错误次数太过，请稍后重试";
		} else if (exceptionClassName != null) {
			error = "错误提示：" + exceptionClassName;
		}
		if(error!=null){
			request.setAttribute("shiroLoginFailure", error);
			return new ModelAndView("/portal/account/login");
		}
		return new ModelAndView("redirect:/system/layout/main");
	}
}
