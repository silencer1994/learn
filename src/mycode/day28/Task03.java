package mycode.day28;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ls on 17-7-19.
 *  * 4、某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多线程模拟年会入场过程,
 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
 //.....
 从后门入场的员工总共: 13 位员工
 从前门入场的员工总共: 87 位员工
 */
public class Task03 {
    public static void main(String[] args){
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setName("前门");
        Thread thread2 = new Thread(task);
        thread2.setName("后门");
        thread.start();
        thread2.start();
    }

    static class Task implements Runnable{
        private int count=100;
        private int q;
        private int h;
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            while(count>0){
                in(name);
            }
            System.out.println(" 从前门入场的员工总共: "+q+" 位员工");
            System.out.println(" 从后门入场的员工总共: "+h+" 位员工");
        }

        private synchronized void in(String name) {
            if("前门".equals(name)){
                System.out.println("编号为: "+count+" 的员工 从前门 入场! 拿到的双色球彩票号码是: ");
                arr();
                q++;
                count--;
            }
            if("后门".equals(name)){
                System.out.println("编号为: "+count+" 的员工 从后门 入场! 拿到的双色球彩票号码是: ");
                arr();
                h++;
                count--;
            }
        }

        private String getCaiPiao() {
            List<Integer> caipiao = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                caipiao.add((int) (Math.random() * 32 + 1));
            }
            caipiao.add((int) (Math.random() * 16)+1);
            return caipiao.toString();
        }
        public static void arr(){
            ArrayList<Integer> list = new ArrayList<>();
            while(list.size()<7){
                int num  = (int) (Math.random()*30);
                if(!list.contains(num)){
                    list.add(num);
                }
            }
            System.out.println(list);
        }
    }
}
