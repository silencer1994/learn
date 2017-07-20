package mycode.day26;

/**
 * Created by ls on 17-7-15.
 */
public class Task_01 implements Imap{
    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("有没有一个新的class文件产生");
            }
        }.start();
        new Imap() {
            public  void play() {
                System.out.println("看看Intellij有没有弄一个新的class文件");

            }
        }.play();
        play();
    }

    public static void play() {
        System.out.println("这是通过实现接口来调用方法的,试试看");
    }
}
