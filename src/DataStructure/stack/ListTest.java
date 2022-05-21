package DataStructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@SuppressWarnings({"all"})
public class ListTest {
    public static void main(String[] args) {
        //(3+4)*5-6
        //30-2*3-2
        String str = "30 2 3 * - 2 -";
        //先转换为一个集合
        List<String> list = getList(str);
        String add = add(list);
        System.out.println(add);
    }

    private static String add(List<String> list) {
        int res = 0;
        String num1 = null;
        String num2 = null;
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {

                switch (s) {
                    case "+":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        res = Integer.parseInt(num1) + Integer.parseInt(num2);
                        stack.push(res + "");
                        break;
                    case "-":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        res = Integer.parseInt(num2) - Integer.parseInt(num1);
                        stack.push(res + "");
                        break;
                    case "*":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        res = Integer.parseInt(num2) * Integer.parseInt(num1);
                        stack.push(res + "");
                        break;
                    case "/":
                        num1 = stack.pop();
                        num2 = stack.pop();
                        res = Integer.parseInt(num1) / Integer.parseInt(num2);
                        stack.push(res + "");
                        break;
                    default:
                        System.out.println("......");
                }
            }
        }
        return stack.pop();
    }

    public static List<String> getList(String str) {
        String[] arr = str.split(" ");
        return new ArrayList<>(Arrays.asList(arr));
    }
}
