package com.zhangbin.learncase.lombok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author zhangbin
 * @Type LombokTest
 * @Desc Lombok 对象循环依赖存在：java.lang.StackOverflowError
 *
 *      当在使用lombok @Data 注解的时候存在，此注解
 *      不仅帮我们实现了生成了@Getter / @Setter 注解，
 *      还包含了@ToString, @EqualsAndHashCode, 和 @RequiredArgsConstructor 注解
 * @link https://www.cnkirito.moe/2018/03/28/java-eqaulsandhashcode/
 *      Lombok 生成的equals和hashcode 方法会用对象里面所有的属性来计算hashcode
 *      当出现出现循环引用就会出现死循环
 *
 *
 *
 * @date 2018-04-04
 * @Version V1.0
 */
public class LombokTest {

    @Test
    void lombokHashCodeTest() {
        Project p1 = new Project(100L);

        Project p2 = new Project(100L);
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
