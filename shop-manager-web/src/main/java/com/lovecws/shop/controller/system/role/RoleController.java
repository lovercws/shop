package com.lovecws.shop.controller.system.role;

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
import com.lovecws.shop.system.entity.SysRole;
import com.lovecws.shop.system.service.SysRoleService;

@Controller
@RequestMapping("/system/role")
public class RoleController {
	private static final Logger log=Logger.getLogger(RoleController.class);
	
	@Autowired
	private SysRoleService roleService;
	
	/**
	 * 查询角色
	 * @param qroleCode 角色内码
	 * @param qroleName 角色名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String qroleCode,String qroleName,String currentPage,HttpServletRequest request) {
		log.info("获取角色列表[qroleCode="+qroleCode+",qroleName="+qroleName+",currentPage="+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//角色总数
		int totalCount=roleService.getSysRoleCount(qroleCode,qroleName,PublicEnum.NORMAL.value());
		//查询角色列表
		List<SysRole> roles=roleService.querySysRoleByCondition(qroleCode,qroleName,PublicEnum.NORMAL.value(),pageParam);
		//组装分页实体对象
		PageBean<SysRole> pageBean=new PageBean<>(current_page, 10, totalCount, roles);
		if(qroleCode==null){qroleCode="";}
		if(qroleName==null){qroleName="";}
		pageBean.setUrl(request.getContextPath()+"/system/role/list?qroleCode="+qroleCode+"&qroleName="+qroleName);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("qroleCode", qroleCode);
		request.setAttribute("qroleName", qroleName);
		return "system/role/list";
	}
	
	/**
	 * 编辑角色
	 * @param roleId 角色id
	 * @param qroleCode 角色内码
	 * @param qroleName 角色名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(String roleId,String qroleCode,String qroleName,String currentPage,HttpServletRequest request){
		log.info("编辑角色[roleId="+roleId+"]");
		SysRole role=roleService.getSysRoleById(roleId);
		request.setAttribute("role", role);
		request.setAttribute("qroleCode", qroleCode);
		request.setAttribute("qroleName", qroleName);
		request.setAttribute("currentPage", currentPage);
		return "system/role/edit";
	}
	
	/**
	 * 更新角色
	 * @param role 角色实体
	 * @param qroleCode 角色内码
	 * @param qroleName 角色名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String update(SysRole role,String qroleCode,String qroleName,String currentPage,HttpServletRequest request){
		log.info("更新角色[role="+role+"]");
		role.setEditor(SecurityUtils.getSubject().getPrincipal().toString());
		role.setEditTime(new Date());
		role=roleService.updateSysRoleById(role);
		return list(qroleCode, qroleName, currentPage, request);
	}
	
	/**
	 * 查看角色详情
	 * @param roleId 角色id
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(String roleId,HttpServletRequest request){
		log.info("查看角色详情[roleId="+roleId+"]");
		SysRole role=roleService.getSysRoleById(roleId);
		request.setAttribute("role", role);
		return "system/role/view";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(){
		log.info("添加角色");
		return "system/role/add";
	}
	
	/**
	 * 保存角色
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String save(SysRole role,HttpServletRequest request){
		log.info("保存角色[role="+role+"]");
		role.setCreateTime(new Date());
		role.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		role.setRoleStatus(PublicEnum.NORMAL.value());
		role=roleService.addSysRole(role);
		return list(null, null, null, request);
	}
	
	/**
	 * 删除角色
	 * @param roleId 角色id
	 * @param qroleCode 角色内码
	 * @param qroleName 角色名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
	public String delete(String roleId,String qroleCode,String qroleName,String currentPage,HttpServletRequest request){
		roleService.deleteById(roleId);
		return list(qroleCode, qroleName, currentPage, request);
	}
	
}
