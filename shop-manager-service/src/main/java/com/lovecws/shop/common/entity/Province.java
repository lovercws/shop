package com.lovecws.shop.common.entity;

import java.io.Serializable;

/**
 * @desc 省 字典表
 * @author ganliang
 * @version 2016年8月10日 下午4:03:08
 */
public class Province implements Serializable {

	private static final long serialVersionUID = -2776663207235951472L;

	private Integer provinceId;// 主键id（自增）
	private String provinceCode;// 省编码
	private String provinceName;// 省全写

	private String provinceShortName;// 省的简写
	private String provincePinying;// 省的简拼
	private String provincePy;// 省的英文缩写

	private String provinceAbb;// 省的简称

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceShortName() {
		return provinceShortName;
	}

	public void setProvinceShortName(String provinceShortName) {
		this.provinceShortName = provinceShortName;
	}

	public String getProvincePinying() {
		return provincePinying;
	}

	public void setProvincePinying(String provincePinying) {
		this.provincePinying = provincePinying;
	}

	public String getProvincePy() {
		return provincePy;
	}

	public void setProvincePy(String provincePy) {
		this.provincePy = provincePy;
	}

	public String getProvinceAbb() {
		return provinceAbb;
	}

	public void setProvinceAbb(String provinceAbb) {
		this.provinceAbb = provinceAbb;
	}

}