package com.lovecws.shop.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.dao.SysPermissionDao;
import com.lovecws.shop.system.dao.SysRolePermissionDao;
import com.lovecws.shop.system.entity.SysPermission;
import com.lovecws.shop.system.service.SysPermissionService;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
@Service
public class SysPermissionServiceImpl implements SysPermissionService{

	@Autowired
	private SysPermissionDao permissionDao;
	@Autowired
	private SysRolePermissionDao rolePermissionDao;

	@Override
	public int getSysPermssionCount(String menuId, String permissionCode, String permissionName,
			String permissionStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
		paramMap.put("permissionCode", permissionCode);
		paramMap.put("permissionName", permissionName);
		paramMap.put("permissionStatus", permissionStatus);
		return permissionDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysPermission> querySysPermissionByCondition(String menuId, String permissionCode,
			String permissionName, String permissionStatus, PageParam pageParam) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
		paramMap.put("permissionCode", permissionCode);
		paramMap.put("permissionName", permissionName);
		paramMap.put("permissionStatus", permissionStatus);
		if(pageParam!=null){
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return permissionDao.listByColumn(paramMap);
	}

	@Override
	@Transactional(readOnly=false)
	public SysPermission addPermission(SysPermission permission) {
		return permissionDao.insert(permission);
	}

	@Override
	@Transactional(readOnly=false)
	public SysPermission updatePermissionById(SysPermission permission) {
		permissionDao.update(permission);
		return permission;
	}

	@Override
	public SysPermission getSysPermissionById(String permissionId) {
		return permissionDao.getById(permissionId);
	}

	@Override
	@Transactional(readOnly=false)
	public void deletePermissionById(String permissionId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("permissionId", permissionId);
		//删除角色权限
		rolePermissionDao.delete(paramMap);
		//删除权限
		permissionDao.delete(permissionId);
	}

	@Override
	public List<SysPermission> getSysPermissionByRoleId(String roleId, String permissionStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		paramMap.put("permissionStatus", permissionStatus);
		return permissionDao.selectList("getSysPermissionByRoleId", paramMap);
	}
}
