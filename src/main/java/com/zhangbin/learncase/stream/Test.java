package com.zhangbin.learncase.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangbin
 * @Type Test
 * @Desc
 * @date 2018-09-29
 * @Version V1.0
 */
public class Test {


    public static void main(String[] args) {

    }

    public void stream() {
        getData().stream().filter(s -> s.equals("a")).collect(Collectors.toList());
    }



    public List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaabb");

        return list;

    }
}
