package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysUser;

public interface SysUserService {

	/**
	 * 查询用户
	 * @param quserName 用户名称
	 * @param qnickName 用户昵称 
	 * @param qemail 用户邮件
	 * @param qphone 用户手机号码
	 * @param userStatus 用户状态
	 * @param pageParam 分页实体
	 * @return
	 */
	public List<SysUser> querySysUserByCondition(String quserName, String qnickName, String qemail, String qphone,
			String userStatus, PageParam pageParam);

	/**
	 * 查询用户数量
	 * @param quserName 用户名称
	 * @param qnickName 用户昵称 
	 * @param qemail 用户邮件
	 * @param qphone 用户手机号码
	 * @param userStatus 用户状态
	 * @return
	 */
	public int getSysUserCount(String quserName, String qnickName, String qemail, String qphone, String userStatus);

	/**
	 * 获取用户详情
	 * @param userId 用户id
	 * @return
	 */
	public SysUser getSysUserById(String userId);

	/**
	 * 更新用户
	 * @param user 用户实体
	 * @return
	 */
	public SysUser updateById(SysUser user);

	/**
	 * 添加用户
	 * @param user 用户实体
	 * @return
	 */
	public SysUser addUser(SysUser user);

	/**
	 * 删除用户
	 * @param userId 用户id
	 */
	public void deleteById(String userId);

	/**
	 * 根据登录名称获取用户信息
	 * @param loginName 用户名称
	 * @return
	 */
	public SysUser getUserByUserName(String loginName);

}
