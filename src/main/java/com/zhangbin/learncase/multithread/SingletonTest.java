package com.zhangbin.learncase.multithread;

import org.junit.jupiter.api.Test;

/**
 * @author zhangbin
 * @Type SingletonTest
 * @Desc 单例模式
 * @date 2018-03-23
 * @Version V1.0
 */
public class SingletonTest {

    private static SingletonTest singleton;
    private static volatile int num = 200;

    public static SingletonTest getSingleton() {
        if (singleton == null) {
            synchronized (SingletonTest.class) {
                if (singleton == null) {
                    System.out.println("singleton is null ");
                    singleton = new SingletonTest();
                }
            }
        }
        return singleton;
    }

    @Test
    void test() {
        Thread[] threads = new Thread[2];
        for (int i = 0; i< 2; i ++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                if (index % 2 == 0) {
                    printNum("a");
                } else {
                    printNum("b");
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    private synchronized void printNum(String str) {
        if (str.equals("a")) {
            System.out.println("" + str);
            num = num - 100;
        } else {
            System.out.println("" + str);
            num = num - 200;
        }
        System.out.println("num = " + num);
    }








}
