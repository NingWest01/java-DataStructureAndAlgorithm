package DataStructure.stack;

/**
 * @author NingWest
 */
public class Calculator {
    public static void main(String[] args) {
        String str = "30-2*3-2";
        Stack1 numStack = new Stack1(10);
        Stack1 charStack = new Stack1(10);
        //索引
        int index = 0;
        //第一个数
        int num1 = 0;
        //第二个数
        int num2 = 0;
        //符号
        int oper = 0;
        //结果
        int res = 0;
        char ch = ' ';
        //临时拼接字符串
        String keepNum = "";
        while (true) {
            //一个一个取出字符串中的字符
            ch = str.substring(index, index + 1).charAt(0);
            //如果是字符
            if (charStack.isOper(ch)) {
                if (charStack.top != -1) {
                    //如果当前符号栈有操作符，就进行比较，如果当前操作符优先级小于或等于栈中的操作符，就需要从数栈中pop出两个数
                    //在从符号栈中pop出一个符号，进行运算，将得到的结果入数栈，然后将当前的符号入符号栈
                    if (charStack.priority(ch) <= charStack.priority(charStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = charStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //运算的结果入数栈
                        numStack.push(res);
                        //把当前符号入符号栈
                        charStack.push(ch);

                    } else {
                        //当前的操作符，优先级大于栈中的优先级，直接入符号栈
                        charStack.push(ch);
                    }
                } else {
                    //如果为空，直接入符号栈
                    if(ch == '-'){
                        charStack.push('+');
                    }
                    charStack.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == str.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //多位数运算
                    if (charStack.isOper(str.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum置空
                        keepNum = "";
                    }
                }

            }
            //索引后移
            index++;
            if (index >= str.length()) {
                break;
            }
        }
        while (true) {
            if (charStack.top == -1) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = charStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(numStack.pop());
    }
}

class Stack1 {
    int top = -1;
    int[] data;

    public Stack1(int lengths) {
        data = new int[lengths];
    }

    public int peek() {
        return data[top];
    }

    public void push(int datas) {
        if (top == data.length - 1) {
            System.out.println("栈满了");
            return;
        }
        top++;
        data[top] = datas;
    }

    public int pop() {
        if (top == -1) {
            throw new RuntimeException("栈空了");
        }
        int temp = data[top];
        data[top] = 0;
        top--;
        return temp;
    }

    /**
     * 注意：遍历的顺序是从 栈顶 到 栈底
     */
    public void showStack() {
        if (top == -1) {
            System.out.print("栈空了");
            return;
        }
        for (int i = data.length - 1; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
    }

    /**
     * 判断优先级
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是一个运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算获取结果
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                System.out.println("意外错误");
        }
        return res;
    }


}
