package mycode.day28;

/**
 * Created by ls on 17-7-19.
 */
public class Task01 {
    public static void main(String[] args){
        ShareDate shareDate = new ShareDate();
        new Thread(shareDate).start();
        new Thread(shareDate).start();
    }
}
class ShareDate implements  Runnable{
    int count = 100;
    @Override
    public void run() {
        while (count>0){
            decrease();
        }
    }

    private synchronized void decrease() {
        count--;
        System.out.println(Thread.currentThread().getName()+" this count: "+count);
    }
}
