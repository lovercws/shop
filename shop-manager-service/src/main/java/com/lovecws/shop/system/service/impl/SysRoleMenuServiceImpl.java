package com.lovecws.shop.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lovecws.shop.system.service.SysRoleMenuService;

@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

}
