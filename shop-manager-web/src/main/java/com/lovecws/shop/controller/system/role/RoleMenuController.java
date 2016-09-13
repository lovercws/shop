package com.lovecws.shop.controller.system.role;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.tree.ZTreeBean;
import com.lovecws.shop.system.entity.SysMenu;
import com.lovecws.shop.system.service.SysMenuService;
import com.lovecws.shop.system.service.SysRoleMenuService;

@Controller
@RequestMapping("/system/rolemenu")
public class RoleMenuController {

	private static final Logger log=Logger.getLogger(RoleMenuController.class);
	
	@Autowired
	private SysRoleMenuService roleMenuService;
	@Autowired
	private SysMenuService menuService;
	
	/**
	 * 获取角色下的菜单列表
	 * @param roleId 角色id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/tree"},method=RequestMethod.GET)
	public List<ZTreeBean> getRoleMenuTree(String roleId){
		log.info("角色菜单树[roleId="+roleId+"]");
		//获取所有的菜单
		List<SysMenu> allMenus = menuService.querySysMenuByCondition(null, null, null, PublicEnum.NORMAL.value(), null);
		//获取当前角色下的菜单
		List<SysMenu> selectedMenus=menuService.getSysMenuByRoleId(roleId,PublicEnum.NORMAL.value());
		//ztree树
		List<ZTreeBean> ztree=new ArrayList<ZTreeBean>();
		for (SysMenu menu : allMenus) {
			Integer menuId = menu.getMenuId();
			boolean flag=false;
			for (SysMenu sysMenu : selectedMenus) {
				if(sysMenu.getMenuId()==menuId){
					flag=true;
					break;
				}
			}
			if(flag){
				ztree.add(new ZTreeBean(menuId, menu.getParentMenuId(), menu.getMenuName(), true, menu.getMenuIcon(), true));
			}else{
				ztree.add(new ZTreeBean(menuId, menu.getParentMenuId(), menu.getMenuName(), true, menu.getMenuIcon(), false));
			}
		}
		System.out.println(ztree);
		return ztree;
	}
	
	/**
	 * 保存角色菜单
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String saveRoleMenu(String roleId,String menuIds){
		log.info("保存角色菜单[roleId="+roleId+",menuIds=["+menuIds+"]]");
		roleMenuService.saveRoleMenu(roleId,menuIds,SecurityUtils.getSubject().getPrincipal().toString());
		return "redirect:/system/role/list";
	}
}
