package com.kh.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // advice 실행순서를 결정(클수록 먼저 시작됨)
// import org.springframework.core.annotation.Order;
public class AfterTest {

	private Logger logger = LoggerFactory.getLogger(AfterTest.class);
	
	@After("CommonPointcut.implPointcut()")
	public void serviceEmd(JoinPoint jp) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("end : "+jp.getTarget().getClass().getSimpleName()+" - ");
		sb.append(jp.getSignature().getName());
		sb.append("\n=================================== end ===================================\n");
		
		logger.info(sb.toString());
	}
}
