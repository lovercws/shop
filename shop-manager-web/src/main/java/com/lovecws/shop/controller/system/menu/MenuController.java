package com.lovecws.shop.controller.system.menu;

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
import com.lovecws.shop.system.entity.SysMenu;
import com.lovecws.shop.system.service.SysMenuService;

@Controller
@RequestMapping("/system/menu")
public class MenuController {

	private static final Logger log=Logger.getLogger(MenuController.class);
	
	@Autowired
	private SysMenuService menuService;
	
	/**
	 * 显示菜单列表
	 * @return
	 */
	@RequiresPermissions("system:menu:view")
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String qparentMenuId,String qmenuCode,String qmenuName,String currentPage,HttpServletRequest request){
		log.info("获取菜单列表[parentMenuId="+qparentMenuId+",menuCode="+qmenuCode+"menuName="+qmenuName+",currentPage="+currentPage+"]");
		int current_page=1;
		if(ValidateUtils.isNumeric(currentPage)){
			current_page=Integer.parseInt(currentPage);
		}
		PageParam pageParam=new PageParam(current_page,10);
		//菜单总数
		int totalCount=menuService.getSysMenuCount(qparentMenuId,qmenuCode,qmenuName,PublicEnum.NORMAL.value());
		//查询菜单列表
		List<SysMenu> menus=menuService.querySysMenuByCondition(qparentMenuId,qmenuCode,qmenuName,PublicEnum.NORMAL.value(),pageParam);
		//一级菜单（顶级菜单）
		List<SysMenu> topMenus=menuService.getTopSysMenu(PublicEnum.NORMAL.value());
		//组装分页实体对象
		PageBean<SysMenu> pageBean=new PageBean<>(current_page, 10, totalCount, menus);
		if(qparentMenuId==null){qparentMenuId="";}
		if(qmenuCode==null){qmenuCode="";}
		if(qmenuName==null){qmenuName="";}
		pageBean.setUrl(request.getContextPath()+"/system/menu/list?qparentMenuId="+qparentMenuId+"&qmenuCode="+qmenuCode+"&qmenuName="+qmenuName);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("qparentMenuId", qparentMenuId);
		request.setAttribute("qmenuCode", qmenuCode);
		request.setAttribute("qmenuName", qmenuName);
		request.setAttribute("topMenus", topMenus);
		return "system/menu/list";
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @param menuId 菜单id
	 * @param qparentMenuId 父菜单id
	 * @param qmenuCode 菜单内码
	 * @param qmenuName 菜单名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:edit")
	@RequestMapping(value={"/edit"},method=RequestMethod.GET)
	public String edit(String menuId,String qparentMenuId,String qmenuCode,String qmenuName,String currentPage,HttpServletRequest request){
		log.info("进入到编辑菜单页面");
		//获取菜单详情
		SysMenu menu=menuService.getSysMenuById(menuId);
		//一级菜单（顶级菜单）
		List<SysMenu> topMenus=menuService.getTopSysMenu(PublicEnum.NORMAL.value());
		request.setAttribute("topMenus", topMenus);
		request.setAttribute("menu", menu);
		request.setAttribute("qparentMenuId", qparentMenuId);
		request.setAttribute("qmenuCode", qmenuCode);
		request.setAttribute("qmenuName", qmenuName);
		return "system/menu/edit";
	}
	
	
	/**
	 * 进入到编辑菜单页面
	 * @param menuId 菜单id
	 * @param qparentMenuId 父菜单id
	 * @param qmenuCode 菜单内码
	 * @param qmenuName 菜单名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:edit")
	@RequestMapping(value={"/update"},method=RequestMethod.POST)
	public String update(SysMenu menu,String qparentMenuId,String qmenuCode,String qmenuName,String currentPage,HttpServletRequest request){
		log.info("更新菜单[menu="+menu+"]");
		//更新菜单
		menu.setEditor(SecurityUtils.getSubject().getPrincipal().toString());
		menu.setEditTime(new Date());
		menu=menuService.updateMenuById(menu);
		return list(qparentMenuId, qmenuCode, qmenuName, currentPage, request);
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @param menuId 菜单id
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:view")
	@RequestMapping(value={"/view"},method=RequestMethod.GET)
	public String view(String menuId,HttpServletRequest request){
		log.info("进入到查看菜单页面");
		//获取菜单详情
		SysMenu menu=menuService.getSysMenuById(menuId);
		//一级菜单（顶级菜单）
		List<SysMenu> topMenus=menuService.getTopSysMenu(PublicEnum.NORMAL.value());
		request.setAttribute("topMenus", topMenus);
		request.setAttribute("menu", menu);
		return "system/menu/view";
	}
	
	/**
	 * 进入到编辑菜单页面
	 * @return
	 */
	@RequiresPermissions("system:menu:add")
	@RequestMapping(value={"/add"},method=RequestMethod.GET)
	public String add(HttpServletRequest request){
		log.info("进入到添加菜单页面");
		//一级菜单（顶级菜单）
		List<SysMenu> topMenus=menuService.getTopSysMenu(PublicEnum.NORMAL.value());
		request.setAttribute("topMenus", topMenus);
		return "system/menu/add";
	}
	
	/**
	 * 保存菜单
	 * @param menu 菜单
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:add")
	@RequestMapping(value={"/save"},method=RequestMethod.PUT)
	public String save(SysMenu menu,HttpServletRequest request){
		log.info("保存菜单[menu="+menu+"]");
		menu.setCreateTime(new Date());
		menu.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		Integer parentMenuId = menu.getParentMenuId();
		if(parentMenuId!=0){
			menu.setLeaf(true);
			menu.setLevel(2);
		}else{
			menu.setLevel(1);
		}
		menu.setMenuStatus(PublicEnum.NORMAL.value());
		menu=menuService.addMenu(menu);
		return list(null, null, null, null, request);
	}
	
	/**
	 * 删除菜单
	 * @param menuId 菜单id
	 * @param qparentMenuId 父菜单id
	 * @param qmenuCode 菜单内码
	 * @param qmenuName 菜单名称
	 * @param currentPage 当前分页
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:delete")
	@RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
	public String delete(String menuId,String qparentMenuId,String qmenuCode,String qmenuName,String currentPage,HttpServletRequest request){
		log.info("删除菜单[menuId="+menuId+"]");
		menuService.deleteMenuById(menuId);
		return list(qparentMenuId, qmenuCode, qmenuName, currentPage, request);
	}
	
	/**
	 * 获取菜单子节点
	 * @param parentMenuId
	 * @param currentPage
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:menu:leaf")
	@RequestMapping(value={"/leaf"},method=RequestMethod.GET)
	public String leaf(String parentMenuId,HttpServletRequest request){
		log.info("获取菜单列表[parentMenuId="+parentMenuId+"]");
		//查询菜单列表
		List<SysMenu> subMenus=menuService.querySysMenuByCondition(parentMenuId,null,null,PublicEnum.NORMAL.value(),null);
		PageBean<SysMenu> pageBean=new PageBean<>(subMenus);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		return "system/menu/leaf";
	}
}
