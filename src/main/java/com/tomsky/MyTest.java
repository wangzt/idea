package com.tomsky;

import com.tomsky.thread.Cache;

/**
 * Created by j-wangzhitao on 17-6-1.
 */
public class MyTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String val;
                for (int i = 0; i < 20; i++) {
                    val = String.valueOf(i);
                    Cache.getInstance().add(val, val);
                }
                Cache.getInstance().printMap();
            }
        }).start();

//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                String val;
                for (int i = 0; i < 20; i++) {
                    val = String.valueOf(i);
                    Cache.getInstance().add(val, val);
                }
                Cache.getInstance().printMap();
            }
        }).start();
    }
}
