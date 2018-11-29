package com.zy.thread.future;

import java.util.UUID;

public class RealData implements Data {

    private String result;

    public RealData()  {
        System.out.println("create data start");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("create data end");

        result = UUID.randomUUID().toString();
    }
    @Override
    public String getRequest() {
        return result;
    }
}
