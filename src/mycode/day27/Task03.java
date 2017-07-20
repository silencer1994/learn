package mycode.day27;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
public class Task03 {
    public static void main(String[] args){
        Vector<Persion> persions = new Vector<>();
        for (int i = 0; i < 100; i++) {
            persions.add(new Persion(i + 1));
        }
        Entrance entrance = new Entrance();
        HighProperties runaable1 = new HighProperties(entrance, persions, Door.后门,10);
        HighProperties runaable2 = new HighProperties(entrance, persions, Door.前门,5);
        new Thread(runaable1).start();
//        new Thread(runaable1).start();
        new Thread(runaable2).start();

    }
}
class HighProperties implements Runnable{
    private Entrance entrance;
    private Vector<Persion> persions;
    private Door door;
    private int priority;

    public HighProperties(Entrance entrance, Vector<Persion> persions, Door door,int priority) {
        this.entrance = entrance;
        this.priority = priority;
        this.persions = persions;
        this.door = door;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = persions.size()-1; i < persions.size()&&i>=0; i--) {
            if(door==Door.前门){
                entrance.inQianMen(getPersion());
                Thread.yield();
            }
            if(door==Door.后门){
                entrance.inHouMen(getPersion());
                Thread.yield();
            }

        }
    }

    private synchronized Persion getPersion() {
        return persions.remove(persions.size()-1);
    }
}


class Entrance{
    private Door door1 = Door.前门;
    private Door door2 = Door.后门;
    public synchronized int inQianMen(Persion persion){
        int result = 0;
        if(persion.getId()>0&&persion.getId()<101){
            result = 1;
            System.out.println(Thread.currentThread().getName()+"- 编号为: "+persion.getId()+" 的员工 从"+door1+" 入场! 拿到的双色球彩票号码是: "+getCaiPiao());
            return result;
        }
        return result;
    }
    public synchronized int inHouMen(Persion persion){
        int result = 0;
        if(persion.getId()>0&&persion.getId()<101){
            result = 1;
            System.out.println(Thread.currentThread().getName()+"- 编号为: "+persion.getId()+" 的员工 从"+door2+" 入场! 拿到的双色球彩票号码是: "+getCaiPiao());
            return result;
        }
        return result;
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
class Persion{
    private int id;

    public Persion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

enum Door{
    前门,后门
}
