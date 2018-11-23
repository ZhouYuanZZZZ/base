package com.zy.thread.jdkthreadpool;

import java.util.Date;

public class Thread0 implements Runnable {

    public void run() {
        System.out.println(new Date()+":"+Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
