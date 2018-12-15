package com.zy.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
public class TransactionUtils {

    private static final Logger logger = LoggerFactory.getLogger(TransactionUtils.class);

    @Resource
    private PlatformTransactionManager transactionManager;

    public TransactionStatus begin(){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);

        return status;
    }

    public TransactionStatus begin(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {

        boolean transaction = isTransaction(proceedingJoinPoint);
        if(transaction){

            logger.info("is transaction");
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

            TransactionStatus status = transactionManager.getTransaction(def);

            return status;
        }else{
            return null;
        }

    }

    public void rollback(TransactionStatus transactionStatus){
        if(transactionStatus!=null){
            transactionManager.rollback(transactionStatus);
        }
    }

    public void commit(TransactionStatus transactionStatus){
        if(transactionStatus != null){
            transactionManager.commit(transactionStatus);
        }

    }

    private boolean isTransaction(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {

        // 获取方法名称
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 获取目标对象
        Class<?> classTarget = proceedingJoinPoint.getTarget().getClass();
        // 获取目标对象类型
        Class<?>[] par = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterTypes();
        // 获取目标对象方法
        Method objMethod = classTarget.getMethod(methodName, par);

        ExtTransaction annotation = objMethod.getAnnotation(ExtTransaction.class);

        if (annotation == null) {
            return false;
        }

        return true;
    }
}
