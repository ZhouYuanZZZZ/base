package com.zy.thread.future;

public class FutureData implements Data {

    private volatile boolean flag;

    private RealData realData;

    public synchronized void setRealData(RealData realData){

        if(flag){
            return;
        }

        this.realData=realData;
        flag=true;

        notify();

    }

    @Override
    public synchronized String getRequest()  {
       while (!flag){
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

       return this.realData.getRequest();
    }
}
