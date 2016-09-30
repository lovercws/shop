package com.lovecws.shop.controller.system.ddl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
	@RequiresPermissions("system:ddl:view")
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String qddlCode,String qddlKey,String currentPage,HttpServletRequest request){
		log.info("获取数据字典列表[ddlCode="+qddlCode+",ddlKey="+qddlKey+",currentPage="+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//获取数据字典的总数量
		int totalCount=ddlService.getSysDDLCount(qddlCode,qddlKey,PublicEnum.NORMAL.value());
		//查询数据字典
		List<SysDDL> ddls=ddlService.querySysDDLByCondition(qddlCode,qddlKey,PublicEnum.NORMAL.value(),pageParam);
		//获取数据字典内码 名称 下拉框
		List<SysDDL> ddlCodeNameList=ddlService.getUniqueSysDDL(PublicEnum.NORMAL.value());
		//组装分页实体对象
		PageBean<SysDDL> pageBean=new PageBean<>(current_page, 10, totalCount, ddls);
		if(qddlCode==null){
			qddlCode="";
		}
		if(qddlKey==null){
			qddlKey="";
		}
		pageBean.setUrl(request.getContextPath()+"/system/ddl/list?qddlCode="+qddlCode+"&qddlKey="+qddlKey);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("qddlCode", qddlCode);
		request.setAttribute("qddlKey", qddlKey);
		request.setAttribute("ddlCodeNameList", ddlCodeNameList);
		return "system/ddl/list";
	}
	
	/**
	 * 进入到编辑数据字典页面
	 * @param ddlId 数据字典id
	 * @return
	 */
	@RequiresPermissions("system:ddl:edit")
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(String ddlId,String qddlCode,String qddlKey,String currentPage,HttpServletRequest request){
		log.info("编辑数据字典[ddlId="+ddlId+"]");
		SysDDL ddl=ddlService.getSysDDLById(ddlId);
		request.setAttribute("ddl", ddl);
		request.setAttribute("qddlCode", qddlCode);
		request.setAttribute("qddlKey", qddlKey);
		request.setAttribute("currentPage", currentPage);
		log.info(ddl);
		return "system/ddl/edit";
	}
	
	/**
	 * 更新数据字典
	 * @param ddlId 数据字典id
	 * @return
	 */
	@RequiresPermissions("system:ddl:edit")
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String update(SysDDL ddl,String qddlCode,String qddlKey,String currentPage,HttpServletRequest request){
		log.info("更新数据字典[ddl="+ddl+"]");
		ddl.setEditor(SecurityUtils.getSubject().getPrincipal().toString());
		ddl.setEditTime(new Date());
		ddl=ddlService.updateSysDDLById(ddl);
		return list(qddlCode, qddlKey, currentPage, request);
	}
	
	/**
	 * 进入到查看数据字典详情
	 * @param ddlId 数据字典id
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:ddl:view")
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
	@RequiresPermissions("system:ddl:add")
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
	@RequiresPermissions("system:ddl:add")
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
	@RequiresPermissions("system:ddl:delete")
	@RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
	public String delete(String ddlId,String qddlCode,String qddlKey,String currentPage,HttpServletRequest request){
		log.info("删除数据字典[ddlId="+ddlId+"]");
		//保存数据字典
		ddlService.deleteSysDDLById(ddlId);		
		return list(qddlCode, qddlKey, currentPage, request);
	}
}
