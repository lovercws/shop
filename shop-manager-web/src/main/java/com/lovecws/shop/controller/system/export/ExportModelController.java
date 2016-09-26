package com.lovecws.shop.controller.system.export;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovecws.common.core.entity.DBField;
import com.lovecws.common.core.entity.DBTable;
import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.page.PageBean;
import com.lovecws.common.core.page.PageParam;
import com.lovecws.common.core.utils.ValidateUtils;
import com.lovecws.shop.common.service.CommonService;
import com.lovecws.shop.system.entity.SysExportModel;
import com.lovecws.shop.system.service.SysExportModelService;

/**
 * @desc 导出设置
 * @author ganliang
 * @version 2016年9月11日 上午8:46:56
 */
@Controller
@RequestMapping("/system/export")
public class ExportModelController {

	private static final Logger log=Logger.getLogger(ExportModelController.class);
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private SysExportModelService modelService;
	
	/**
	 * 进入到导出设置列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String qmodelName,String currentPage,HttpServletRequest request){
		log.info("获取导出模型列表[qmodelName="+qmodelName+",currentPage="+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//菜单总数
		int totalCount=modelService.getSysExportModelCount(qmodelName,PublicEnum.NORMAL.value());
		//查询菜单列表
		List<SysExportModel> models=modelService.querySysExportModelByCondition(qmodelName,PublicEnum.NORMAL.value(),pageParam);
		//组装分页实体对象
		PageBean<SysExportModel> pageBean=new PageBean<>(current_page, 10, totalCount, models);
		if(qmodelName==null){qmodelName="";}
		pageBean.setUrl(request.getContextPath()+"/system/export/list?qmodelName="+qmodelName);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("qmodelName", qmodelName);
		
		//添加模型
		List<DBTable> newtables = commonService.getAllTable();
		List<DBTable> tables = new ArrayList<>();
		for (DBTable dbTable : newtables) {
			boolean noExists=true;
			for (SysExportModel model : models) {
				if(model.getModelName().equals(dbTable.getTableName())){
					noExists=false;
					break;
				}
			}
			if(noExists){
				tables.add(dbTable);
			}
		}
		
		List<DBField> fields =null;
		String modelName="";
		if(tables!=null&&tables.size()>0){
			modelName=tables.get(0).getTableName();
			fields = commonService.getAllField(modelName);
		}
		request.setAttribute("tables", tables);
		request.setAttribute("fields", fields);
		request.setAttribute("modelName", modelName);
		return "system/export/list";
	}
	
	/**
	 * 选择表下的字段列表
	 * @param tableName 表名
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value={"/select"},method=RequestMethod.GET)
	public List<DBField> select(String tableName,HttpServletRequest request){
		log.info("获取选择表[tableName="+tableName+"]");
		List<DBField> fields = commonService.getAllField(tableName);
		return fields;
	}
	
	/**
	 * 保存模型
	 * @param exportMode 导出模型
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.POST)
	public String save(SysExportModel exportModel,HttpServletRequest request){
		log.info("保存模型[exportModel="+exportModel+"]");
		exportModel.setCreateTime(new Date());
		exportModel.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		exportModel.setModelStatus(PublicEnum.NORMAL.value());
		modelService.addExportModel(exportModel);
		return list(null, null, request);
	}
	
	/**
	 * 删除模型
	 * @param modelId 模型Id
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
	public String delete(String modelId,String qmodelName,String currentPage,HttpServletRequest request){
		log.info("删除模型[modelId="+modelId+"]");
		modelService.deleteById(modelId);
		return list(qmodelName, currentPage, request);
	}
	 
	
}
