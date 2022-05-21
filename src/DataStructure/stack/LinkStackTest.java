package DataStructure.stack;

/**
 * @author NingWest
 */
public class LinkStackTest {
    public static void main(String[] args) {
        Stack2 stack2 = new Stack2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        //反转后的新头节点
        Node head = stack2.reverseList(stack2.getHead());
        stack2.show(head);
        System.out.println("===================");
        Node node = stack2.reverseList(head);
        stack2.show(node);
        System.out.println("===========");
        Node pop = stack2.pop(node);
        Node pop1 = stack2.pop(node);
        Node pop2 = stack2.pop(node);
        System.out.println(pop);
        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println("=============");
        stack2.push(1);
        stack2.show(stack2.getHead());


    }
}

class Stack2 {
    Node temp = null;
    Node head = null;

    public Stack2() {
    }

    public Node getHead() {
        return head;
    }

    public Node pop(Node head) {
        Node popNode = null;
        //条件判断
        if (head == null) {
            throw new RuntimeException("栈为空~~~");
        }
        Node curr = head;
        while (curr != null){
            if(curr.next == null){
                //如果当前节点的下一个为空，就表明他没有下一个节点，他自己就该出栈了
                popNode = curr;
                //应为没有下一个了所以直接出循环
                break;
            }
            //如果当前节点的下一个的下一个节点为空，就表明当前节点的下一个节点为当前栈顶的节点，他该出栈
            if(curr.next.next == null){
                //先将他赋给一个新的引用
                popNode = curr.next;
                //将当前节点的下一个节点的引用置空，及出栈
                curr.next = null;
            }
            //指正后移
            curr = curr.next;
        }
        return popNode;
    }

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            //临时指针
            temp = head;
        } else {
            temp.next = new Node(data);
            //指针后移
            temp = temp.next;
        }
    }

    public void show(Node head) {
        if (head == null) {
            System.out.println("栈为空~~~");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode);
            currNode = currNode.next;
        }
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }


}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
