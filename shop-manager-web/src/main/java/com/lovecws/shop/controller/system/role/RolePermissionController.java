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
import com.lovecws.shop.system.entity.SysPermission;
import com.lovecws.shop.system.service.SysMenuService;
import com.lovecws.shop.system.service.SysPermissionService;
import com.lovecws.shop.system.service.SysRolePermissionService;

@Controller
@RequestMapping("/system/rolepermission")
public class RolePermissionController {

	private static final Logger log=Logger.getLogger(RolePermissionController.class);
	
	@Autowired
	private SysRolePermissionService rolePermissionService;
	@Autowired
	private SysPermissionService permissionService;
	@Autowired
	private SysMenuService menuService;
	
	/**
	 * 获取角色下的权限树
	 * @param roleId 角色id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/tree"},method=RequestMethod.GET)
	public List<ZTreeBean> getRoleMenuTree(String roleId){
		log.info("角色权限树[roleId="+roleId+"]");
		//获取当前角色下的菜单
		List<SysMenu> selectedMenus = menuService.getSysMenuByRoleId(roleId, PublicEnum.NORMAL.value());
		//获取所有的权限
		List<SysPermission> allPermissions = permissionService.querySysPermissionByCondition(null, null, null, PublicEnum.NORMAL.value(), null);
		//获取当前角色下的权限
		List<SysPermission> selectedPermissions=permissionService.getSysPermissionByRoleId(roleId,PublicEnum.NORMAL.value());
		//ztree 权限树树
		List<ZTreeBean> ztree=new ArrayList<ZTreeBean>();
		//ztree菜单树
		for (SysMenu sysMenu : selectedMenus) {
			ztree.add(new ZTreeBean(sysMenu.getMenuId(), sysMenu.getParentMenuId(), sysMenu.getMenuName(), true, sysMenu.getMenuIcon(), true));
		}	
		//当该角色没有分配菜单的时候 不准去分配权限
		if(ztree.size()>0){
			for (SysPermission sysPermission : allPermissions) {
				Integer permissionId = sysPermission.getPermissionId();
				boolean flag=false;
				for (SysPermission selectedPermission : selectedPermissions) {
					if(selectedPermission.getPermissionId()==permissionId){
						flag=true;
						break;
					}
				}
				ztree.add(new ZTreeBean(permissionId+10000, sysPermission.getMenuId(), sysPermission.getPermissionName(), true, null, flag));
			}
		}
		log.info(ztree);
		return ztree;
	}
	
	/**
	 * 保存角色权限
	 * @param roleId 角色id
	 * @param permissionIds 权限id（多条以逗号隔开）
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String saveRolePermission(String roleId,String permissionIds){
		log.info("保存权限[roleId="+roleId+",permissionIds=["+permissionIds+"]]");
		rolePermissionService.saveRolePermission(roleId,permissionIds,SecurityUtils.getSubject().getPrincipal().toString());
		return "redirect:/system/role/list";
	}
}
