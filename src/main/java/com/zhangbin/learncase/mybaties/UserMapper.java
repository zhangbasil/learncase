package com.zhangbin.learncase.mybaties;

import java.util.List;

/**
 * @author zhangbin
 * @Type UserMapper
 * @Desc
 * @date 2018-07-24
 * @Version V1.0
 */
public interface UserMapper {

//    @Select("SELECT * FROM t_user WHERE id = #{id}")
    UserPO queryById(Long id);

//    @Select("SELECT * FROM t_user")
    List<UserPO> query();
}
