package com.tomsky.aop;

public class Math implements IMath {

    public int add(int n1, int n2) {
        int result = n1 + n2;
        System.out.println(n1+"+"+n2+"="+result);
        return result;
    }

    public int sub(int n1, int n2) {
        int result = n1 - n2;
        System.out.println(n1+"-"+n2+"="+result);
        return result;
    }
}
