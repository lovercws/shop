package com.lovecws.shop.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 导出字段
 * @author ganliang
 * @version 2016年9月11日 上午11:56:20
 */
public class SysExportModel implements Serializable {

	private static final long serialVersionUID = -8380744250447813866L;

	private Integer modelId;// 主键ID.
	private String modelStatus;// 状态 PublicStatusEnum
	private String creator;// 创建人.
	private Date createTime;// 创建时间.

	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	private String moduleName; // 所属模块，如用户管理为：system-user
	private String ecnames; // 导出字段的中文名
	private String enames; // 导出字段的英文名

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelStatus() {
		return modelStatus;
	}

	public void setModelStatus(String modelStatus) {
		this.modelStatus = modelStatus;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getEcnames() {
		return ecnames;
	}

	public void setEcnames(String ecnames) {
		this.ecnames = ecnames;
	}

	public String getEnames() {
		return enames;
	}

	public void setEnames(String enames) {
		this.enames = enames;
	}

}
