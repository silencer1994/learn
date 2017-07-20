package mycode.day28;

/**
 * Created by ls on 17-7-19.
 */
public class MulteThreadlShareData {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(shareData).start();
        new Thread(shareData).start();
    }

    static class ShareData implements Runnable{
        int count = 100;
        @Override
        public void run() {
            while(count>0){
                decrease();
            }
        }
        public synchronized void decrease(){
            count--;
            System.out.println(Thread.currentThread().getName()+" this count: "+count);
//            Thread.yield();
        }


    }
}
