package mycode.day21;

/**
 * Created by ls on 17-7-10.
 */
public class Task_01 {
//    1.简述什么是异常、异常的继承体系？
//            2.简述异常的处理方式？
//            3.throw和throws关键字的使用位置和格式？
//            4.多个catch处理的注意事项？
//            5.简述finally关键字的特点和作用？
//            6.Throwable类的常见方法及方法描述？
//            7.自定义异常的格式？
    public static void main(String[] args){
//        funcation_1();
        funcation_2();
    }

    private static void funcation_2() {
        try {
            String str = null;
            str.length();
        }catch (Exception e){
            new MyException("我是刘双制造的异常").printStackTrace();
//            System.exit(1);
        }
        finally {
            System.out.println("执行了finally语句");
        }
    }

    private static void funcation_1() {
//        1.简述什么是异常、异常的继承体系？
        /**
         * 程序出现不可预料的错误  Throwable  Error Throwable
         */
        //            2.简述异常的处理方式？
        /**
         * try{
         *
         * }catch(Exception e){
         *
         * }finally{
         *
         * }
         */
        //3.throw和throws关键字的使用位置和格式？
        /**
         * throw用在方法体内
         * throws用在定义方法的时候
         */
        //4.多个catch处理的注意事项？
        /**
         * 先抓详细的catch,再抓大catch
         */
    }

    static class MyException extends Exception{
        public MyException(String message){
            super(message);
        }
    }
}
