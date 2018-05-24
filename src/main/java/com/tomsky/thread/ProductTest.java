package com.tomsky.thread;

import java.util.concurrent.Future;

/**
 * Created by j-wangzhitao on 18-5-24.
 */
public class ProductTest {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        final ProductConsumer pc = new ProductConsumer();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    pc.produce();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    pc.consume();
                }
            }
        }.start();

//        Thread[] threads = new Thread[3];
//        for (int i = 0; i < 3; i++) {
//            threads[i] = new Thread(() -> {
//                    int mun=local.get();
//                    for(int j=0;j<10;j++){
//                        mun=mun+1;
//                    }
//                    local.set(mun);
//                    System.out.println(Thread.currentThread().getName()+"==="+local.get());
//            });
//        }
//
//        for (Thread thread: threads) {
//            thread.start();
//        }
    }
}
