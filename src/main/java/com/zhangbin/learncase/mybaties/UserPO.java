package com.zhangbin.learncase.mybaties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

/**
 * @author zhangbin
 * @Type UserPO
 * @Desc
 * @date 2018-07-24
 * @Version V1.0
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPO {
    Long id;
    LocalTime gmtCreated;
    LocalTime gmtModified;
    boolean isDeleted;
    String userName;
    String userPwd;
    String userSex;
    Integer userAge;

}
