package mycode.day08;

import mycode.day08.bean.Brand;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ls on 17-7-5.
 * 独立编写今天的超市管理系统案例
 */
public class Task_1 {
    private static ArrayList<Brand> repertory;

    public static void main(String[] args) {
        initRepertory();
        superMarket();
    }

    private static void initRepertory() {
        repertory = new ArrayList<>();
        repertory.add(new Brand("联想", 8, 7300.0f));
        repertory.add(new Brand("苹果", 2, 17300.0f));
    }

    private static void superMarket() {
        int options = listOptions();
        switch (options) {
            case 1:
                printList();
                break;
            case 2:
                changeRepertoryNumber();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("您输入的参数错误,请重新输入");
                break;
        }
        superMarket();
    }

    /**
     * 修改库存容量
     */
    private static void changeRepertoryNumber() {
        boolean success = login();
        if(!success)
            return;
        for (Brand brand : repertory) {
            System.out.println("请输入" + brand.getName() + "的剩余库存: ");
            int number = new Scanner(System.in).nextInt();
            brand.setSurplusStock(number);
        }
    }

    private static int jishu = 3;
    /**
     * 登录管理员密码之后才能修改库存信息,只能输入三次密码
     */
    private static boolean login() {
        if(jishu<=0){
            System.out.println("对不起,输入密码次数太多禁止登录,请联系管理员");
            return false;
        }
        System.out.println("请输入管理员的账号还有密码:");
        String id = new Scanner(System.in).next();
        String passwd = new Scanner(System.in).next();
        if("admin".equals(id)&&"admin".equals(passwd)){
            System.out.println("登录成功");
            return true;
        }else {
            System.out.println("登录失败");
            jishu--;
            return false;
        }
    }

    /**
     * 打印库存清单
     */
    private static void printList() {
        System.out.println("品牌     库存       单价          总价");
        for (Brand brand : repertory) {
            System.out.println(brand);
        }
    }

    private static int listOptions() {
        System.out.println("-------------库存管理------------");
        System.out.println("1.查看库存清单");
        System.out.println("2.修改商品库存数量");
        System.out.println("3.退出");
        try {
            return new Scanner(System.in).nextInt();
        }catch (Exception e){
            return 0;
        }

    }
}
