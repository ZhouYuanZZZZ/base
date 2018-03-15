package com.zy.thread;

public class Thread2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            synchronized (Thread.class){
                System.out.println(Thread.currentThread().getName()+"---------> "+i);
                Thread.class.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
