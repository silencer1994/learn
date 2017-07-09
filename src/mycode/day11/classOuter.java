package mycode.day11;

class Outer {
    private static int num =31;
    void show(){
        new Inner().show();
    }
    class Inner //内部类。
    {
        void show() {
            System.out.println("show run..." + num);
        }
    }
    public static void main(String[] args){
        new Outer().show();
    }
}