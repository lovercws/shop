package com.lovecws.shop.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 数据字典
 * @author ganliang
 * @version 2016年9月11日 上午11:56:20
 */
public class SysDDL implements Serializable {

	private static final long serialVersionUID = -8380744250447813866L;

	private Integer ddlId;// 主键ID.
	private String ddlStatus;// 状态 PublicStatusEnum
	private String creator;// 创建人.
	private Date createTime;// 创建时间.

	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	private String ddlCode;// 数据字典内码
	private String ddlName;// 数据字典名称
	private String ddlKey;// 数据字典key
	private String ddlValue;// 数据字典值
	private String ddlNumber;// 数据字典排序

	public Integer getDdlId() {
		return ddlId;
	}

	public void setDdlId(Integer ddlId) {
		this.ddlId = ddlId;
	}

	public String getDdlStatus() {
		return ddlStatus;
	}

	public void setDdlStatus(String ddlStatus) {
		this.ddlStatus = ddlStatus;
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

	public String getDdlCode() {
		return ddlCode;
	}

	public void setDdlCode(String ddlCode) {
		this.ddlCode = ddlCode;
	}

	public String getDdlName() {
		return ddlName;
	}

	public void setDdlName(String ddlName) {
		this.ddlName = ddlName;
	}

	public String getDdlKey() {
		return ddlKey;
	}

	public void setDdlKey(String ddlKey) {
		this.ddlKey = ddlKey;
	}

	public String getDdlValue() {
		return ddlValue;
	}

	public void setDdlValue(String ddlValue) {
		this.ddlValue = ddlValue;
	}

	public String getDdlNumber() {
		return ddlNumber;
	}

	public void setDdlNumber(String ddlNumber) {
		this.ddlNumber = ddlNumber;
	}

	@Override
	public String toString() {
		return "SysDDL [ddlId=" + ddlId + ", ddlStatus=" + ddlStatus + ", creator=" + creator + ", createTime="
				+ createTime + ", editor=" + editor + ", editTime=" + editTime + ", remark=" + remark + ", ddlCode="
				+ ddlCode + ", ddlName=" + ddlName + ", ddlKey=" + ddlKey + ", ddlValue=" + ddlValue + ", ddlNumber="
				+ ddlNumber + "]";
	}

}
