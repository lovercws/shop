package com.lovecws.shop.controller.system.user;

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
import com.lovecws.shop.system.entity.SysRole;
import com.lovecws.shop.system.service.SysRoleService;
import com.lovecws.shop.system.service.SysUserRoleService;

@Controller
@RequestMapping("/system/userrole")
public class UserRoleController {

	private static final Logger log = Logger.getLogger(UserRoleController.class);
	
	@Autowired
	private SysRoleService roleService;
	
	@Autowired
	private SysUserRoleService userRoleService;
	/**
	 * 用户分配角色
	 * @param userId 用户id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public List<ZTreeBean> tree(String userId){
		log.info("获取用户角色列表[userId="+userId+"]");
		//获取所有的角色
		List<SysRole> roles = roleService.querySysRoleByCondition(null, null, PublicEnum.NORMAL.value(), null);
		//获取用户已经选择的角色
		List<SysRole> selectedRoles=roleService.getSysRoleByUserId(userId,PublicEnum.NORMAL.value());
		List<ZTreeBean> tree=new ArrayList<ZTreeBean>();
		for (SysRole sysRole : roles) {
			boolean flag=false;
			for (SysRole role : selectedRoles) {
				if(role.getRoleId()==sysRole.getRoleId()){
					flag=true;
					break;
				}
			}
			tree.add(new ZTreeBean(sysRole.getRoleId().toString(), null, sysRole.getRoleName(), true, null, flag));
		}
		return tree;
	}
	
	/**
	 * 分配角色
	 * @param userId 用户id
	 * @param roleIds 角色id
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String save(String userId,String roleIds){
		log.info("保存用户角色[userId="+userId+",roleIds=["+roleIds+"]]");
		userRoleService.saveUserRole(userId,roleIds,SecurityUtils.getSubject().getPrincipal().toString());
		return "redirect:/system/user/list";
	}
}
