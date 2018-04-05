package com.zhangbin.learncase.copybean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author zhangbin
 * @Type CopyPropertiesTest
 * @Desc
 * @date 2018-04-03
 * @Version V1.0
 */
class CopyPropertiesTest {
    private UserPO po;

    @BeforeEach
    void buildUserPO() {
        po = new UserPO();
        po.setId(100L);
        po.setUserName("张斌");
        po.setSex('男');
        po.setAge(27);
    }


    @Test
    void copyPropertiesTest() {
        UserBO userBO = convertBean(po, UserBO.class);
        System.out.println("userBO = " + userBO);
    }

    /***
     * 单个bean转换
     *
     * @param source 资源对象
     * @param target 目标对象
     * @return 目标对象
     */
    private  <E, T> T convertBean(E source, Class<T> target) {
        if (Objects.isNull(source)) {
            return null;
        }
        if (Objects.isNull(target)) {
            throw new NullPointerException("转换的目标对象不能为空！");
        }

        try {
            T instance = target.newInstance();
            BeanUtils.copyProperties(source, instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("对象转换异常：" + e.getMessage(), e);
        }
    }
}
