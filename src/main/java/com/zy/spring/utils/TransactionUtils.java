package com.zy.spring.utils;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

@Component
public class TransactionUtils {

    @Resource
    private PlatformTransactionManager transactionManager;

    public TransactionStatus begin(){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();//事务定义类
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);

        return status;
    }

    public void rollback(TransactionStatus transactionStatus){
        transactionManager.rollback(transactionStatus);
    }

    public void commit(TransactionStatus transactionStatus){
        transactionManager.commit(transactionStatus);
    }
}
