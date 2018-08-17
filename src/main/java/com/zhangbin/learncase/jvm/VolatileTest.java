package com.zhangbin.learncase.jvm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 被volatile修饰的共享变量具有如下两点特性
 *
 * 1. 保证了不同线程对该变量操作的内存可见性
 *
 * 2.禁止指令重排序
 *
 * 3.必须是原子操作，否则不保证线程安全
 *
 *
 * @author zhangbin
 * @Type VolatileTest
 * @Desc
 * @date 2018-01-08
 * @Version V1.0
 */
public class VolatileTest {

    private static volatile int race = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private void increase() {
        // Non-atomic operation on volatile field 'race' 不是原子操作提示
        // race++;

        // CAS
        atomicInteger.incrementAndGet();
    }

    /**
     * 可见性
     */
    @Test
    void visibilityTest() {
        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });

            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("race = " + race);
        System.out.println("atomicInteger = " + atomicInteger);
    }

    @Test
    void contains() {

        Date date = new Date(1523872500000L);
        System.out.println("date = " + date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1523872500000L);

        Date time = calendar.getTime();
        System.out.println("time = " + time);

        // 1523872500000
        // System.out.println("date.getTime() = " + date.getTime());
    }

    @Test
    void booleanTest() {
        if (success()) {
            System.out.println(" true ");
        } else {
            System.out.println(" false or null " );
        }

    }

    private Boolean success() {
        return null;
    }


}
