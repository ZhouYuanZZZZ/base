package com.zy.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
@Aspect
public class AopTransaction {

    private static final Logger logger = LoggerFactory.getLogger(AopTransaction.class);

    @Resource
    private TransactionUtils transactionUtils;


    public void afterThrowing(Exception ex) {
        logger.info("aop afterThrowing");
        logger.error("aop afterThrowing", ex);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Around("execution(* com.zy.spring.services.*.* (..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        logger.info("begin transaction");
        TransactionStatus begin = transactionUtils.begin(proceedingJoinPoint);

        try {
            proceedingJoinPoint.proceed();

            logger.info("commit");
            transactionUtils.commit(begin);
        } catch (Throwable throwable) {
            logger.error("", throwable);
            transactionUtils.rollback(begin);
        }
    }


}
