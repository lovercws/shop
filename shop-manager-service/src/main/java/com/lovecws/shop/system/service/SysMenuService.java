package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysMenu;

public interface SysMenuService {

	/**
	 * 查询菜单数量
	 * @param parentMenuId 一级菜单id
	 * @param menuCode 菜单编码
	 * @param menuName 菜单名称
	 * @param menuStatus 菜单状态 参见PublicEnum
	 * @return
	 */
	public int getSysMenuCount(String parentMenuId, String menuCode, String menuName, String menuStatus);

	/**
	 * 查询菜单列表
	 * @param parentMenuId 一级菜单id
	 * @param menuCode 菜单编码
	 * @param menuName 菜单名称
	 * @param menuStatus 菜单状态 参见PublicEnum
	 * @param pageParam 分页实体对象
	 * @return
	 */
	public List<SysMenu> querySysMenuByCondition(String parentMenuId, String menuCode, String menuName, String value,
			PageParam pageParam);

	/**
	 * 获取顶级菜单 
	 * @param menuStatus 菜单状态 参见PublicEnum
	 * @return
	 */
	public List<SysMenu> getTopSysMenu(String menuStatus);

	/**
	 * 保存菜单
	 * @param menu 菜单实体对象
	 * @return
	 */
	public SysMenu addMenu(SysMenu menu);

	/**
	 * 获取菜单详情
	 * @param menuId 菜单id
	 * @return
	 */
	public SysMenu getSysMenuById(String menuId);

	/**
	 * 更新菜单
	 * @param menu 菜单实体对象
	 * @return
	 */
	public SysMenu updateMenuById(SysMenu menu);

	/**
	 * 删除菜单
	 * @param menuId 菜单id
	 */
	public void deleteMenuById(String menuId);

	/**
	 * 获取所有的子菜单
	 * @param menuStatus 权限状态 参见PublicEnum
	 * @return
	 */
	public List<SysMenu> getSubSysMenu(String menuStatus);

}
