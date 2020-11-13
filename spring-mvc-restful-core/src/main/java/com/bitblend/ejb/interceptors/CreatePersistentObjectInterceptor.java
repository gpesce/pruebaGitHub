package com.bitblend.ejb.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author Gaston Pesce
 */

@Interceptor
@InterceptorBinding
public class CreatePersistentObjectInterceptor {
	
	@AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("CreatePersistentObjectInterceptor - Logging BEFORE calling method :"+context.getMethod().getName() );
        Object result = context.proceed();
        System.out.println("CreatePersistentObjectInterceptor - Logging AFTER calling method :"+context.getMethod().getName() );
        return result;
    }

}
