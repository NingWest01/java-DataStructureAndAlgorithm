package Test;

import org.junit.Test;

public class Demo {
    @Test
    public void test1(){
        int[] arr = {1,2,3};
        String str = String.format("%d-%d-%d", arr[0], arr[1], arr[2]);
        System.out.println(str);
    }
}
