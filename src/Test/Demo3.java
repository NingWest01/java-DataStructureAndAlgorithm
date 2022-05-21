package Test;

public class Demo3 {
    public static void main(String[] args) {
        Per son = new Son();
        Son son1 = new Son();
        test(son1);
        test(son);
    }

    public static void test(Per per) {
        System.out.println("per");
    }

    public static void test(Son son) {
        System.out.println("son");
    }
}


class Per {
}

class Son extends Per {
}
