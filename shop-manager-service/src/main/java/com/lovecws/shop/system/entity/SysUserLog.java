package com.lovecws.shop.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 用户日志实体
 * @author ganliang
 * @version 2016年9月10日 下午10:09:39
 */
public class SysUserLog implements Serializable {

	private static final long serialVersionUID = 742891253537618199L;

	private Integer logId;// 主键ID.
	private String logStatus;// 状态 PublicStatusEnum
	private String creator;// 创建人.
	private Date createTime = new Date();// 创建时间.

	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	private Integer userId; // 用户ID
	private String userName; // 用户名
	private String operateType; // 操作类型（参与枚举:OperatorLogTypeEnum,1:增加,2:修改,3:删除,4:查询,5:登录）
	private String ip; // IP地址
	private String content; // 操作内容

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SysUserLog [logId=" + logId + ", logStatus=" + logStatus + ", creator=" + creator + ", createTime="
				+ createTime + ", editor=" + editor + ", editTime=" + editTime + ", remark=" + remark + ", userId="
				+ userId + ", userName=" + userName + ", operateType=" + operateType + ", ip=" + ip + ", content="
				+ content + "]";
	}

}
