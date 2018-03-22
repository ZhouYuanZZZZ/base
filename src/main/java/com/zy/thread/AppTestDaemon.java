package com.zy.thread;

public class AppTestDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new TestDaemonThread());
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
