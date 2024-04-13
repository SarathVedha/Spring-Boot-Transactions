package com.vedha.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AppProxy {

    // Before advice executes before the method execution
    @Before("execution(* com.vedha.service..*(..)) || execution(* com.vedha.controller..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Entering : {}", joinPoint.getSignature().toShortString());
        log.info("Method {} arguments is : {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    // After advice executes after the method execution
    @After("execution(* com.vedha.service..*(..)) || execution(* com.vedha.controller..*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("Leaving : {}", joinPoint.getSignature().toShortString());
    }

    // Around advice executes before and after the method execution
    @Around("execution(* com.vedha.service..*(..)) || execution(* com.vedha.controller..*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        log.info("Time taken by {} is {} ms", joinPoint.getSignature().toShortString(), (endTime - startTime));

        return result;
    }

    // AfterReturning advice executes after the method execution and returns the result
    @AfterReturning(pointcut = "execution(* com.vedha.service..*(..)) || execution(* com.vedha.controller..*(..)) || execution(* com.vedha.exception..*(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        log.info("Method {} returned value is : {}", joinPoint.getSignature().toShortString(), result);
    }

    // AfterThrowing advice executes after the method execution and throws the exception
    @AfterThrowing(pointcut = "execution(* com.vedha.service..*(..)) || execution(* com.vedha.controller..*(..))", throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        log.error("Method {} throws exception : {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

}
