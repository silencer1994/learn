package mycode.day27;

/**
 * Created by ls on 17-7-18.
 * 3、有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:

 抽奖箱1 又产生了一个 10 元大奖
 抽奖箱2 又产生了一个 100 元大奖
 //.....
 */
public class Task01 {

    public static void main(String[] args){
        int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
        Lotto lotto1 = new Lotto(arr);
        Thread thread1 = new Thread(new TaskAdd(lotto1));
        Thread thread2 = new Thread(new TaskMove(lotto1));
        thread1.setName("抽奖箱1");
        thread2.setName("抽奖箱2");
        thread1.start();
        thread2.start();
    }
}
class TaskAdd implements Runnable{
    private Lotto lotto;

    public TaskAdd(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            lotto.lottoAdd();
        }
    }
}
class TaskMove implements Runnable{
    private Lotto lotto;
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            lotto.lottoMove();
        }
    }

    public TaskMove(Lotto lotto) {
            this.lotto = lotto;
    }
}
class Lotto {
    private int[] arr;
    private int lotto;
    private int count;

    public Lotto(int[] arr) {
        this.arr = arr;
    }

    public  void lottoAdd(){
        System.out.println("lottoAdd");
        synchronized (this){
            if(count==1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lotto = arr[(int) (Math.random()*arr.length)];
            // 抽奖箱1 又产生了一个 10 元大奖
            System.out.println(Thread.currentThread().getName()+" 又产生了一个 "+lotto+" 元大奖"+"---------"+count);
            count++;
            notify();
        }
    }
    public  void lottoMove(){
        synchronized (this){
            if(count==0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            lotto = arr[(int) (Math.random()*arr.length)];
            // 抽奖箱1 又产生了一个 10 元大奖
            System.out.println(Thread.currentThread().getName()+" 又产生了一个 "+lotto+" 元大奖");
            notify();
        }

    }
}
