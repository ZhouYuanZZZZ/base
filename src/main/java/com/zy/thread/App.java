package com.zy.thread;

public class App {

   public static void main(String[] args) {

       ThreadGroup threadGroup = new ThreadGroup("Test Grouop");
       Thread t3 = new Thread(threadGroup,new Thread3());
       t3.setName("3333333333333333333333");
       Thread t4 = new Thread(threadGroup,new Thread4());
       t4.setName("4444444444444444444444");
       t3.start();
       t4.start();

   }
}
