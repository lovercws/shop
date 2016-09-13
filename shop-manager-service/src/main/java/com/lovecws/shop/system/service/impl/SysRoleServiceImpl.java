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
import com.lovecws.shop.system.dao.SysRoleDao;
import com.lovecws.shop.system.entity.SysRole;
import com.lovecws.shop.system.service.SysRoleService;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao roleDao;

	@Override
	public int getSysRoleCount(String roleCode, String roleName, String roleStatus) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleCode", roleCode);
		paramMap.put("roleName", roleName);
		paramMap.put("roleStatus", roleStatus);
		return roleDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysRole> querySysRoleByCondition(String roleCode, String roleName, String roleStatus,
			PageParam pageParam) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleCode", roleCode);
		paramMap.put("roleName", roleName);
		paramMap.put("roleStatus", roleStatus);
		if(pageParam!=null){
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return roleDao.listByColumn(paramMap);
	}

	@Override
	@Transactional(readOnly=false)
	public SysRole addSysRole(SysRole role) {
		return roleDao.insert(role);
	}

	@Override
	public SysRole getSysRoleById(String roleId) {
		return roleDao.getById(roleId);
	}

	@Override
	@Transactional(readOnly=false)
	public SysRole updateSysRoleById(SysRole role) {
		roleDao.update(role);
		return role;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteById(String roleId) {
		roleDao.delete(roleId);
	}

}
