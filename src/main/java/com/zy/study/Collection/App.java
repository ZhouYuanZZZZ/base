package com.zy.study.Collection;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class App {

    @Test
    public void test0() {
        //优先级队列
        PriorityQueue<BigDecimal> pq = new PriorityQueue();
        for (int i = 0; i < 10; i++) {
            BigDecimal bigDecimal = new BigDecimal(i);
            pq.add(bigDecimal);
        }
        pq.offer(new BigDecimal(-10));
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    //双端队列
    @Test
    public void test1(){
        Deque<BigDecimal> dq = new LinkedList<>();
        for(int i=0;i<10;i++){
            BigDecimal bigDecimal = new BigDecimal(i);
            dq.addFirst(bigDecimal);
        }

        for(int i=0;i<10;i++){
            BigDecimal bigDecimal = new BigDecimal(100-i);
            dq.addLast(bigDecimal);
        }

        while(!dq.isEmpty()){
            System.out.println(dq.removeFirst());
        }
    }

    @Test
    public void test2() throws ClassNotFoundException {
        String s = "";

        Class clazz1 = s.getClass();
        Class clazz2 = Class.forName("java.lang.String");
        Class clazz3 = String.class;

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        System.out.println(clazz1.getName());

    }
}
