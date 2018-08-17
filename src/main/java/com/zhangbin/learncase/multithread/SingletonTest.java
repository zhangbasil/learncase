package com.zhangbin.learncase.multithread;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author zhangbin
 * @Type SingletonTest
 * @Desc 单例模式
 * @date 2018-03-23
 * @Version V1.0
 */
public class SingletonTest {

    private static volatile SingletonTest singleton;
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
        Thread[] threads = new Thread[200];
        for (int i = 0; i< 200; i ++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                SingletonTest singleton = getSingleton();
                System.out.println("singleton = " + singleton);
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




    public enum State {
        ING(1, "进行中"), ED(2, "已免单"), UN(3, "未免单");

        public Integer code;
        public String name;

        State(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public static boolean isExist(Integer code) {
            return Arrays.stream(State.values()).anyMatch(state -> state.code.equals(code));
        }

    }



    @Test
    void isExistTest() throws ParseException {

        boolean exist = State.isExist(1);
        System.out.println("exist = " + exist);

        String str = "198509021";
        String substring = str.substring(4);
        System.out.println("substring = " + substring);


        SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMdd");
        sdf.parse(str);


        System.out.println("sdf = " + sdf);

        System.out.println("str = " + str);

    }






}
