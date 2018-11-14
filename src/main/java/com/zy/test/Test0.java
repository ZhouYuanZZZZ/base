package com.zy.test;

import org.junit.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class Test0 {

    @Test
    public void test0() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 10);
        Date newDate = calendar.getTime();
        System.out.println(newDate);
    }

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            System.out.println(list);
            iterator.remove();
            System.out.println(list);
            System.out.println("----------------");
        }
    }

    @Test
    public void test2() {
        int total = 15789;
        int num = (int) (Math.random() * 2000);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            total = total + num;
            list.add(total);
        }

        System.out.println(list);
    }

    @Test
    public void test3() {
        String[] split = "eeeee,5".split(",");
        for (String item : split) {
            System.out.println(item);
        }
        //System.out.println();
    }

    @Test
    public void test4() {
        char s = 'h';
        "s".length();
        System.out.println(s);
    }

    @Test
    public void test5() {
        int a = 5;
        System.out.println((a > 5) ? 10.8 : 6);
    }

    @Test
    public void test6() {
        char x = 'x';
        int i = 10;

        System.out.println(false?i:x);
        System.out.println(false?10:x);
    }

    @Test
    public void test7(){
        Entity0 entity0 = new Entity0("0");
        Object entity1 = new Entity0("0");

        System.out.println(entity0.equals(entity1));
        System.out.println(entity1.equals(entity0));
    }
}
