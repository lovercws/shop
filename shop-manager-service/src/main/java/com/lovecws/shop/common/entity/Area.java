package com.lovecws.shop.common.entity;

import java.io.Serializable;

/**
 * @desc 区域字典表
 * @author ganliang
 * @version 2016年8月10日 下午4:03:39
 */
public class Area implements Serializable {

	private static final long serialVersionUID = -4246961384691633199L;

	private Integer areaId;// 主键id（自增）
	private String areaCode;// 区编码
	private String cityCode;// 市编码

	private String areaName;// 区全写
	private String areaShortName;// 区的简写
	private String areaPinying;// 区的简拼

	private String areaPy;// 区的英文缩写

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaShortName() {
		return areaShortName;
	}

	public void setAreaShortName(String areaShortName) {
		this.areaShortName = areaShortName;
	}

	public String getAreaPinying() {
		return areaPinying;
	}

	public void setAreaPinying(String areaPinying) {
		this.areaPinying = areaPinying;
	}

	public String getAreaPy() {
		return areaPy;
	}

	public void setAreaPy(String areaPy) {
		this.areaPy = areaPy;
	}

}