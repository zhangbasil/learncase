package com.zhangbin.learncase.jvm;

import org.springframework.util.DigestUtils;

/**
 *
 * 被volatile修饰的共享变量具有如下两点特性
 *
 * 1. 保证了不同线程对该变量操作的内存可见性
 *
 * 2.禁止指令重排序
 *
 *
 * @author zhangbin
 * @Type VolatileCase
 * @Desc
 * @date 2018-01-08
 * @Version V1.0
 */
public class VolatileCase {

    private static int initNum = 100;

    public static void main(String[] args) {
        String scout = DigestUtils.md5DigestAsHex("1234".getBytes());
        System.out.println("scout = " + scout);

        Long.valueOf("abasd");

        Long.parseLong("aaa");

    }

    /**
     *
     * volatile 变量的可见性
     *
     */
    private static void volatileVisibility() {

        for (int i = 1; i < 11; i++) {
            int threadNum = i;
            new Thread(() -> {
                System.out.println("线程 " + threadNum + "  initNum = " + (initNum++));
            }).start();
        }

    }
}
