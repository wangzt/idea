package com.tomsky.test;

import junit.framework.TestCase;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by j-wangzhitao on 18-5-8.
 */
public class TestQuene extends TestCase {

    public void testQuene() {
//        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
//        queue.add("e");
//        queue.add("d");
//        queue.add("c");
//        queue.add("b");
//        queue.add("a");

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.print(o1+"--"+o2+" ");
                return o1 - o2;
            }
        }
        ) ;
        for (int i = 9; i > 0; i--) {
            queue.add(i);
//            System.out.println(queue.peek());
        }

        System.out.println("===============");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private static final Comparator<String> mOtherComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
//            if ("3".equals(o2)) {
//                return -1;
//            }
            return -1;
        }
    };
}
