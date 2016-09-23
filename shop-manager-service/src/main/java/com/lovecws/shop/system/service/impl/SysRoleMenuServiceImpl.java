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
import com.lovecws.shop.system.dao.SysRoleMenuDao;
import com.lovecws.shop.system.entity.SysRoleMenu;
import com.lovecws.shop.system.service.SysRoleMenuService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

	@Autowired
	private SysRoleMenuDao roleMenuDao;

	@Override
	@Transactional(readOnly = false)
	public void saveRoleMenu(String roleId, String menuIds, String creator) {
		// 删除 角色原菜单
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		roleMenuDao.delete(paramMap);
		if (menuIds != null && !"".equals(menuIds)) {
			String[] menuIdArray = menuIds.split(",");
			List<SysRoleMenu> roleMenus = new ArrayList<>();
			for (String menuId : menuIdArray) {
				roleMenus.add(new SysRoleMenu(PublicEnum.NORMAL.value(), creator, new Date(), Integer.parseInt(roleId),
						Integer.parseInt(menuId)));
			}
			// 添加角色菜单
			roleMenuDao.insert(roleMenus);
		}
	}

}
