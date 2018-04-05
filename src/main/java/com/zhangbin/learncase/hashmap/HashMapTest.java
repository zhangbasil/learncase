package com.zhangbin.learncase.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author zhangbin
 * @Type HashMapTest
 * @Desc
 * @date 2018-03-19
 * @Version V1.0
 */
public class HashMapTest {
    private static Map<String, Integer> numbers = new HashMap<>();

    @Test
    void hashMapTest() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张斌");
    }


    @Test
    void dieLoopTest() {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(HashMapTest::putMap);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        getMap();

    }

    @Test
    void calc() {
        int i = 1;
        int j = 1;
        System.out.println(i ++ );
        System.out.println(++ j);
        System.out.println("i = " + i);

        System.out.println(" 1 << 4 = " + (1 << 4));
        System.out.println(" 1 << 30 = " + (1 << 30));
    }


    @Test
    void hashTest() {
        Set<String> set = new HashSet<>();
        set.add("aa");

        List<String> list = new ArrayList<>(20);
        list.add("aa");
        for (int j = 0; ; ++j) {
            System.out.println("j = " + j);
            if (j > 10) {
                return;
            }
        }

    }

    private static void putMap() {
        for (int i =0; i < 500; i++) {
            numbers.put("key" + (i + 1), (i + 1));
        }
    }
    
    private static void getMap() {
        System.out.println("numbers.size() = " + numbers.size());
        for (String key : numbers.keySet()) {
            Integer value = numbers.get(key);
            System.out.println("key = " + key + "  value = " + value);
        }
        numbers.forEach((key, value) -> System.out.println("key = " + key + "  value = " + value));
    }
}
