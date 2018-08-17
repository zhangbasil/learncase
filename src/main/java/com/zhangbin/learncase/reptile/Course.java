package com.zhangbin.learncase.reptile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author zhangbin
 * @Type Course
 * @Desc
 * @date 2018-08-04
 * @Version V1.0
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Course {
    String name;
    String ss;

    public Course() {
    }

    public Course(String name, String ss) {
        this.name = name;
        this.ss = ss;
    }
}
