package com.zy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockFactory {

    private static ReentrantLock lock1;
    private static  Condition condition1;

    static {
        lock1 = new ReentrantLock();
        condition1 = lock1.newCondition();
    }

    public static ReentrantLock getLock1() {
        return lock1;
    }


    public static Condition getCondition1() {
        return condition1;
    }

}
