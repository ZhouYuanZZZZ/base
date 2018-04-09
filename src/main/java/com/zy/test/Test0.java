package com.zy.test;

import org.junit.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

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

    @Test
    public void test1(){
        List<Integer> list =new  ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
            System.out.println(list);
            iterator.remove();
            System.out.println(list);
            System.out.println("----------------");
        }
    }

    @Test
    public void test2(){
        int total = 15789;
        int num=(int)(Math.random()*2000);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            total = total+num;
            list.add(total);
        }

        System.out.println(list);
    }
}
