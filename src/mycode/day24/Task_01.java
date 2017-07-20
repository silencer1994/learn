package mycode.day24;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ls on 17-7-13.
 * 2. 用代码实现以下需求
 (1)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
 (2)打印格式：
 to=3
 think=1
 you=2
 //........
 (3)按照上面的打印格式将内容写入到D:\\count.txt文件中(要求用高效流)
 */
public class Task_01 {
    public static void main(String[] args){
        funcation_01();
    }

    private static void funcation_01() {
        String source = "If you want to change your fate I think you must come to the dark horse to learn java";
        String[] splits = source.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String split : splits) {
            if(map.get(split)==null)
                map.put(split, 1);
            else
                map.put(split, map.get(split) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
            stringBuilder.append(stringIntegerEntry.getKey() + "=" + stringIntegerEntry.getValue() + "\n");
        }
        String result = stringBuilder.toString();
        writeToCount(map);
    }
    //按照上面的打印格式将内容写入到D:\\count.txt文件中(要求用高效流)
    private static void writeToCount(HashMap<String,Integer> result) {
//        FileReader fileReader = null;
            FileWriter writer = null;
//        fileReader = new FileReader();
        try {
            writer = new FileWriter("/home/ls/test/count.txt");
            //读取一行数据并写入
            for (Map.Entry<String, Integer> stringIntegerEntry : result.entrySet()) {
                writer.write(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue()+"\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
