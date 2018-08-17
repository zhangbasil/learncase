package com.zhangbin.learncase.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbin
 * @Type ThreadLocalController
 * @Desc
 * @date 2018-03-14
 * @Version V1.0
 */
@RestController
public class ThreadLocalController {

    private final ThreadLocal<Count> THREAD_LOCAL = ThreadLocal.withInitial(Count::new);

    @GetMapping
    public String demo() {
        Count count = THREAD_LOCAL.get();
        if (count == null) {
            count = new Count();
            THREAD_LOCAL.set(count);
        }

        count.increment();
        System.out.println("count = " + count.getCount() + "   ThreadName:" + Thread.currentThread().getName());
        return "count = " + count.getCount();
    }

    @GetMapping(value = { "/a/**" })
    public String reqUrl() {
        return "ok";
    }

    @GetMapping(value = { "/a/b" })
    public String reqUrl1() {
        return "ab";
    }





    class Count {
        private int count = 0;

        int getCount() {
            return count;
        }

        void increment() {
            count++;
        }
    }


}
