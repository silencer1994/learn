package mycode.day03;

/**
 * Created by ls on 17-7-3.
 * 10.我国最高山峰是珠穆朗玛峰，8848米。现在我有一张足够大的纸，它的厚度是0.01米。请问，我折叠多少次，可以折成珠穆朗玛峰的高度。
 */
public class Task4 {
    public static void main(String[] args){
//        flodToMeter(0.01f,8848f);
//        blackCode();
    }

    private static void blackCode() {
        double paperThick = 0.01;
        int count = 0;
        while (true){
            if (paperThick < 8848.0){
                count++;
                paperThick = paperThick * 2.0;
                System.out.println("第"+count+"次折"+paperThick+"M");
            }else{
                break;
            }
        }
        System.out.println("一共能折"+count+"次");
    }

    private static void flodToMeter(float step,float high) {
        float actualHigh = step;
        int count = 1;
        while(true){
            actualHigh += actualHigh;
            if(actualHigh>=high){
                System.out.println("第"+count+"次折叠到达"+actualHigh+"米!");
                break ;
            }
            count++;
        }
    }
}
