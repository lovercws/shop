/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lovecws.shop.shiro.realm;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.shop.system.entity.SysPermission;
import com.lovecws.shop.system.entity.SysRole;
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.service.SysPermissionService;
import com.lovecws.shop.system.service.SysRoleService;
import com.lovecws.shop.system.service.SysUserService;

/**
 * @desc 自定义realm
 * @author ganliang
 * @version 2016年8月29日 上午11:11:00
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysPermissionService permissionService;
	
	/**
	 * 获取当前用户的角色集合,权限集合
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//获取保存在session中的用户信息
		SysUser user=(SysUser) SecurityUtils.getSubject().getSession().getAttribute(SysUser.SYS_USER);
		if(user==null){
			throw new IllegalArgumentException();
		}
		//获取当前用户拥有的所有角色
		List<SysRole> roles = roleService.getSysRoleByUserId(user.getUserId().toString(), PublicEnum.NORMAL.value());
		for (SysRole sysRole : roles) {
			authorizationInfo.addRole(sysRole.getRoleCode());
		}
		//获取当前用户拥有的所有权限
		List<SysPermission> permissions=permissionService.getSysPermissionByUserId(user.getUserId(), PublicEnum.NORMAL.value());
		for (SysPermission sysPermission : permissions) {
			authorizationInfo.addStringPermission(sysPermission.getPermission());
		}
		return authorizationInfo;
	}

	/**
	 * 校验登录用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String loginName = (String) token.getPrincipal();
		if (StringUtils.isEmpty(loginName)) {
			throw new UnknownAccountException();// 没找到帐号
		}
		//从数据库获取用户信息
		SysUser user=userService.getUserByUserName(loginName);
		if(user==null){
			throw new UnknownAccountException("账号不存在");
		}
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), // 登录名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getUserName()+user.getSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}
}
