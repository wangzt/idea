package com.tomsky.test;

import org.junit.Test;

import java.util.HashMap;

public class DataStructTest {

    private int depth = 0;
    private HashMap<Integer, Integer> solvedMap = new HashMap<>();

    @Test
    public void recycle() {
        System.out.println("count:"+ f(6));
    }

    private int f(int n) {
        ++depth;
        System.out.println("---"+depth);

        if (n == 1) return 1;
        if (n == 2) return 2;

        if (solvedMap.containsKey(n)) {
            return solvedMap.get(n);
        }

//        System.out.println("n==="+n+"---depth:"+depth);
        int ret =  f(n - 1) + f(n - 2);
        solvedMap.put(n, ret);

        return ret;
    }
}
