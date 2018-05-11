package com.zy.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadDemo {

    public static void main(String[] args){
        Runnable runnable = ()->{
          Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");
            System.out.println(simpleDateFormat.format(date));
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(runnable,0,2, TimeUnit.SECONDS);
    }
}
