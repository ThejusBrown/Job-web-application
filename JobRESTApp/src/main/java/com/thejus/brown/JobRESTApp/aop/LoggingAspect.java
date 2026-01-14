package com.thejus.brown.JobRESTApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private  static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.thejus.brown.JobRESTApp.service.Service.*(..))")
    public  void logMethodBeforeCall(JoinPoint jp){
        LOGGER.info("Method called befored executing "+ jp.getSignature().getName());
    }

    @After("execution(* com.thejus.brown.JobRESTApp.service.Service.*(..))")
    public  void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.thejus.brown.JobRESTApp.service.Service.*(..))")
    public  void logMethodCallCrash(JoinPoint jp){
        LOGGER.info("Method called"+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.thejus.brown.JobRESTApp.service.Service.*(..))")
    public  void logMethodCallError(JoinPoint jp){
        LOGGER.info("Method called"+ jp.getSignature().getName());
    }

}
