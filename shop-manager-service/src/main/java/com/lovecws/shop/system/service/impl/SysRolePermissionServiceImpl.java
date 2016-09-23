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
import com.lovecws.shop.system.dao.SysRolePermissionDao;
import com.lovecws.shop.system.entity.SysRolePermission;
import com.lovecws.shop.system.service.SysRolePermissionService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

	@Autowired
	private SysRolePermissionDao rolePermissionDao;

	@Transactional(readOnly = false)
	@Override
	public void saveRolePermission(String roleId, String permissionIds, String creator) {
		// 删除 角色权限
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		rolePermissionDao.delete(paramMap);
		if (permissionIds != null && !"".equals(permissionIds)) {
			String[] permissionArray = permissionIds.split(",");
			List<SysRolePermission> rolePermissions = new ArrayList<SysRolePermission>();
			for (String permissionId : permissionArray) {
				rolePermissions.add(new SysRolePermission(PublicEnum.NORMAL.value(), creator, new Date(),
						Integer.parseInt(roleId), Integer.parseInt(permissionId)));
			}
			// 添加角色权限
			rolePermissionDao.insert(rolePermissions);
		}

	}

}
