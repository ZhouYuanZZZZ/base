package com.zy.thread.simpleThreadPoolDemo;

import java.util.List;
import java.util.Vector;

public class SimpleThreadPool {

    private static SimpleThreadPool simpleThreadPool = null;

    private List<Worker> idleThreads;
    private int threadCounter;
    private boolean shutDown;

    public SimpleThreadPool() {
        idleThreads = new Vector<>(10);
        threadCounter = 0;
    }

    public List<Worker> getIdleThreads() {
        return idleThreads;
    }

    public void setIdleThreads(List<Worker> idleThreads) {
        this.idleThreads = idleThreads;
    }

    public int getThreadCounter() {
        return threadCounter;
    }

    public void setThreadCounter(int threadCounter) {
        this.threadCounter = threadCounter;
    }

    public boolean isShutDown() {
        return shutDown;
    }

    public void setShutDown(boolean shutDown) {
        this.shutDown = shutDown;
    }

    public synchronized static SimpleThreadPool getInstance() {
        if (simpleThreadPool == null) {
            simpleThreadPool = new SimpleThreadPool();
        }
        return simpleThreadPool;
    }

    protected synchronized void rePool(Worker workerThread) {
        if (!shutDown) {
            idleThreads.add(workerThread);
        } else {
            workerThread.shutDown();
        }
    }

    public synchronized void shutDown() {
        this.shutDown = true;
        for (Worker item : idleThreads) {
            item.shutDown();
        }
    }

    public synchronized void start(Runnable target) {

        //如果有空闲线程 直接使用
        if (idleThreads.size() > 0) {
            int lastSize = idleThreads.size() - 1;
            Worker worker = idleThreads.get(lastSize);
            idleThreads.remove(lastSize);

            //执行任务
            worker.setTarget(target);
        } else {
            this.threadCounter++;
            Worker worker = new Worker(this, target, "NO:" + threadCounter);
            worker.start();
        }

    }
}
