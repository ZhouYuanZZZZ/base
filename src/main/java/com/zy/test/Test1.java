package com.zy.test;

public class Test1 {

    public static void main(String[] args) {
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 1000000; i++) {
            sum += i * i / i - i + i;
        }
        long end = System.currentTimeMillis();
        System.out.println("总和为：" + sum + " " + (end - start));
    }

}
