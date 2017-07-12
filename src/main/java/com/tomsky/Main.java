package com.tomsky;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello idea!");
        long time = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        testMod(188, list);
        System.out.println("cost time:"+(System.currentTimeMillis() - time));
        for (Integer i: list) {
            System.out.println(i);
        }
    }

    private static void testMod(int num, List<Integer> result) {
        int reminder = 0;
        if (num > 1000) {
            reminder = calcMod(num,1000, result);
        } else if (num > 100) {
            reminder = calcMod(num,100, result);
        } else if (num > 10) {
            reminder = calcMod(num,10, result);
        }

        if (reminder > 100) {
            reminder = calcMod(reminder,100, result);
        } else if (reminder > 10) {
            reminder = calcMod(reminder,10, result);
        }

        if (reminder > 10) {
            reminder = calcMod(reminder,10, result);
        }

        if (reminder > 0) {
            calcMod(reminder, 1, result);
        }
    }

    private static int calcMod(int num, int divider, List<Integer> result) {
        int last = 0;
        if (result.size() > 0) {
            last = result.get(result.size() - 1);
        }
        int val = num/divider;
        int reminder = num % divider;
        for (int i = 1; i <= val; i++) {
            result.add(last + i*divider);
        }
        return reminder;
    }

}
