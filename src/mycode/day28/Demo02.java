package mycode.day28;

import java.util.ArrayList;

/**
 * Created by ls on 17-7-19.
 */
public class Demo02 {
    public static void main(String[] args) {
        Number num = new Number();
        new Thread(num,"前门").start();
        new Thread(num,"后门").start();
    }
}
class Number implements Runnable{
    static int person=100;
    int sumq=0;
    int sumh = 0;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            synchronized (this) {
                try {
                    if(person<0){
                        return;
                    }
                    Thread.sleep(30);
                    String name = Thread.currentThread().getName();
                    if(name.equals("前门")){
                        sumq++;
                        System.out.print("编号为:"+(100-person+1)+"  的员工 从"+ name + "入场! 拿到的双色球彩票号码是:");
                        --person;
                        arr();
                    }
                    if(name.equals("后门")){
                        sumh++;
                        System.out.print("编号为:"+(100-person+1)+"  的员工 从"+ name + "入场! 拿到的双色球彩票号码是:");
                        --person;
                        arr();
                    }
                    if(person==0){
                        System.out.println("从后门入场的员工总共:"+sumh+"位员工");
                        System.out.println("从后门入场的员工总共:"+sumq+"位员工");
                        person--;
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
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

