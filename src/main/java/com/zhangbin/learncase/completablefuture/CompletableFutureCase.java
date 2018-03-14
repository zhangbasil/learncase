package com.zhangbin.learncase.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.zhangbin.learncase.stream.User;

/**
 * @author zhangbin
 * @Type CompletableFutureCase
 * @Desc https://www.jianshu.com/p/6f3ee90ab7d3
 * @date 2018-03-07
 * @Version V1.0
 */
public class CompletableFutureCase {


    @AfterEach
    void blockThread() {
        System.out.println(" 同步执行完成 ");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void supplyAsyncTest() {
        CompletableFuture.supplyAsync(this::getUsers);
    }

    @Test
    void thenApplyTest() {
        CompletableFuture.supplyAsync(this::response).thenApply(response -> {
            System.out.println(" 异步执行完成，处理异步返回的结果。 ");
            Object date = response.getDate();
            System.out.println("异步返回数据：" + date);
            return "";
        });
    }

    /**
     * 异步执行可以处理返回结果
     */
    @Test
    void thenAcceptTest() {
        CompletableFuture.supplyAsync(this::response).thenAccept(response -> {
            System.out.println(" 异步执行完成，处理异步返回的结果。 ");
            Object date = response.getDate();
            System.out.println("异步返回数据：" + date);
        });
    }




    private Response response() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 异步执行完成返回结果..... ");
        return new Response<>("100", "成功", "ok");
    }





    private void runOther() {
        System.out.println(" 异步执行完成同步执行开始 ");
    }

    private List<User> getUsers() {

        List<User> list = new ArrayList<>();
        User user1 = new User(100L, "张三1");
        User user2 = new User(200L, "张三2");
        User user3 = new User(300L, "张三3");
        User user4 = new User(400L, "张三4");
        User user5 = new User(500L, "张三5");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" 异步执行完成返回结果..... ");
        return list;
    }
}
