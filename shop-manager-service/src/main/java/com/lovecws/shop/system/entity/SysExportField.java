package com.lovecws.shop.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 导出字段
 * @author ganliang
 * @version 2016年9月11日 上午11:56:20
 */
public class SysExportField implements Serializable {

	private static final long serialVersionUID = -8380744250447813866L;

	private Integer expId;// 主键ID.
	private String expStatus;// 状态 PublicStatusEnum
	private String creator;// 创建人.
	private Date createTime = new Date();// 创建时间.

	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	private String moduleName; // 所属模块，如用户管理为：system-user
	private String expCNames; // 导出字段的中文名
	private String noExpCNames; // 未导出字段的中文名

	private String expENames; // 导出字段的英文名
	private String noExpENames; // 未导出字段的英文名

	public Integer getExpId() {
		return expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	public String getExpStatus() {
		return expStatus;
	}

	public void setExpStatus(String expStatus) {
		this.expStatus = expStatus;
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

	public String getExpCNames() {
		return expCNames;
	}

	public void setExpCNames(String expCNames) {
		this.expCNames = expCNames;
	}

	public String getNoExpCNames() {
		return noExpCNames;
	}

	public void setNoExpCNames(String noExpCNames) {
		this.noExpCNames = noExpCNames;
	}

	public String getExpENames() {
		return expENames;
	}

	public void setExpENames(String expENames) {
		this.expENames = expENames;
	}

	public String getNoExpENames() {
		return noExpENames;
	}

	public void setNoExpENames(String noExpENames) {
		this.noExpENames = noExpENames;
	}

}
