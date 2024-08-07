package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Logging before method execution");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfterMethodExecution() {
        System.out.println("Logging after method execution");
    }
}