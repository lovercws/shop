package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysDDL;

public interface SysDDLService {

	/**
	 * 获取分页数量
	 * @param ddlCode 数据字典内码
	 * @param ddlKey 数据字典key
	 * @param ddlStatus 数据字典状态
	 * @return
	 */
	public int getSysDDLCount(String ddlCode, String ddlKey,String ddlStatus);

	/**
	 * 分页查询数据字典
	 * @param ddlCode 数据字典内码
	 * @param ddlKey 数据字典key
	 * @param ddlStatus 数据字典状态
	 * @param pageParam 分页实体
	 * @return
	 */
	public List<SysDDL> querySysDDLByCondition(String ddlCode, String ddlKey, String ddlStatus, PageParam pageParam);

	/**
	 * 添加数据字典记录
	 * @param ddl
	 * @return
	 */
	public SysDDL addSysDDL(SysDDL ddl);

	/**
	 * 获取
	 * @param ddlStatus 数据字典状态
	 * @return
	 */
	public List<SysDDL> getUniqueSysDDL(String ddlStatus);

	/**
	 * 获取数据字典详情
	 * @param ddlId 数据字典id
	 * @return
	 */
	public SysDDL getSysDDLById(String ddlId);

	/**
	 * 更新数据字典
	 * @param ddl 数据字典实体
	 * @return
	 */
	public SysDDL updateSysDDLById(SysDDL ddl);

	/**
	 * 删除数据字典
	 * @param ddlId 数据字典id
	 */
	public void deleteSysDDLById(String ddlId);

}
