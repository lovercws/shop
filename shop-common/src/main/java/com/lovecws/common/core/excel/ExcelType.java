package com.lovecws.common.core.excel;

public enum ExcelType {

	/**
	 * xls 格式excel
	 */
	XLS("application/vnd.ms-excel"),

	/**
	 * xls 格式excel
	 */
	XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

	public String type;

	private ExcelType(String type) {
		this.type = type;
	}
	
	public String value(){
		return type;
	}

}
