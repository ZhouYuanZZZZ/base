package com.zy.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);

        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getId()+":"+System.currentTimeMillis());
        };

        for (int i = 0; i <10 ; i++) {
            es.submit(runnable);
        }
    }
}
