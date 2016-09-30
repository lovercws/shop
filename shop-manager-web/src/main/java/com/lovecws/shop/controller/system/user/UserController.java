package com.lovecws.shop.controller.system.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.common.core.page.PageBean;
import com.lovecws.common.core.page.PageParam;
import com.lovecws.common.core.utils.ValidateUtils;
import com.lovecws.shop.shiro.entity.BaseRealm;
import com.lovecws.shop.shiro.utils.PasswordHelper;
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.service.SysUserService;

@Controller
@RequestMapping("/system/user")
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private SysUserService userService;

	/**
	 * 用户列表
	 * @param quserName 用户名称
	 * @param qnickName用户昵称
	 * @param qemail用户邮件
	 * @param qphone用户手机号码
	 * @param currentPage分页数量
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:user:view")
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String list(String quserName, String qnickName, String qemail, String qphone, String currentPage,
			HttpServletRequest request) {
		log.info("获取用户列表[quserName=" + quserName + ",qnickName=" + qnickName + ",qemail=" + qemail + ",qphone=" + qphone
				+ ",currentPage=" + currentPage + "]");
		int current_page = 1;
		if (ValidateUtils.isNumeric(currentPage)) {
			current_page = Integer.parseInt(currentPage);
		}
		PageParam pageParam = new PageParam(current_page, 10);
		// 获取数据字典的总数量
		int totalCount = userService.getSysUserCount(quserName, qnickName, qemail, qphone, PublicEnum.NORMAL.value());
		// 查询数据字典
		List<SysUser> users = userService.querySysUserByCondition(quserName, qnickName, qemail, qphone,
				PublicEnum.NORMAL.value(), pageParam);
		// 组装分页实体对象
		PageBean<SysUser> pageBean = new PageBean<>(current_page, 10, totalCount, users);
		if (quserName == null) {quserName = "";}
		if (qnickName == null) {qnickName = "";}
		if (qemail == null) {qemail = "";}
		if (qphone == null) {qphone = "";}
		pageBean.setUrl(request.getContextPath() + "/system/user/list?quserName=" + quserName + "&qnickName="+ qnickName + "&qemail=" + qemail + "&qphone=" + qphone);
		log.info(pageBean);
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("quserName", quserName);
		request.setAttribute("qnickName", qnickName);
		request.setAttribute("qemail", qemail);
		request.setAttribute("qphone", qphone);
		return "system/user/list";
	}

	/**
	 * 编辑用户
	 * @param userId用户id
	 * @param quserName用户名称
	 * @param qnickName用户昵称
	 * @param qemail用户邮件
	 * @param qphone用户手机号码
	 * @param currentPage分页数量
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:user:edit")
	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String edit(String userId, String quserName, String qnickName, String qemail, String qphone,
			String currentPage, HttpServletRequest request) {
		log.info("编辑用户[userId=" + userId + "]");
		SysUser user = userService.getSysUserById(userId);
		request.setAttribute("user", user);
		request.setAttribute("quserName", quserName);
		request.setAttribute("qnickName", qnickName);
		request.setAttribute("qemail", qemail);
		request.setAttribute("qphone", qphone);
		request.setAttribute("currentPage", currentPage);
		return "system/user/edit";
	}

	/**
	 * 更新用户
	 * @param user用户实体
	 * @param quserName用户名称
	 * @param qnickName用户昵称
	 * @param qemail 用户邮件
	 * @param qphone 用户手机号码
	 * @param currentPage分页数量
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:user:edit")
	@RequestMapping(value = { "/update" }, method = RequestMethod.POST)
	public String update(SysUser user, String quserName, String qnickName, String qemail, String qphone,
			String currentPage, HttpServletRequest request) {
		log.info("更新用户[user=" + user + "]");
		user = userService.updateById(user);
		return list(quserName, qnickName, qemail, qphone, currentPage, request);
	}

	/**
	 * 查看用户详情
	 * @param userId用户id
	 * @param request
	 * @return
	 */
	@RequiresPermissions("system:user:view")
	@RequestMapping(value = { "/view" }, method = RequestMethod.GET)
	public String view(String userId, HttpServletRequest request) {
		log.info("查看用户详情[userId=" + userId + "]");
		SysUser user = userService.getSysUserById(userId);
		request.setAttribute("user", user);
		return "system/user/view";
	}

	/**
	 * 进入到编辑用户页面
	 * @return
	 */
	@RequiresPermissions("system:user:add")
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String add() {
		log.info("添加用户");
		return "system/user/add";
	}

	/**
	 * 保存用户
	 * @return
	 */
	@RequiresPermissions("system:user:add")
	@RequestMapping(value = { "/save" }, method = RequestMethod.PUT)
	public String save(SysUser user, HttpServletRequest request) {
		log.info("保存用户[user=" + user + "]");
		user.setCreateTime(new Date());
		user.setCreator(SecurityUtils.getSubject().getPrincipal().toString());
		user.setUserStatus(PublicEnum.NORMAL.value());
		// 加密密码
		BaseRealm realm = PasswordHelper.encryptPassword(new BaseRealm(user.getUserName(), user.getPassword()));
		user.setPassword(realm.getPassword());
		user.setSalt(realm.getSalt());

		user = userService.addUser(user);
		return list(null, null, null, null, null, request);
	}

	/**
	 * 删除用户
	 * @return
	 */
	@RequiresPermissions("system:user:delete")
	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	public String delete(String userId, String quserName, String qnickName, String qemail, String qphone,
			String currentPage, HttpServletRequest request) {
		log.info("删除用户[userId=" + userId + "]");
		userService.deleteById(userId);
		return list(quserName, qnickName, qemail, qphone, currentPage, request);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
