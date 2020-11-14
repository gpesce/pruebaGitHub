package com.bitblend.spring.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BitBlendAspecJ {

	@Around("execution(* com.bitblend.spring.service.PatientServiceImp.save*(..))")
	public Object auditMethod(ProceedingJoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		System.out.println("CreatePersistentObjectInterceptor - Logging BEFORE calling method : " + methodName);
		Object ob = jp.proceed();
		System.out.println("CreatePersistentObjectInterceptor - Logging AFTER calling method : " + methodName);
		return ob;
	}
}
