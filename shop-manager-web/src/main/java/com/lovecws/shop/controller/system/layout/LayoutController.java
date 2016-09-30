package com.lovecws.shop.controller.system.layout;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovecws.common.core.tree.MenuTree;
import com.lovecws.shop.shiro.cache.CacheManager;
import com.lovecws.shop.system.entity.SysMenu;
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.service.SysMenuService;

@Controller
@RequestMapping("/system/layout")
public class LayoutController {

	@Autowired
	private SysMenuService menuService;
	@Autowired
	private CacheManager cacheManager;
	
	public static final String CACHENAME="menuTree";
	
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
	public String menu(HttpServletRequest request){
		String loginName = SecurityUtils.getSubject().getPrincipal().toString();
		Object menuData = cacheManager.get(CACHENAME, loginName);
		if(menuData==null){
			//获取保存在session中的用户
			SysUser user=(SysUser) SecurityUtils.getSubject().getSession().getAttribute(SysUser.SYS_USER);
			//获取登录用户的菜单
			List<SysMenu> menus=menuService.getSysMenuByUserId(user.getUserId());
			//组建菜单树
			List<MenuTree> tree=new ArrayList<MenuTree>();
			for (SysMenu sysMenu : menus) {
				tree.add(new MenuTree(sysMenu.getMenuId(), sysMenu.getParentMenuId(), sysMenu.getMenuIcon(), sysMenu.getMenuUrl(), sysMenu.getMenuName()));
			}
			//树形化
			menuData = MenuTree.tree(tree);
			//加入缓存
			cacheManager.put(CACHENAME, loginName, menuData);
		}
		request.setAttribute("menuData", menuData);
		
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
