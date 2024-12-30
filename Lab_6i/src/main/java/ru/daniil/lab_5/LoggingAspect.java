package ru.prokhor.lab_5;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("@annotation(LogRequest)")
	//@Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public Object logHttpRequests(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		logger.info("Перехват управления аспектом на входе в класс аннотируемый как GetMapping");
		logger.info("Метод и адрес запроса HTTP Request: {} {}", request.getMethod(), request.getRequestURI());
		logger.info("Передаваемые заголовки запроса:");
		for (Enumeration e=request.getHeaderNames(); e.hasMoreElements();){
			String headerName=(String) e.nextElement();
			logger.info("HEADER {} : {}", headerName, request.getHeader(headerName));		
		}
		logger.info("Тело запроса:");
		//logger.info("BODY {}", request.getReader().lines().reduce("",String::concat));
		
		Object result = joinPoint.proceed();
		
		return result;
	}
}
