package com.zhangbin.learncase.jvm;

/**
 * @author zhangbin
 * @Type SynchronizedTest
 * @Desc
 * @date 2018-04-01
 * @Version V1.0
 */
public class SynchronizedTest {

    private void method1() {
        System.out.println(" hello world ");
    }

    private synchronized void method2() {
        System.out.println(" hello world " );
    }
}
