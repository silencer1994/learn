package mycode.day25;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ls on 17-7-13.
 * 1.用代码实现以下需求
 (1)定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,生成空参有参构造,set和get方法,toString方法
 (2)键盘录入6个学员信息(录入格式:张三,男,25),要求有两个相同的信息,将6个学员信息存入到ArrayList集合中
 (3)将存有6个学员信息的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
 (4)读取D:\\StudentInfo.txt文件中的ArrayList对象
 (5)对ArrayList集合中的6个学生对象进行去重并按照年龄从小到大的顺序排序
 (6)将ArrayList集合中排序后的结果利用PrintWriter流写入到E:\\StudentInfo.txt文件中(写入格式：张三-男-25)
 */
public class Task_01 {
    public static void main(String[] args){
        getSixStudent();
    }

    private static void getSixStudent() {
        List<Student> slist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//            System.out.println("请输入学员姓名: ");
//            String name = new Scanner(System.in).next();
//            System.out.println("请输入学员性别: ");
//            String gender = new Scanner(System.in).next();
//            System.out.println("请输入学员年龄: ");
//            int age = new Scanner(System.in).nextInt();
            System.out.println("请输入学员信息: 例如:张三,男,25");
            String studentInfo = new Scanner(System.in).nextLine();
            String[] splits = studentInfo.split(",");
//            String
            Student student = new Student(splits[0],splits[1],Integer.valueOf(splits[2]));
            slist.add(student);
        }
        String toFileName = "/home/ls/test/StudentInfo.txt";
        recordInfo(slist,toFileName);
        readInfo(toFileName);
        PrintWriter printWriter = null;
        try {
             printWriter = new PrintWriter(new FileOutputStream(toFileName,true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Student student : uniqSort(slist)) {
            printWriter.println(student);
            printWriter.flush();
        }
        printWriter.close();
    }

    /**
     * 去重排序
     * @param slist
     */
    private static List<Student> uniqSort(List<Student> slist) {
        ArrayList<Student> uniqList = new ArrayList<>();
        for (Student student : slist) {
            boolean hasStudent = false;
            for (int i = 0; i < uniqList.size(); i++) {
                if(student.getName().equals(uniqList.get(i).getName())){
                    hasStudent = true;
                    break;
                }
            }
            if(!hasStudent){
                uniqList.add(student);
            }
        }
        return uniqList;
    }

    private static void readInfo(String toFileName) {
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(toFileName));
            String info = null;
            int count = 0;
            while ((info=fileReader.readLine())!=null){
                System.out.println(info+"      "+(++count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 记录学员信息
     * @param slist
     */
    private static void recordInfo(List<Student> slist,String toFileName) {
        FileWriter fileWriter = null;
        File toFile = new File(toFileName);
        if(!toFile.exists()){
            File parent = new File(toFile.getParent());
            if(!parent.exists()){
                boolean creatParentFile = parent.mkdirs();
                System.out.println("创建父文件夹成功");
            }
            try {
                toFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(toFile);
            Iterator<Student> iterator = slist.iterator();
            while (iterator.hasNext()){
                fileWriter.write(iterator.next().toString());
                fileWriter.write("\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
