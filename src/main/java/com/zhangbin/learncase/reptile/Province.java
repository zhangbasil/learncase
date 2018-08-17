package com.zhangbin.learncase.reptile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author zhangbin
 * @Type Province
 * @Desc
 * @date 2018-08-03
 * @Version V1.0
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Province {

    String id;

    String name;

    List<Information> informations;

    public Province(String id, String name) {
        this.id = id;
        this.name = name;
    }


}
