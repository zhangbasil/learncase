package com.zhangbin.learncase.threadlocal;

import org.junit.jupiter.api.Test;

/**
 * @author zhangbin
 * @date 2018-03-13
 *
 *
 * ThreadLocal：提供一个线程的局部变量，每个线程都是独立初始化自己的一个副本。说白了就是在多线程环境下保证局部变量的安全
 *
 * ThreadLocal 运用场景：最适合每个对象对应一个实例的对象访问
 *
 *
 */
class ThreadLocalTest {

    private static Num num = new Num();

    private static final ThreadLocal<User> THREAD_LOCAL = ThreadLocal.withInitial(() -> new User("张斌", 26));

    private static final ThreadLocal<Num> NUM_THREAD_LOCAL = ThreadLocal.withInitial(() -> num);



    @Test
    void ab() {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                /* ThreadLocal 局部变量指向不同对象 每次创建都是new一个新的实例*/
                THREAD_LOCAL.get().setAge(THREAD_LOCAL.get().getAge() + 10);
                System.out.println("---不同对象---：" + Thread.currentThread().getName() + " : " + THREAD_LOCAL.get().getAge());

                /* ThreadLocal 局部变量指向相同对象 */
                NUM_THREAD_LOCAL.get().setNum(NUM_THREAD_LOCAL.get().getNum() + 100);
                System.out.println("相同对象：" + Thread.currentThread().getName() + " : " + NUM_THREAD_LOCAL.get().getNum());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }



}

class Num {
    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
