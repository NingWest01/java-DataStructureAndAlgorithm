package DataStructure.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        System.out.println(queue.poll());
    }
}
