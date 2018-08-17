package com.zhangbin.learncase.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangbin
 * @Type StreamCase
 * @Desc jdk8 流学习
 *
 * 并行流 适用计算密集型（非I/O密集型）
 *
 * 大部分都是I/O密集型
 *
 * @date 2018-01-02
 * @Version V1.0
 */
public class StreamCase {

    private static ExecutorService executorService = Executors.newFixedThreadPool(60);


    public static void main(String[] args) throws InterruptedException {

        List<User> users = getUsers();
        User minUser = users.stream().min(Comparator.comparing(User::getId)).orElse(null);
        User maxUser = users.stream().max(Comparator.comparing(User::getId)).orElse(null);



        IntStream.range(0, 10).forEach(index -> {
//            parallelStreamUnsafe();
            System.out.println(" =================== ");
            parallelStreamSafe();

            forkJoinPool();

//            stream();

//            executorService();
//
            completableFuture();

            forEach();
        });

//        Thread.sleep(Integer.MAX_VALUE);

    }


    private static void executorService() {
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        try {
            List<String> list = executorService
                    .submit(() -> users.stream().map(user -> user.compute(user.getName())).collect(Collectors.toList())).get();

            System.out.println("executorService所用时间：" + (System.currentTimeMillis() - start));
//            System.out.println("list.size = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    private static void completableFuture() {
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.supplyAsync(
                () -> users.stream().map(user -> user.compute(user.getName())).collect(Collectors.toList()), executorService);

        try {
            List<String> list = listCompletableFuture.get();
            System.out.println("completableFuture所用时间：" + (System.currentTimeMillis() - start));
            System.out.println("list.size = " + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void forkJoinPool() {
        ForkJoinPool forkJoinPool = new ForkJoinPool(8);
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        try {
            List<String> list = forkJoinPool.submit(() -> users.stream().map(user -> user.compute(user.getName())).collect(Collectors.toList())).get();
            System.out.println("forkJoinPool所用时间：" + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void parallelStreamUnsafe() {
        List<User> users = getUsers();
        System.out.println("users.size() = " + users.size());
        List<String> names = Collections.synchronizedList(new ArrayList<>());
        long start = System.currentTimeMillis();
        users.parallelStream().forEach(user -> names.add(user.compute(user.getName())));
        System.out.println("Collections.synchronizedList所用时间：" + (System.currentTimeMillis() - start));
        System.out.println("names.size = " + names.size());


        /*
        * 使用并行流
        *
        * 如果直接放到 ArrayList 出现线程不安全 换成Vector 或者 Collections.synchronizedList();
        *
        * */
    }

    private static void forEach() {
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.compute(user.getName()));
        }
        System.out.println("forEach所用时间：" + (System.currentTimeMillis() - start));

    }

    private static void parallelStreamSafe() {
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        List<String> names = users.parallelStream().map(user -> user.compute(user.getName())).collect(Collectors.toList());
        System.out.println("并行流所用时间：" + (System.currentTimeMillis() - start));
    }
    private static void stream() {
        List<User> users = getUsers();
        long start = System.currentTimeMillis();
        List<String> names = users.stream().map(user -> user.compute(user.getName())).collect(Collectors.toList());
        System.out.println("流所用时间：" + (System.currentTimeMillis() - start));
    }

    private static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        IntStream.range(0, 1_000).forEach(index -> users.add(new User((long) index, "张三" + index)));
        return users;
    }

    @Test
    public void streamTest() {

        List<String> strings = new ArrayList<>(3_000_000);
        IntStream.range(0, 3_000_000).forEach(i -> strings.add("zhangbin" + i));

        List<String> strings2 = new ArrayList<>(3_000_000);
        IntStream.range(0, 3_000_000).forEach(i -> strings.add("lisi" + i));

        long start = System.currentTimeMillis();
        List<String> collect = strings.parallelStream().filter(strings2::contains).collect(Collectors.toList());
        System.out.println("流所用时间：" + (System.currentTimeMillis() - start));
        System.out.println("collect = " + collect.size());
    }


}
