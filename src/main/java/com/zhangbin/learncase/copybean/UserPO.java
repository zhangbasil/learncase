package com.zhangbin.learncase.copybean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author zhangbin
 * @Type UserPO
 * @Desc
 * @date 2018-04-03
 * @Version V1.0
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPO {
    Long id;
    String userName;
    char sex;
    int age;
}
