package com.zy.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private static Lock reentrantLock = new ReentrantLock();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void readHandler(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("------------Read----------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void writeHandler(Lock lock){
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("------------Write----------------");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



    public static void main(String[] args){

        Runnable runnable1 = ()->{
            readHandler(readLock);
        };

        Runnable runnable2 = ()->{
            writeHandler(writeLock);
        };

        for(int i=0;i<2;i++){
            new Thread(runnable2).start();
        }

        for(int i=0;i<18;i++){
            new Thread(runnable1).start();
        }
    }
}
