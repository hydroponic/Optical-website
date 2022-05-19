package com.company.pr14.service;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAspect {
    @Pointcut("within(com.company.pr14.service.Serv)")
    public void stringProcessingMethods() {
    };

    @After("stringProcessingMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature()
                .getName();

        log.info("название метода: " + methodName);
    }

    @AfterReturning(pointcut = "execution(public String com.company.pr14.service.Serv.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        log.info("возвращенное значение: " + result.toString());
    }

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        log.info(joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
        return proceed;
    }
}
