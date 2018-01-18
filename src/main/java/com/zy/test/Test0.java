package com.zy.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class Test0 {

    @Test
    public void test0(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,10);
        Date newDate = calendar.getTime();
        System.out.println(newDate);
    }
}
