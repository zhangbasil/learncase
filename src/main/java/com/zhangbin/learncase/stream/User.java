package com.zhangbin.learncase.stream;

import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author zhangbin
 * @Type User
 * @Desc
 * @date 2018-01-02
 * @Version V1.0
 */
public class User {
    private Long id;
    private String name;
    private Date date;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String compute(String name) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name.substring(name.length() - 1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
