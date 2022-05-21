package Test;

public class Demo2 {
    public static void main(String[] args) {
        Dog g = new Dog("小花");
        test(g);
        System.out.println(g);
    }

    private static void test(Dog a) {
        a = new Dog("小花");
        System.out.println(a);
        a.setName("小花花");
    }
}
