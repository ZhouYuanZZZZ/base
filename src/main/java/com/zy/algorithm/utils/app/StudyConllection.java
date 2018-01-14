package com.zy.algorithm.utils.app;

import org.junit.Test;

import java.util.*;

public class StudyConllection {

    @Test
    public void test0(){
        Integer[] a = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        List<Integer> integers = Arrays.asList(a);
        List<Integer> integers1 = integers.subList(0, 3);

        System.out.println(integers.get(0) == integers1.get(0));//true
    }

    @Test
    public void test1(){
        TreeMap<String,String> map = new TreeMap<String, String>();

        map.put("b","b");
        map.put("a","a");
        map.put("c","c");

        SortedMap<String, String> stringStringSortedMap = map.subMap("a", "c");

        System.out.println(stringStringSortedMap);


    }
}
