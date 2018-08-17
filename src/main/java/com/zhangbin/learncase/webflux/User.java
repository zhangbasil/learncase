package com.zhangbin.learncase.webflux;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangbin
 * @Type User
 * @Desc
 * @date 2018-05-29
 * @Version V1.0
 */
@Setter
@Getter
public class User {
    String id;
    String name;
    String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
