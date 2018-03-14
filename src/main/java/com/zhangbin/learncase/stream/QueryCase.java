package com.zhangbin.learncase.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangbin
 * @Type QueryCase
 * @Desc
 * @date 2018-01-16
 * @Version V1.0
 */
public class QueryCase {

    public static void main(String[] args) {
        queryTest();

    }

    public static void queryTest() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "张三"));
        userList.add(new User(1L, "张三"));
        userList.add(new User(2L, "张三封"));
        userList.add(new User(3L, "张搜索三"));
        userList.add(new User(4L, "王思"));
        userList.add(new User(5L, "王五"));
        userList.add(new User(6L, "ab张三"));
        userList.add(new User(7L, "c张三"));
        userList.add(new User(7L, ""));
        userList.add(new User(7L, null));

        List<String> collect = userList.stream().map(user -> "ab" + user.getId()).collect(Collectors.toList());

    }
}
