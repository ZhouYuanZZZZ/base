package com.zy.thread.simpleThreadPoolDemo;

public class Worker extends Thread {

    private SimpleThreadPool threadPool;

    private Runnable target;

    private boolean shutDown;
    private boolean idle;

    private String name;

    public Worker(SimpleThreadPool threadPool, Runnable target, String name) {
        this.threadPool = threadPool;
        this.target = target;
        this.name = name;
    }

    public Runnable getTarget() {
        return target;
    }

    public synchronized void setTarget(Runnable target) {
        this.target = target;

        notifyAll();
    }

    public boolean isShutDown() {
        return shutDown;
    }

    public void setShutDown(boolean shutDown) {
        this.shutDown = shutDown;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public synchronized void shutDown(){
        this.shutDown = true;
        notifyAll();
    }

    @Override
    public void run() {
        while (!shutDown) {
            idle = false;
            if (target != null) {
                target.run();
            }
            idle = true;

            try{
                threadPool.rePool(this);
                synchronized (this){
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
