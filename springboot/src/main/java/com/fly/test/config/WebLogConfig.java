package com.fly.test.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Order(1)
@Component
public class WebLogConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogConfig.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.fly.test.controller..*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String requestUri = request.getRequestURI();
        String requestMethod = request.getMethod();
        String queryString = request.getQueryString();

        LOGGER.info("--------------------------------- " + requestUri + " start -------------------------------------");
        LOGGER.info("URL : " + requestUri);
        LOGGER.info("HTTP_METHOD : " + requestMethod);
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("REQUEST_QUERY_STRING : " + queryString);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        LOGGER.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        LOGGER.info("----------------------------------------- response end -----------------------------------------");

        startTime.remove();
    }

}


