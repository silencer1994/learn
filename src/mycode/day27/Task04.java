package mycode.day27;

/**
 * Created by ls on 17-7-19.
 * 3、有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
 * <p>
 * 抽奖箱1 又产生了一个 10 元大奖
 * 抽奖箱2 又产生了一个 100 元大奖
 * //.....
 */
public class Task04 {
    public static void main(String[] args) {
        ChouJiang c1 = new ChouJiang(30);
        ChouJiang c2 = new ChouJiang(30);
        Thread thread1 = new Thread(c1);
        Thread thread2 = new Thread(c1);
        Thread thread3 = new Thread(c1);
        thread1.setName("抽奖箱1");
        thread2.setName("抽奖箱2");
        thread3.setName("抽奖箱3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ChouJiang implements Runnable {
    private int count;
    private int[] arr = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300};
    private int lotto;

    public ChouJiang(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < count; i++) {
                notifyAll();
                lotto = arr[(int) (Math.random() * arr.length)];
                System.out.println(Thread.currentThread().getName() + " 又产生了一个 " + lotto + " 元大奖");
                try {
                    if (i != count - 1)
                        wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}