package ru.prokhor.lab_6;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public Object logHttpRequests(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		logger.info("HTTP Request: {} {}", request.getMethod(), request.getRequestURI());
		
		Object result = joinPoint.proceed();
		
		logger.info("HTTP Response: {}", result);
		return result;
	}
}
