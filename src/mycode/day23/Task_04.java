package mycode.day23;

import java.io.*;
import java.util.*;

/**
 * Created by ls on 17-7-10.
 * 3.键盘输入10个数，放到数组中
 (1)去除该数组中大于10的数
 (2)将该数组中的数字写入到本地文件number.txt中
 */
public class Task_04 {
    public static void main(String[] args){
        receviceNumber();
    }

    private static void receviceNumber() {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Scanner(System.in).nextInt();
        }
        /**
         * 此时此刻正如彼时彼刻
         */
        int[] result = wipe10(nums);
        for (int i : result) {
            System.out.println(i);
        }

        writeNum(result);
    }

    private static void writeNum(int[] result) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : result) {
            list.add(i);
        }
        OutputStreamWriter ous = null;
        File file = new File("/home/ls/number.txt");
        if(!file.exists()){
            try {
                boolean ok = file.createNewFile();
                System.out.println("创建"+file.getAbsolutePath()+"  "+ok);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ous = new FileWriter(file);
            ous.write(list.toString());
            ous.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int[] wipe10(int[] nums) {
        int[] result = null;
        int size = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=10){
                size++;
                set.add(i);
            }
        }
        result = new int[size];
        Iterator<Integer> iterator = set.iterator();
        for(int i = 0;i<size;i++){
            result[i] = nums[iterator.next()];
        }
        return result;
    }
}
