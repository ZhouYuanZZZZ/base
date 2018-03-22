package com.zy.thread;

public class App {

   public static void main(String[] args) {

       ThreadGroup threadGroup = new ThreadGroup("Test Grouop");
       Thread t1 = new Thread(threadGroup,new Thread1());
       t1.setName("t1");
       Thread t2 = new Thread(threadGroup,new Thread2());
       t2.setName("t2");
       t1.start();
       t2.start();

       System.out.println(threadGroup.activeCount());
       threadGroup.list();


   }
}
