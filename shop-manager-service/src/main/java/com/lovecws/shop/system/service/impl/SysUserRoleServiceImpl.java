package com.lovecws.shop.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.shop.system.dao.SysUserRoleDao;
import com.lovecws.shop.system.entity.SysUserRole;
import com.lovecws.shop.system.service.SysUserRoleService;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao userRoleDao;

	@Transactional(readOnly = false)
	@Override
	public void saveUserRole(String userId, String roleIds, String creator) {
		// 删除 用户角色
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		userRoleDao.delete(paramMap);
		
		if (roleIds != null && !"".equals(roleIds)) {
			String[] roleArray = roleIds.split(",");
			List<SysUserRole> userRoles = new ArrayList<SysUserRole>();
			for (String roleId : roleArray) {
				userRoles.add(new SysUserRole(PublicEnum.NORMAL.value(), creator, new Date(),
						Integer.parseInt(roleId), Integer.parseInt(userId)));
			}
			// 添加角色权限
			userRoleDao.insert(userRoles);
		}
	}

}
