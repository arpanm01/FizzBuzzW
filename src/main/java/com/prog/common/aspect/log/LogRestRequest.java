package com.prog.common.aspect.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogRestRequest {
	
	final Logger LOG = LoggerFactory.getLogger(LogRestRequest.class);
    
	@Pointcut("within(@org.springframework.web.bind.annotation.RequestMapping *)")
	public void controller() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void allMethod() {
	}

	@Pointcut("execution(* *.*(..))")
	protected void loggingAllOperation() {
	}
	
    //@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	@Around("controller() && loggingAllOperation()")
	public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    	
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    Object value;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
        	LOG.debug("{} and {}",request.getMethod(),request.getRequestURI());
        }
        return value;
    }
}