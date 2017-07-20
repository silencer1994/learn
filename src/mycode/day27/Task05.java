package mycode.day27;

/**
 * Created by ls on 17-7-19.
 * 4、某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多线程模拟年会入场过程,
 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
 //.....
 从后门入场的员工总共: 13 位员工
 从前门入场的员工总共: 87 位员工
 */
public class Task05 {
    public static void main(String[] args){
         Entrance2 entrance2 = new Entrance2();
        Task task1 = new Task(entrance2,Door2.前门);
        Task task2 = new Task(entrance2,Door2.后门);
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
class Task implements Runnable{
    private Door2 door2;
    private Entrance2 entrance2;

    public Task(Entrance2 entrance2,Door2 door2) {
        this.door2 = door2;
        this.entrance2 = entrance2;
    }

    @Override
    public void run() {
        if(door2==Door2.前门){
            entrance2.inQianmen();
        }
        if(door2==Door2.后门){
            entrance2.inHoumen();
        }
    }
}
class Entrance2{
    private Integer count = 100;
    public synchronized int inQianmen(){
        int number = 0;
        synchronized (count){
            while(count>0){
                count--;
                number++;
                System.out.println("编号为: "+count+" 的员工 从前门 入场! 拿到的双色球彩票号码是: ");
                Thread.yield();
            }
            System.out.println("从前门入场的员工总共: "+number+" 位员工");
            return number;
        }
    }
    public synchronized int inHoumen(){
        int number = 0;
        synchronized (count){
            while(count>0){
                count--;
                number++;
                System.out.println("编号为: "+count+" 的员工 从后门 入场! 拿到的双色球彩票号码是: ");
                Thread.yield();
            }
            System.out.println("从后门场的员工总共: "+number+" 位员工");
            return number;
        }
    }
}

enum Door2{
    前门,后门
}

