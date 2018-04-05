package com.zhangbin.learncase.multithread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbin
 * @Type CommunicationDemo
 * @Desc 线程通讯
 * @date 2018-03-23
 * @Version V1.0
 */
public class CommunicationDemo {

    private List<String> strings = new ArrayList<>();

    @Test
    void test() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                System.out.println(" 添加元素： " + (i + 1));
                strings.add("thread:" + (i + 1));
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                if (strings.size() == 5) {
                    try {
                        throw new InterruptedException("线程2停止");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
