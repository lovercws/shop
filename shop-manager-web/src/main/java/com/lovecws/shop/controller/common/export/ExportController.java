package com.lovecws.shop.controller.common.export;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.excel.ExcelUtil;
import com.lovecws.shop.common.service.CommonService;
import com.lovecws.shop.system.entity.SysExportModel;
import com.lovecws.shop.system.service.SysExportModelService;

/**
 * @desc 导出控制器
 * @author ganliang
 * @version 2016年9月27日 下午12:17:36
 */
@Controller
@RequestMapping("/common/export")
public class ExportController {

	@Autowired
	private CommonService commonService;
	@Autowired
	private SysExportModelService modelService;

	/**
	 * 导出
	 * @param modelName 模型名称
	 * @param excelType excel格式
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = { "/excel/{modelName}","/excel/{modelName}/{excelType}" }, method = RequestMethod.GET)
	public void exportExcel(@PathVariable String modelName,@PathVariable String excelType, HttpServletResponse response) throws IOException {
		//默认导出xls格式excel
		if(excelType==null||"".equals(excelType)){
			excelType="XLS";
		}
		List<SysExportModel> models = modelService.querySysExportModelByCondition(modelName, PublicEnum.NORMAL.value(),null);
		// 模型不存在 直接结束
		if (models == null || models.size() == 0) {
			return;
		}
		// 获取导出数据
		SysExportModel model = models.get(0);
		List<List<Object>> exportData = commonService.getAllData(model.getModelName(), model.getEnames(), null);
		List<String> exportHeaderNames = new ArrayList<String>();
		String[] headerNames = model.getCnames().split(",");
		for (String headerName : headerNames) {
			exportHeaderNames.add(headerName);
		}
		
		response.reset();
		// 文件下载
		response.setContentType("application/vnd.ms-excel");
		String filename = "报表"+modelName+"（"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ "）";
		
		filename = new String(filename.getBytes("gbk"), "iso-8859-1");
		response.setHeader("Content-disposition", "attachment;filename="+ filename + "."+excelType.toLowerCase());
		response.setBufferSize(1024);
		
		//获取excel表单
		Workbook workbook = ExcelUtil.createWorkbook(modelName, exportHeaderNames, exportData, excelType.toUpperCase());
		//写入数据
		workbook.write(response.getOutputStream());
		workbook.close();
	}
}
