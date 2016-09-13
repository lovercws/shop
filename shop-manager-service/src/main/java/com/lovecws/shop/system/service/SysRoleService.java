package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysRole;

public interface SysRoleService {

	/**
	 * 查询角色数量
	 * @param roleCode 角色内码
	 * @param roleName 角色名称
	 * @param roleStatus 角色状态
	 * @return
	 */
	public int getSysRoleCount(String roleCode, String roleName, String roleStatus);

	/**
	 * 查询角色列表
	 * @param roleCode 角色内码
	 * @param roleName 角色名称
	 * @param roleStatus 角色状态
	 * @param pageParam 分页实体对象
	 * @return
	 */
	public List<SysRole> querySysRoleByCondition(String roleCode, String roleName, String roleStatus,
			PageParam pageParam);

	/**
	 * 添加角色
	 * @param role 角色实体对象
	 * @return
	 */
	public SysRole addSysRole(SysRole role);

	/**
	 * 获取角色详情
	 * @param roleId 角色id
	 * @return
	 */
	public SysRole getSysRoleById(String roleId);

	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public SysRole updateSysRoleById(SysRole role);

	/**
	 * 删除角色
	 * @param roleId
	 */
	public void deleteById(String roleId);

}
