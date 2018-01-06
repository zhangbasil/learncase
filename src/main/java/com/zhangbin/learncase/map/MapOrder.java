package com.zhangbin.learncase.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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

}
