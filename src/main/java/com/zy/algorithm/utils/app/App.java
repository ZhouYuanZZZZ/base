package com.zy.algorithm.utils.app;

import com.zy.algorithm.utils.AlgorithmUtil;
import org.junit.Test;

import java.util.Arrays;

public class App {

    @Test
    public void test0(){

        int[] a = AlgorithmUtil.getRandomIntArray(100,100);
        AlgorithmUtil.showIntArray(a);
        AlgorithmUtil.quickSort(a,0,a.length-1);
        AlgorithmUtil.showIntArray(a);

    }
}
