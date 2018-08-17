package com.zhangbin.learncase.mybaties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class UserPO {
    Long id;
    LocalTime gmtCreated;
    LocalTime gmtModified;
    boolean isDeleted;
    String userName;
    String userPwd;
    String userSex;

}
