package com.zhangbin.learncase.lombok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zhangbin
 * @Type LombokTest
 * @Desc
 * @date 2018-04-04
 * @Version V1.0
 */
public class LombokTest {

    @Test
    void lombokHashCodeTest() {
        Project p1 = new Project();
        Project p2 = new Project();
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());

//        p1.setProjects(Collections.singletonList(p2));
//        p2.setProjects(Collections.singletonList(p1));
        p1.setProject(p2);
        p2.setProject(p1);

        System.out.println("p1 = " + p1.toString());
        System.out.println("p1.hashCode() = " + p1.hashCode());


    }
}
