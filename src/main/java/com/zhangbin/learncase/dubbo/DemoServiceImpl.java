package com.zhangbin.learncase.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author zhangbin
 * @Type DemoServiceImpl
 * @Desc
 * @date 2018-06-24
 * @Version V1.0
 */
@Service(version = "1.0.1")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "你好：" + name + ". Hello World!";
    }
}
