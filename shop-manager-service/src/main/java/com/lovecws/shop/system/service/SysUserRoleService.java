package com.lovecws.shop.system.service;

public interface SysUserRoleService {

	/**
	 * 添加用户角色
	 * @param userId 用户id
	 * @param roleIds 角色id
	 * @param creator 创建者
	 */
	public void saveUserRole(String userId, String roleIds, String creator);

}
