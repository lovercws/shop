package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysUserLog;

public interface SysUserLogService {

	/**
	 * 保存日志
	 * @param sysUserLog 系统日志
	 */
	public void addSysUserLog(SysUserLog sysUserLog);

	/**
	 * 获取用户日志数量
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param userLogStatus 日志状态
	 * @return
	 */
	public int getSysUserLogCount(String startDate, String endDate, String userLogStatus);

	/**
	 * 查询用户日志
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param userLogStatus 日志状态 
	 * @param pageParam 分页实体
	 * @return
	 */
	public List<SysUserLog> querySysUserLogByCondition(String startDate, String endDate, String userLogStatus,
			PageParam pageParam);

	/**
	 * 删除用户操作日志
	 * @param userLogId 日志id
	 */
	public void deleteSysUserLogById(String userLogId);

}
