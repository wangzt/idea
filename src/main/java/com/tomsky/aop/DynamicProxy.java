package com.tomsky.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;


public class DynamicProxy implements InvocationHandler {

    // 被代理的对象
    Object mTargetObject;

    public Object getProxyObject(Object object) {
        this.mTargetObject = object;

        return Proxy.newProxyInstance(mTargetObject.getClass().getClassLoader(), // 类加载器
                mTargetObject.getClass().getInterfaces(), //获得被代理对象的所有接口
                this); // InvocationHandler对象
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        lazy();

        Object result = method.invoke(mTargetObject, args);

        long span = System.currentTimeMillis() - start;

        System.out.println(method.getName()+"共用时: "+span);

        return result;
    }

    private void lazy() {
        try {
            int n = new Random().nextInt(500);
            Thread.sleep(n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
