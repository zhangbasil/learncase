package com.zhangbin.learncase.spring.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhangbin
 * @Type BeanLoadTest
 * @Desc
 * @date 2018-04-30
 * @Version V1.0
 */
class BeanLoadTest {


    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("spring/spring-context.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        User user = (User) factory.getBean("user");
        String str = user.say("张斌");
        System.out.println("str = " + str);
    }

}