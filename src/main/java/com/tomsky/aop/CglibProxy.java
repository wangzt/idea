package com.tomsky.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

public class CglibProxy implements MethodInterceptor {

    Object mTargetObject;

    public Object getProxyObject(Object object) {
        this.mTargetObject = object;

        Enhancer enhancer = new Enhancer();  //增强器，动态代码生成器
        enhancer.setCallback(this);
        enhancer.setSuperclass(mTargetObject.getClass()); // 设置生成类的父类类型
        return enhancer.create(); //  //动态生成字节码并返回代理对象
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        long start = System.currentTimeMillis();
        lazy();

        Object result = proxy.invoke(mTargetObject, args);

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
