package com.zy.thread;

public class TestDaemonThread implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("---------------daemon----------------");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
