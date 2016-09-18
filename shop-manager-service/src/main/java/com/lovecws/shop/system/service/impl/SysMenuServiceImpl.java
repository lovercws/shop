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
import com.lovecws.shop.system.dao.SysMenuDao;
import com.lovecws.shop.system.dao.SysRoleMenuDao;
import com.lovecws.shop.system.entity.SysMenu;
import com.lovecws.shop.system.service.SysMenuService;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
@Service
public class SysMenuServiceImpl implements SysMenuService{

	@Autowired
	private SysMenuDao menuDao;
	@Autowired
	private SysRoleMenuDao roleMenuDao;
	
	@Override
	public int getSysMenuCount(String parentMenuId, String menuCode, String menuName, String menuStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("parentMenuId", parentMenuId);
		paramMap.put("menuCode", menuCode);
		paramMap.put("menuName", menuName);
		paramMap.put("menuStatus", menuStatus);
		return menuDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysMenu> querySysMenuByCondition(String parentMenuId, String menuCode, String menuName, String menuStatus,
			PageParam pageParam) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("parentMenuId", parentMenuId);
		paramMap.put("menuCode", menuCode);
		paramMap.put("menuName", menuName);
		paramMap.put("menuStatus", menuStatus);
		if(pageParam!=null){
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return menuDao.listByColumn(paramMap);
	}

	@Override
	public List<SysMenu> getTopSysMenu(String menuStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("menuStatus", menuStatus);
		return menuDao.selectList("getTopSysMenu", paramMap);
	}

	@Override
	@Transactional(readOnly=false)
	public SysMenu addMenu(SysMenu menu) {
		return menuDao.insert(menu);
	}

	@Override
	public SysMenu getSysMenuById(String menuId) {
		return menuDao.getById(menuId);
	}

	@Override
	@Transactional(readOnly=false)
	public SysMenu updateMenuById(SysMenu menu) {
		menuDao.update(menu);
		return menu;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteMenuById(String menuId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("menuId", menuId);
		//删除角色菜单
		roleMenuDao.delete(paramMap);
		//删除菜单
		menuDao.delete(menuId);
	}

	@Override
	public List<SysMenu> getSubSysMenu(String menuStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("menuStatus", menuStatus);
		return menuDao.selectList("getSubSysMenu", paramMap);
	}

	@Override
	public List<SysMenu> getSysMenuByRoleId(String roleId,String menuStatus) {
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		paramMap.put("menuStatus", menuStatus);
		return menuDao.selectList("getSysMenuByRoleId", paramMap);
	}

}
