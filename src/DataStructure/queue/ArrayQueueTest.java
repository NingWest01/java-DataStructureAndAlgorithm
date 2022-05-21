package DataStructure.queue;

import java.util.Scanner;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean flag = true;
        while (flag) {
            System.out.println("s 显示队列");
            System.out.println("e 退出程序");
            System.out.println("a 添加数据");
            System.out.println("g 取出数据");
            System.out.println("h 头数据");
            Scanner input = new Scanner(System.in);
            System.out.print("选择你的操作：");
            String s = input.nextLine();
            switch (s) {
                case "s":
                    arrayQueue.showQueue();
                    break;
                case "e":
                    flag = false;
                    break;
                case "a":
                    input = new Scanner(System.in);
                    String s1 = input.nextLine();
                    arrayQueue.addQueue(Integer.parseInt(s1));
                    break;
                case "g":
                    try {
                        System.out.println(arrayQueue.getQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("===================");
                    break;
                case "h":
                    try {
                        System.out.println(arrayQueue.headQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("==================");
                    break;
                default:
                    System.out.println("尽请期待~~功能开发");
            }
        }
    }
}

class ArrayQueue {
    /**
     * 模拟队列的最大值
     */
    private int maxSize;
    /**
     * 模拟队列的头
     */
    private int front;
    /**
     * 模拟队列的尾
     */
    private int rear;
    /**
     * 存放数据的主体
     */
    private int[] arr;

    /**
     * 初始对立构造器
     *
     * @param maxSize 最大容量
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头的前一个位置
        front = -1;
        //指向队列尾部的数据(即就是队列最后一个数据)
        rear = -1;
    }

    /**
     * 判断队列是否满
     *
     * @return 判断值
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return 判断值
     */
    public boolean isEmpty() {
        return rear == -1;
    }

    /**
     * 进入队列的方法
     *
     * @param num 进入队列的数据
     */
    public void addQueue(int num) {
        if (!(isFull())) {
            rear++;
            //添加数据
            arr[rear] = num;
        } else {
            System.out.println("不能再加入数据");
        }
    }

    /**
     * 获取队列数据
     */
    public int getQueue() {
        if (!(isEmpty())) {
            front++;
            if (front == maxSize) {
                rear = -1;
                front = -1;
                throw new RuntimeException("队列为空");
            }
            int temp = arr[front];
            arr[front] = 0;
            return temp;
        } else {
            throw new RuntimeException("队列为空");
        }

    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d] = %d\n", i, arr[i]);
            }
            System.out.println("=======================");
        }

    }

    /**
     * 显示头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("没有数据");
        }
        return arr[front + 1];
    }
}

