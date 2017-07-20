package mycode.day27;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ls on 17-7-18.
 * 4、某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多线程模拟年会入场过程,
 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
 //.....
 从后门入场的员工总共: 13 位员工
 从前门入场的员工总共: 87 位员工
 */
public class Task02 {
    public static void main(String[] args){
        Logic logic = new Logic();
        Thread thread2 = new Thread(new TaskH(logic));
        Thread thread1 = new Thread(new TaskQ(logic));
//        thread1.setPriority(1);
//        thread2.setPriority(10);
        thread1.start();
        thread2.start();
    }
}
class TaskQ implements Runnable{
    private Logic logic;


    public TaskQ(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void run() {
        logic.inQianMem();
    }
}
class TaskH implements Runnable{
    private Logic logic;

    public TaskH(Logic logic) {
        this.logic = logic;
    }

    @Override
    public void run() {

        logic.inHouMem();
    }
}
class Logic {
    //100个员工
    private int count = 100;
    private int countQ = 0;
    private int countH = 0;
    public  void inQianMem(){
        while (count>0){
            System.out.println("编号"+count+"的员工 从"+door.前门+" 入场! 拿到的双色球彩票号码是: "+getCaiPiao());
            moveCount();
            countQ++;
        }
        System.out.println("-------------------------");
        System.out.println(" 从前门入场的员工总共: "+countQ+" 位员工");

    }

    public  void inHouMem(){
        while (count>0){
            System.out.println("编号"+count+"的员工 从"+door.后门+" 入场! 拿到的双色球彩票号码是: "+getCaiPiao());
            moveCount();
            countH++;
        }
        System.out.println("*************************");
        System.out.println(" 从后门入场的员工总共: "+countH+" 位员工");
    }

    private synchronized void moveCount() {
        count--;
    }

    private String getCaiPiao() {
        List<Integer> caipiao = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            caipiao.add((int) (Math.random() * 32 + 1));
        }
        caipiao.add((int) (Math.random() * 16)+1);
        return caipiao.toString();
    }

}
enum door{
    前门,后门
}
