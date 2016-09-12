package com.lovecws.shop.controller.system.permission;

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
import com.lovecws.shop.system.entity.SysMenu;
import com.lovecws.shop.system.entity.SysPermission;
import com.lovecws.shop.system.service.SysMenuService;
import com.lovecws.shop.system.service.SysPermissionService;

@Controller
@RequestMapping("/system/permission")
public class PermissionController {

	private static final Logger log=Logger.getLogger(PermissionController.class);
	
	@Autowired
	private SysPermissionService permissionService;
	@Autowired
	private SysMenuService menuService;
	
	/**
	 * 显示权限列表
	 * @param qmenuId 查询 菜单id
	 * @param qpermissionCode 查询权限内码
	 * @param qpermissionName 查询权限名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String qmenuId,String qpermissionCode,String qpermissionName,String currentPage,HttpServletRequest request){
		log.info("获取权限列表[menuId="+qmenuId+",permissionCode="+qpermissionCode+"permissionName="+qpermissionName+",currentPage="+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//权限总数
		int totalCount=permissionService.getSysPermssionCount(qmenuId,qpermissionCode,qpermissionName,PublicEnum.NORMAL.value());
		//查询权限列表
		List<SysPermission> permissions=permissionService.querySysPermissionByCondition(qmenuId,qpermissionCode,qpermissionName,PublicEnum.NORMAL.value(),pageParam);
		//子菜单
		List<SysMenu> subMenus=menuService.getSubSysMenu(PublicEnum.NORMAL.value());
		//组装分页实体对象
		PageBean<SysPermission> pageBean=new PageBean<>(current_page, 10, totalCount, permissions);
		if(qmenuId==null){qmenuId="";}
		if(qpermissionCode==null){qpermissionCode="";}
		if(qpermissionName==null){qpermissionName="";}
		pageBean.setUrl(request.getContextPath()+"/system/permission/list?qmenuId="+qmenuId+"&qpermissionCode="+qpermissionCode+"&qpermissionName="+qpermissionName);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("qmenuId", qmenuId);
		request.setAttribute("qpermissionCode", qpermissionCode);
		request.setAttribute("qpermissionName", qpermissionName);
		request.setAttribute("subMenus", subMenus);
		return "system/permission/list";
	}
	
	/**
	 * 编辑权限页面
	 * @param permissionId
	 * @param qmenuId 查询 菜单id
	 * @param qpermissionCode 查询权限内码
	 * @param qpermissionName 查询权限名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(String permissionId,String qmenuId,String qpermissionCode,String qpermissionName,String currentPage,HttpServletRequest request){
		log.info("进入到编辑权限页面[permissionId="+permissionId+",menuId="+qmenuId+",permissionCode="+qpermissionCode+"permissionName="+qpermissionName+",currentPage="+currentPage+"]");
		//子菜单
		List<SysMenu> subMenus=menuService.getSubSysMenu(PublicEnum.NORMAL.value());
		//获取订单详情
		SysPermission permission=permissionService.getSysPermissionById(permissionId);
		request.setAttribute("qmenuId", qmenuId);
		request.setAttribute("qpermissionCode", qpermissionCode);
		request.setAttribute("qpermissionName", qpermissionName);
		request.setAttribute("subMenus", subMenus);
		request.setAttribute("permission", permission);
		return "system/permission/edit";
	}
	
	/**
	 * 更新权限
	 * @param permission 权限实体
	 * @param qmenuId 查询 菜单id
	 * @param qpermissionCode 查询权限内码
	 * @param qpermissionName 查询权限名称
	 * @param currentPage 当前分页数
	 * @return
	 */
	
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String update(SysPermission permission,String qmenuId,String qpermissionCode,String qpermissionName,String currentPage,HttpServletRequest request){
		log.info("更新权限[permission="+permission+"]");
		permission.setEditor(SecurityUtils.getSubject().getPrincipal().toString());
		permission.setEditTime(new Date());
		permission=permissionService.updatePermissionById(permission);
		return list(qmenuId, qpermissionCode, qpermissionName, currentPage, request);
	}
	
	/**
	 * 查看权限详情
	 * @param permissionId 权限id
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(String permissionId,HttpServletRequest request){
		log.info("查看权限详情[permissionId="+permissionId+"]");
		//子菜单
		List<SysMenu> subMenus=menuService.getSubSysMenu(PublicEnum.NORMAL.value());
		//获取订单详情
		SysPermission permission=permissionService.getSysPermissionById(permissionId);
		request.setAttribute("subMenus", subMenus);
		request.setAttribute("permission", permission);
		return "system/permission/view";
	}
	
	/**
	 * 添加权限页面
	 * @param permissionId 权限id
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(String permissionId,HttpServletRequest request){
		log.info("添加权限页面[permissionId="+permissionId+"]");
		//子菜单
		List<SysMenu> subMenus=menuService.getSubSysMenu(PublicEnum.NORMAL.value());
		//获取订单详情
		SysPermission permission=permissionService.getSysPermissionById(permissionId);
		request.setAttribute("subMenus", subMenus);
		request.setAttribute("permission", permission);
		return "system/permission/add";
	}
	
	/**
	 * 保存权限
	 * @return
	 */
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String save(SysPermission permission,HttpServletRequest request){
		log.info("保存权限[permission="+permission+"]");
		permission.setCreateTime(new Date());
		permission.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		permission.setPermissionStatus(PublicEnum.NORMAL.value());
		permission=permissionService.addPermission(permission);
		return list(null, null, null, null, request);
	}
	
	/**
	 * 删除权限
	 * @param permissionId 权限id
	 * @param qmenuId 查询 菜单id
	 * @param qpermissionCode 查询权限内码
	 * @param qpermissionName 查询权限名称
	 * @param currentPage 当前分页数
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/delete"},method=RequestMethod.GET)
	public String delete(String permissionId,String qmenuId,String qpermissionCode,String qpermissionName,String currentPage,HttpServletRequest request){
		log.info("删除权限[permission="+permissionId+"]");
		permissionService.deletePermissionById(permissionId);
		return list(qmenuId, qpermissionCode, qpermissionName, currentPage, request);
	}
}
