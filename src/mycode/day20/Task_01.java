package mycode.day20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ls on 17-7-10.
 * 1.分析以下需求，并用代码实现：
 (1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
 (2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
 (3)利用四种方式遍历Map集合中的内容，格式：key::value
 */
public class Task_01 {
    private static Map<String, Student> map = new HashMap<>();

    public static void main(String[] args){
        funcation_1();
        funcation_2();
        funcation_3();
        funcation_4();
        funcation_5();
    }

    private static void funcation_5() {
        Iterator<Map.Entry<String, Student>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Student> entity = iterator.next();
            Student student = entity.getValue();
            System.out.println(student.getName()+":5:"+student.getAge());
        }
    }

    private static void funcation_4() {
        for (Map.Entry<String, Student> stringStudentEntry : map.entrySet()) {
            Student student = stringStudentEntry.getValue();
            System.out.println(student.getName()+":4:"+student.getAge());
        }
    }

    private static void funcation_3() {
        for (Student student : map.values()) {
            System.out.println(student.getName()+":3:"+student.getAge());
        }
    }

    private static void funcation_2() {
        for (String s : map.keySet()) {
            System.out.println(s+":2:"+map.get(s).getAge());
        }
    }

    private static void funcation_1() {
        map.put("张三", new Student("张三",20));
        map.put("李四", new Student("李四",22));
        map.put("王五", new Student("王五",19));
        map.put("刘双", new Student("刘双",23));
    }
}
