package com.lovecws.shop.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.common.core.page.PageParam;
import com.lovecws.shop.system.dao.SysUserDao;
import com.lovecws.shop.system.dao.SysUserRoleDao;
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.service.SysUserService;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao userDao;
	
	@Autowired
	private SysUserRoleDao userRoleDao;

	@Override
	public int getSysUserCount(String quserName, String qnickName, String qemail, String qphone, String userStatus) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", quserName);
		paramMap.put("nickName", qnickName);
		paramMap.put("email", qemail);
		paramMap.put("phone", qphone);
		paramMap.put("userStatus", userStatus);
		return userDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysUser> querySysUserByCondition(String quserName, String qnickName, String qemail, String qphone,
			String userStatus, PageParam pageParam) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", quserName);
		paramMap.put("nickName", qnickName);
		paramMap.put("email", qemail);
		paramMap.put("phone", qphone);
		paramMap.put("userStatus", userStatus);
		if (pageParam != null) {
			paramMap.put("beginIndex", pageParam.getBeginIndex());
			paramMap.put("numPerPage", pageParam.getNumPerPage());
		}
		return userDao.listByColumn(paramMap);
	}

	@Override
	public SysUser getSysUserById(String userId) {
		return userDao.getById(userId);
	}

	@Transactional(readOnly = false)
	@Override
	public SysUser updateById(SysUser user) {
		userDao.update(user);
		return user;
	}

	@Transactional(readOnly = false)
	@Override
	public SysUser addUser(SysUser user) {
		userDao.insert(user);
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteById(String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		//删除用户角色中间表数据
		userRoleDao.delete(paramMap);
		
		//删除用户表数据
		userDao.delete(userId);
	}

	@Override
	public SysUser getUserByUserName(String loginName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", loginName);
		return userDao.getBy(paramMap);
	}

}
