package com.zy.thread;

public class App {

   public static void main(String[] args) {
       Thread t1 = new Thread(new Thread1());
       t1.setName("t1");
       Thread t2 = new Thread(new Thread2());
       t2.setName("t2");
       t1.start();
       t2.start();


   }
}
