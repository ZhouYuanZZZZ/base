package com.zy.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueTest0 {

    private static void testBlockQueue() {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        for (int i = 0; i < 10; i++) {
            arrayBlockingQueue.offer(i + "");
        }

        for (int i = 0; i < 15; i++) {
            String item = arrayBlockingQueue.poll();
            System.out.println(item);
        }
    }

    private static void testBlockQueue0() {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);

        for (int i = 0; i < 10; i++) {
            try {
                boolean flag = arrayBlockingQueue.offer(i + "", 2, TimeUnit.SECONDS);
                System.out.println(flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 15; i++) {
            String item = null;
            try {
                item = arrayBlockingQueue.poll(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        testBlockQueue0();
    }
}
