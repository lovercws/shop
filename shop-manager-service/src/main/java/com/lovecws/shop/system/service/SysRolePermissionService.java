package com.lovecws.shop.system.service;

public interface SysRolePermissionService {

	/**
	 * 保存角色权限
	 * @param roleId 角色id
	 * @param permissionIds 权限id（多条以逗号隔开）
	 * @param creator 创建者
	 * @return
	 */
	public void saveRolePermission(String roleId, String permissionIds, String creator);

}
