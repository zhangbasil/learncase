package com.zhangbin.learncase.map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * HashMap,LinkedHashMap,TreeMap的有序性
 *
 * @author zhangbin
 * @Type MapOrder
 * @Desc map 有序性学习
 * @date 2017-12-28
 * @Version V1.0
 */
public class MapOrder {
    public static void main(String[] args) {
        hashMapCase();
        System.out.println(" ======================= ");
        linkedHashMapCase();
        System.out.println(" ======================= ");
        treeMapCase();
    }

    private static void hashMapCase() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "1");
        hashMap.put("c", "3");
        hashMap.put("name", "张三丰");
        hashMap.put("b", "2");
        hashMap.put("d", "4");
        hashMap.put("ab", "89");
        hashMap.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    }

    private static void linkedHashMapCase() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "1");
        linkedHashMap.put("c", "3");
        linkedHashMap.put("name", "张三丰");
        linkedHashMap.put("b", "2");
        linkedHashMap.put("d", "4");
        linkedHashMap.put("ab", "89");
        linkedHashMap.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    }

    private static void treeMapCase() {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "1");
        treeMap.put("c", "3");
        treeMap.put("name", "张三丰");
        treeMap.put("b", "2");
        treeMap.put("d", "4");
        treeMap.put("ab", "89");
        treeMap.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    }

    @Test
    void flatMapTest() {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world", "hello world welcome");

        List<Object> collect = list.stream().map(l -> {
            Map<String, Object> ab = new HashMap<>();
            return ab.put(l, l);
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
