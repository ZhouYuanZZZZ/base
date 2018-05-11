package com.zy.thread;

import org.junit.Test;

public class App0 {

    public static void main(String[] args) throws InterruptedException {


        Runnable runnable1 = ()->{
            for (int i = 0; i <1000 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        };

        Runnable runnable2 = ()->{
            for (int i = 0; i <1000 ; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        };

        Thread t1 = new Thread(runnable1);
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();

    }


}
