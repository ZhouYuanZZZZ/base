package com.zy.thread.jdkthreadpool;

import org.junit.Test;

import java.util.concurrent.*;

public class JDKThreadPoolDemo {

    private static void testScheduledExecutor(){
        Thread0 thread0 = new Thread0();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(thread0,5,2, TimeUnit.SECONDS);
    }

    private static void testExtThreadPool(){

        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<Runnable>();


        ExecutorService es  = new ThreadPoolExecutor(5,5,0L,TimeUnit.SECONDS,runnables){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("beforeExecute:"+t.getId());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("afterExecute");
            }

            @Override
            protected void terminated() {
                System.out.println("terminated");
            }
        };

        for (int i = 0; i <9 ; i++) {
            Thread0 thread0 = new Thread0();
            es.execute(thread0);
        }
        es.shutdown();
    }
    
    private static void testSimpleThreadPool(){
        Thread0 thread0 = new Thread0();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i <19 ; i++) {

            executorService.execute(thread0);
        }
    }

    public static void main(String[] args){
        testSimpleThreadPool();
    }




}
