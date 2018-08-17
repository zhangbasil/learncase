package com.zhangbin.learncase.jvm;

import org.junit.jupiter.api.Test;

/**
 * @author zhangbin
 * @Type FinalizeEscapeGCTest
 * @Desc
 *
 *  此代码演示2点
 *  1.对象可以在被GC时自我拯救
 *  2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 *
 *
 *  程序输入结果：
 *
 *  finalize 方法执行完成
 *  hi, I am still alive!
 *  oh, I am dead.
 *
 *
 * @date 2018-04-30
 * @Version V1.0
 */
public class FinalizeEscapeGCTest {


    public static FinalizeEscapeGCTest SAVE_HOOK = null;
    
    public void isAlive() {
        System.out.println(" hi, I am still alive! " );
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize 方法执行完成 ");
        // 自救
        FinalizeEscapeGCTest.SAVE_HOOK = this;
    }

    @Test
    void test() throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGCTest();


        // 第一次GC ，对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize优先级很低，暂停5秒等待它
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" oh, I am dead. " );
        }

        //////////////////////////////////////////////////////////////

        // 下面代码和上面完全一样，但是这次自救却失败

        SAVE_HOOK = null;
        System.gc();
        // 因为finalize优先级很低，暂停5秒等待它
        Thread.sleep(5000);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println(" oh, I am dead. " );
        }



    }

}
