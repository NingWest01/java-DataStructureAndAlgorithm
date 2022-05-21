package DataStructure.stack;

/**
 * @author NingWest
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.showStack();
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.showStack();
        System.out.println();
        stack.push(123);
        stack.showStack();
    }
}

class Stack {
    int top = -1;
    Object[] data;

    public Stack(int lengths) {
        data = new Object[lengths];
    }

    public void push(Object datas) {
        if (top == data.length - 1) {
            System.out.println("栈满了");
            return;
        }
        top++;
        data[top] = datas;
    }

    public Object pop() {
        if (top == -1) {
            throw new RuntimeException("栈空了");
        }
        Object temp = data[top];
        data[top] = null;
        top--;
        return temp;
    }

    /**
     *  注意：遍历的顺序是从 栈顶 到 栈底
     */
    public void showStack() {
        if(top == -1){
            System.out.print("栈空了");
            return;
        }
        for (int i = data.length - 1; i >= 0; i--) {
            System.out.print(data[i]+" ");
        }
    }

}
