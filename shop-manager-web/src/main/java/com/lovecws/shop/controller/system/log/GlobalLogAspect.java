package com.lovecws.shop.controller.system.log;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lovecws.common.core.enums.PublicEnum;
import com.lovecws.shop.system.entity.SysUser;
import com.lovecws.shop.system.entity.SysUserLog;
import com.lovecws.shop.system.service.SysUserLogService;

/**
 * @desc 全局日志记录
 * @author ganliang
 * @version 2016年8月12日 下午3:17:24
 */
@Component
@Aspect
public class GlobalLogAspect {

	private static final Logger log = Logger.getLogger(GlobalLogAspect.class);
	// gson
	private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	@Autowired
	private SysUserLogService logService;
	
	
	/**
	 * 全局controller 切面
	 */
	@Pointcut("execution(* com.lovecws.shop.controller.*.*.*Controller.*(..))")
	public void globalPointcut() {
	}

	@Around("globalPointcut()")
	public Object globalAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		String method=signature.getDeclaringTypeName() + " " + signature.getName();
		log.info("method---" + method);
		
		String parameter=StringUtils.join(joinPoint.getArgs());
		log.info("parameter---" + parameter);
		
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		String result=gson.toJson(proceed);
		log.info("result----" + result);
		long end = System.currentTimeMillis();
		
		String usetime=(end - start) + "ms";
		log.info("usetime ----" + usetime);
		
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SysUser.SYS_USER);
		if(sysUser!=null){
			logService.addSysUserLog(new SysUserLog(PublicEnum.NORMAL.value(), SecurityUtils.getSubject().getPrincipal().toString(), new Date(), sysUser.getUserId(), sysUser.getUserName(), SecurityUtils.getSubject().getSession().getHost().toLowerCase(), method, null, result, usetime));
		}
		return proceed;
	}
}
