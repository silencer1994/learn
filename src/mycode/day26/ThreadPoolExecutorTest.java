package mycode.day26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ls on 17-7-17.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
//                Thread.currentThread().wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
//                    Thread.currentThread().notifyAll();
                    System.out.println(index);
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
