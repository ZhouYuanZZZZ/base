package com.zy.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {

    @Test
    public void test0(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_YEAR,-1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(instance.getTime());
        System.out.println(sdf.format(instance.getTime()));
    }
}
