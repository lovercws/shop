package com.lovecws.shop.controller.system.log;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.page.PageBean;
import com.lovecws.common.core.page.PageParam;
import com.lovecws.common.core.utils.ValidateUtils;
import com.lovecws.shop.system.entity.SysUserLog;
import com.lovecws.shop.system.service.SysUserLogService;

@Controller
@RequestMapping("/system/log")
public class LogController {

	private static final Logger log = Logger.getLogger(LogController.class);
	@Autowired
	private SysUserLogService userLogService;

	/**
	 * 进入到日志列表
	 * @return
	 */
	@RequestMapping(value={"/list"},method=RequestMethod.GET)
	public String list(String startDate, String endDate, String currentPage,HttpServletRequest request){
		log.info("获取用户日志列表[startDate=" + startDate + ",endDate=" + endDate +",currentPage=" + currentPage + "]");
		int current_page = 1;
		if (ValidateUtils.isNumeric(currentPage)) {
			current_page = Integer.parseInt(currentPage);
		}
		PageParam pageParam = new PageParam(current_page, 10);
		// 获取数据字典的总数量
		int totalCount = userLogService.getSysUserLogCount(startDate, endDate,PublicEnum.NORMAL.value());
		// 查询数据字典
		List<SysUserLog> userLogs = userLogService.querySysUserLogByCondition(startDate, endDate,PublicEnum.NORMAL.value(), pageParam);
		// 组装分页实体对象
		PageBean<SysUserLog> pageBean = new PageBean<>(current_page, 10, totalCount, userLogs);
		if (startDate == null) {startDate = "";}
		if (endDate == null) {endDate = "";}
		pageBean.setUrl(request.getContextPath() + "/system/log/list?startDate=" + startDate + "&endDate="+ endDate);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		return "system/log/list";
	}
	
	/**
	 * 删除日志
	 * @param userLogId 日志id
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @param currentPage 分页
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/delete"},method=RequestMethod.DELETE)
	public String delete(String userLogId,String startDate, String endDate, String currentPage,HttpServletRequest request){
		userLogService.deleteSysUserLogById(userLogId);
		return list(startDate, endDate, currentPage, request);
	}
}
