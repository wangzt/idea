package com.tomsky.aop;


import org.junit.Test;

public class AOPTest {

    IMath math = (IMath)new DynamicProxy().getProxyObject(new Math());

    @Test
    public void test01() {
        int n1 = 100;
        int n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
    }

    Math cgMath = (Math) new CglibProxy().getProxyObject(new Math());
    @Test
    public void test02() {
        int n1 = 200;
        int n2 = 10;
        cgMath.add(n1, n2);
        cgMath.sub(n1, n2);
    }
}
