package com.lovecws.shop.controller.system.ddl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.page.PageBean;
import com.lovecws.common.core.page.PageParam;
import com.lovecws.common.core.utils.ValidateUtils;
import com.lovecws.shop.system.entity.SysDDL;
import com.lovecws.shop.system.service.SysDDLService;

@Controller
@RequestMapping("/system/ddl")
public class DDLController {

	@Autowired
	private SysDDLService ddlService;
	private static final Logger log=Logger.getLogger(DDLController.class);
	
	/**
	 * 查询数据字典列表
	 * @param ddlCode 数据字典内码
	 * @param ddlKey 数据字典key
	 * @param currentPage 当前分页数
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String ddlCode,String ddlKey,String currentPage,HttpServletRequest request){
		log.info("获取数据字典列表[ddlCode="+ddlCode+",ddlKey="+ddlKey+",currentPage"+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//获取数据字典的总数量
		int totalCount=ddlService.getSysDDLCount(PublicEnum.NORMAL.value());
		//查询数据字典
		List<SysDDL> ddls=ddlService.querySysDDLByCondition(ddlCode,ddlKey,PublicEnum.NORMAL.value(),pageParam);
		//获取数据字典内码 名称 下拉框
		List<SysDDL> ddlCodeNameList=ddlService.getUniqueSysDDL(PublicEnum.NORMAL.value());
		//组装分页实体对象
		PageBean<SysDDL> pageBean=new PageBean<>(current_page, 10, totalCount, ddls);
		pageBean.setUrl(request.getContextPath()+"/system/ddl/list");
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("ddlCode", ddlCode);
		request.setAttribute("ddlKey", ddlKey);
		request.setAttribute("ddlCodeNameList", ddlCodeNameList);
		return "system/ddl/list";
	}
	
	/**
	 * 进入到编辑数据字典页面
	 * @param ddlId 数据字典id
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(String ddlId,HttpServletRequest request){
		log.info("编辑数据字典[ddlId="+ddlId+"]");
		SysDDL ddl=ddlService.getSysDDLById(ddlId);
		request.setAttribute("ddl", ddl);
		log.info(ddl);
		return "system/ddl/edit";
	}
	
	/**
	 * 更新数据字典
	 * @param ddlId 数据字典id
	 * @return
	 */
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String update(SysDDL ddl,HttpServletRequest request){
		log.info("更新数据字典[ddl="+ddl+"]");
		ddl.setEditor(SecurityUtils.getSubject().getPrincipal().toString());
		ddl.setEditTime(new Date());
		ddl=ddlService.updateSysDDLById(ddl);
		return list(null, null, null, request);
	}
	
	/**
	 * 进入到编辑数据字典页面
	 * @param ddlId 数据字典id
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(String ddlId,HttpServletRequest request){
		log.info("查看数据字典详情[ddlId="+ddlId+"]");
		SysDDL ddl=ddlService.getSysDDLById(ddlId);
		request.setAttribute("ddl", ddl);
		log.info(ddl);
		return "system/ddl/view";
	}
	
	/**
	 * 进入到编辑数据字典页面
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		return "system/ddl/add";
	}
	
	/**
	 * 保存数据字典
	 * @param ddl 数据字典实体对象
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String save(SysDDL ddl,HttpServletRequest request){
		log.info("保存数据字典[ddl="+ddl+"]");
		//保存数据字典
		ddl.setDdlStatus(PublicEnum.NORMAL.value());
		ddl.setCreateTime(new Date());
		ddl.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		ddlService.addSysDDL(ddl);		
		return list(null, null, null, request);
	}
	
	/**
	 * 保存数据字典
	 * @param ddl 数据字典实体对象
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/delete"},method=RequestMethod.GET)
	public String delete(String ddlId,HttpServletRequest request){
		log.info("删除数据字典[ddlId="+ddlId+"]");
		//保存数据字典
		ddlService.deleteSysDDLById(ddlId);		
		return list(null, null, null, request);
	}
}