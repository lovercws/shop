package com.lovecws.shop.system.service;

import java.util.List;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.entity.SysExportModel;

public interface SysExportModelService {

	/**
	 * 查询模型数量
	 * @param qmodelName 模型名称
	 * @param exportModelStatus 模型状态
	 * @return
	 */
	public int getSysExportModelCount(String qmodelName, String exportModelStatus);

	/**
	 * 查询模型集合
	 * @param qmodelName 模型名称
	 * @param exportModelStatus 模型状态
	 * @param pageParam 分页实体
	 * @return
	 */
	public List<SysExportModel> querySysExportModelByCondition(String qmodelName, String exportModelStatus, PageParam pageParam);

	/**
	 * 删除模型
	 * @param modelId 模型id
	 */
	public void deleteById(String modelId);

	/**
	 * 添加模型
	 * @param exportModel 模型实体
	 */
	public void addExportModel(SysExportModel exportModel);

	/**
	 * 获取模型
	 * @param modelId 模型id
	 * @return
	 */
	public SysExportModel getSysExportModelById(String modelId);

	/**
	 * 更新模型
	 * @param exportModel 模型实体
	 */
	public void updateSysExportModel(SysExportModel exportModel);

}
