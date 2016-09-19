package com.lovecws.shop.common.entity;

import java.io.Serializable;

/**
 * @desc 市 字典表
 * @author ganliang
 * @version 2016年8月10日 下午4:03:16
 */
public class City implements Serializable {

	private static final long serialVersionUID = 3244260830812696671L;

	private Integer cityId;// 主键id（自增）
	private String cityCode;// 市编码
	private String provinceCode;// 省编码

	private String cityName;// 市全写
	private String cityShortName;// 市的简写
	private String cityPinying;// 市的简拼

	private String cityPy;// 市的英文缩写

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityShortName() {
		return cityShortName;
	}

	public void setCityShortName(String cityShortName) {
		this.cityShortName = cityShortName;
	}

	public String getCityPinying() {
		return cityPinying;
	}

	public void setCityPinying(String cityPinying) {
		this.cityPinying = cityPinying;
	}

	public String getCityPy() {
		return cityPy;
	}

	public void setCityPy(String cityPy) {
		this.cityPy = cityPy;
	}

}