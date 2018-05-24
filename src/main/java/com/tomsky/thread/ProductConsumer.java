package com.tomsky.thread;

/**
 * Created by j-wangzhitao on 18-5-24.
 */
public class ProductConsumer {
    private int count = 0;

    private static final int MIN_PRODUCT = 0;
    private static final int MAX_PRODUCT = 10;

    private Object productLock = new Object();
    private Object consumerLock = new Object();

    public void produce() {
        if (count >= MAX_PRODUCT) {
            try {
                synchronized (productLock) {
                    productLock.wait();
                }
                System.out.println("产品已满，请稍后再生产!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
        count++;
        System.out.println("生产者生产第:"+count+"个产品");
        synchronized (consumerLock) {
            consumerLock.notifyAll();
        }
    }

    public void consume() {
        if (count <= MIN_PRODUCT) {
            try {
                synchronized (consumerLock) {
                    consumerLock.wait();
                }
                System.out.println("缺货，请稍后再取!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        System.out.println("消费者取走了第:"+count+"个产品");
        count--;
        synchronized (productLock) {
            productLock.notifyAll();
        }
    }
}
