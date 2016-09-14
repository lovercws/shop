package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysPermission;

public interface SysPermissionService {

	/**
	 * 查询权限数量
	 * @param menuId 菜单id
	 * @param permissionCode 权限内码
	 * @param permissionName 权限名称
	 * @param permissionStatus 权限状态
	 * @return
	 */
	public int getSysPermssionCount(String menuId, String permissionCode, String permissionName, String permissionStatus);

	/**
	 * 查询权限集合
	 * @param menuId 菜单id
	 * @param permissionCode 权限内码
	 * @param permissionName 权限名称
	 * @param permissionStatus 权限状态
	 * @param pageParam 分页实体对象
	 * @return
	 */
	public List<SysPermission> querySysPermissionByCondition(String menuId, String permissionCode,
			String permissionName, String permissionStatus, PageParam pageParam);

	/**
	 * 保存权限
	 * @param permission 权限实体
	 * @return
	 */
	public SysPermission addPermission(SysPermission permission);

	/**
	 * 更新权限
	 * @param permission 权限实体
	 * @return
	 */
	public SysPermission updatePermissionById(SysPermission permission);

	/**
	 * 获取权限详情
	 * @param permissionId 权限
	 * @return
	 */
	public SysPermission getSysPermissionById(String permissionId);

	/**
	 * 删除权限
	 * @param permissionId 权限id
	 */
	public void deletePermissionById(String permissionId);

	/**
	 * 根据角色获取权限列表
	 * @param roleId 角色id
	 * @param permissionStatus 权限状态
	 * @return
	 */
	public List<SysPermission> getSysPermissionByRoleId(String roleId, String permissionStatus);

}
