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
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.service.SysUserService;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao userDao;

	@Override
	public int getSysUserCount(String quserName, String qnickName, String qemail, String qphone, String userStatus) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("quserName", quserName);
		paramMap.put("qnickName", qnickName);
		paramMap.put("qemail", qemail);
		paramMap.put("qphone", qphone);
		paramMap.put("userStatus", userStatus);
		return userDao.getCountByColumn(paramMap).intValue();
	}

	@Override
	public List<SysUser> querySysUserByCondition(String quserName, String qnickName, String qemail, String qphone,
			String userStatus, PageParam pageParam) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("quserName", quserName);
		paramMap.put("qnickName", qnickName);
		paramMap.put("qemail", qemail);
		paramMap.put("qphone", qphone);
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

	@Override
	public SysUser updateById(SysUser user) {
		userDao.update(user);
		return user;
	}

	@Override
	public SysUser addUser(SysUser user) {
		userDao.insert(user);
		return null;
	}

	@Override
	public void deleteById(String userId) {
		userDao.delete(userId);
	}

}
