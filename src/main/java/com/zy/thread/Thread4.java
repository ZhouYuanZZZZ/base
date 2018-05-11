package com.zy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Thread4 implements Runnable {

    private ReentrantLock lock = LockFactory.getLock1();
    private Condition condition = LockFactory.getCondition1();
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            lock.lock();
            condition.signal();

            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "---------> " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
        }
    }
}
