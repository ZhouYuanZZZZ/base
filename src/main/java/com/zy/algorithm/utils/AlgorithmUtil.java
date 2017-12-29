package com.zy.algorithm.utils;

import java.util.Random;

public class AlgorithmUtil {

    private static Random random;

    static {
        random = new Random();
    }

    public static int[] getRandomIntArray(int len,int max){
        int[] a = new int[len];

        for(int i = 0;i<len;i++){
          a[i] = random.nextInt(max+1);
        }

        return a;
    }

    //一趟快速排序算法
   public static int quickPass(int[] a, int left, int right){

        int temp,low,hight;

        temp = a[left];
        low = left;
        hight = right;

        while (low<hight) {
            while (low<hight && a[hight]>=temp) {
                hight--;
            }
            if (low<hight) {
                a[low] = a[hight];
                low++;
            }

            while (low<hight && a[low] < temp) {
                low++;
            }
            if (low<hight) {
                a[hight] = a[low];
                hight--;
            }
        }
        a[low] = temp;
        return low;
    }

    //快速排序 时间复杂度 nlog2n
    public static void quickSort(int a[],int low,int hight) {

        if (low<hight) {
            int mid = quickPass(a,low,hight);//调用一趟排序将元素分为2个子表
            quickSort(a, low, mid - 1);//对左部子表进行排序
            quickSort(a, mid + 1, hight);//对右部子表进行排序
        }

    }

    public static void showIntArray(int[] a){
        System.out.print("[");
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.print("]");
        System.out.println("");
    }
}
