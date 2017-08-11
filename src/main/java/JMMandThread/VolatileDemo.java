package JMMandThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Charley on 2017/8/5.
 */
public class VolatileDemo {

    public static volatile int race = 0;
    public static final int THREAD_NUM = 20;

    public static void increace() {

        race++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[THREAD_NUM];
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

        for (int i = 0; i < 20; ++i) {
            threads[i] = new Thread(new Runnable() {
                public void run() {

                    for (int i = 0; i < 10000; ++i) {
                        increace();
                    }
                    countDownLatch.countDown();
                }
            });
            threads[i].start();
        }

        countDownLatch.await();
        System.out.println("race: " + race);
    }
}
