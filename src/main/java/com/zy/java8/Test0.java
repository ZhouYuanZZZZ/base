package com.zy.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test0 {

    @Test
    public void test0(){
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            testList.add(i);
        }
        testList.forEach(n -> System.out.println(n));
    }
}
