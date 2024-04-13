package com.vedha.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DataBaseProxy {

    @Around("target(javax.sql.DataSource)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        log.warn("Entering : {}", joinPoint.getSignature().toShortString());
        log.warn("Method {} arguments is : {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());

        Object proceed = joinPoint.proceed();

        log.warn("Method {} returned value is : {}", joinPoint.getSignature().toShortString(), proceed);
        log.warn("Leaving : {}", joinPoint.getSignature().toShortString());

        return proceed;
    }

}
