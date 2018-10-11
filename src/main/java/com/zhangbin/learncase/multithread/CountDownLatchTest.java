package com.zhangbin.learncase.multithread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangbin
 * @Type CountDownLatchTest
 * @Desc
 * @date 2018-05-13
 * @Version V1.0
 */
public class CountDownLatchTest {


    @Test
    void doTest() throws InterruptedException {
        final List<Integer> datas = new ArrayList<>();
        final ExecutorService TASK_POOL = Executors.newFixedThreadPool(20);
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                datas.add(i);
            }
        };
        for (int i = 0; i < 20; i++) {
            TASK_POOL.execute(task);
        }
        TASK_POOL.shutdown();
        TASK_POOL.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(datas.size());
    }


    @Test
    void doTestWithCountDown() throws InterruptedException {
        final List<Integer> datas = new ArrayList<>();
        final ExecutorService TASK_POOL = Executors.newFixedThreadPool(20);
        final CountDownLatch countDownLatch = new CountDownLatch(20);
        Runnable task = () -> {
            try {
                countDownLatch.await();//这里等待其他线程就绪后开始放行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                datas.add(i);
            }
        };
        for (int i = 0; i < 20; i++) {
            TASK_POOL.execute(task);
            countDownLatch.countDown();//每个任务提交完毕后执行
        }
        TASK_POOL.shutdown();
        TASK_POOL.awaitTermination(50, TimeUnit.SECONDS);
        System.out.println(datas.size());
    }












    @Test
    void test() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(5);
        CountDownLatch doneSignal = new CountDownLatch(5);
        for (int i = 0; i < 5; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
            doSomethingElse(); // don't let run yet
            startSignal.countDown(); // let all threads proceed
            doSomethingElse();
            doneSignal.await(); // wait for all to finish
        }

    }

    private void doSomethingElse() {
        System.out.println(" = don't let run yet =");
    }

    class Worker implements Runnable {

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doWork() {
            System.out.println(" = doWork = ");
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void playerTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Player(countDownLatch)).start();
        }

    }

    class Player implements Runnable {
        private final CountDownLatch countDownLatch;

        public Player(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            countDownLatch.countDown();
            long count = countDownLatch.getCount();
            System.out.println(" 用户" + count + "进入房间 ");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        }

        private void doWork() {
            System.out.println(" 房间人数满了，开始进入游戏... ");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void workerRunnableTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Executor executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executor.execute(new WorkerRunnable(countDownLatch, i));
            countDownLatch.await();
        }

    }

    class WorkerRunnable implements Runnable {
        private final CountDownLatch countDownLatch;
        private final int i;

        public WorkerRunnable(CountDownLatch countDownLatch, int i) {
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public void run() {

            doWork(i);
            countDownLatch.countDown();

        }

        private void doWork(int i) {
            System.out.println("i = " + i);
        }
    }

}
