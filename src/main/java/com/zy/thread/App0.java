package com.zy.thread;

public class App0 {

    public static void main(String[] args) throws InterruptedException {


        Runnable runnable1 = ()->{
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("----------------------");
                    break;
                }
                System.out.println("zzzz");
            }
        };

        Thread t1 = new Thread(runnable1);
        t1.start();

        Thread.yield();
        Thread.sleep(1000);
        t1.interrupt();

    }
}
