package DataStructure.linkedlist;

/**
 * @author NingWest
 */
public class OneWayCircularLinkedList {
    public static void main(String[] args) {
        BoyNodeList boyNodeList = new BoyNodeList();
        boyNodeList.add(5);
        boyNodeList.showNode();
        System.out.println("=======================");
        boyNodeList.countBoy(1,2,5);
    }
}

class BoyNodeList {
    BoyNode first = null;


    /**
     * 约瑟夫问题解决
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入数据有误");
            return;
        }
        //先定义一个辅助节点，帮助小孩出圈
        BoyNode helper = first;
        //再定义一个新的指针引用，应为当前的辅助指针在first，所以要指向它的前一个
        while (helper.getNext() != first) {
            // helper向后移动一位
            helper = helper.getNext();
        }
        //小孩报数之前，先让它到达指定位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //让 first 和 helper指针同时移动  countNum - 1 次，然后出圈
        while (true) {
            if (first == helper) {
                System.out.println("最后一个小孩："+first);
                break;
            }
            //让first和helper移动指定的次数
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            //先保存first的下一个元素
            BoyNode next = first.getNext();
            //让helper的下一个执行first的下一个
            helper.setNext(first.getNext());
            //重新让first的后一个指向它
            first = next;
        }
    }

    /**
     * 添加节点
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("数据不合法");
            return;
        }
        //设置辅助节点，来指向当前节点
        BoyNode currNode = null;
        for (int i = 1; i <= nums; i++) {
            //来创建节点
            BoyNode boyNode = new BoyNode(i);
            //判断是否为第一个节点
            if (i == 1) {
                //如果是第一个就将它赋值给 first
                first = boyNode;
                //让它自己的下一个执行自己
                first.setNext(first);
                //让辅助节点指向这个first，用来标记当前节点
                currNode = first;
            } else {
                //让当前节点的下一个节点，指向新的节点
                currNode.setNext(boyNode);
                //让新的节点的下一个指向新的节点
                boyNode.setNext(first);
                //将当前节点向后动一位
                currNode = boyNode;
            }
        }
    }

    public void showNode() {
        //先判断链表是否为空
        if (first == null) {
            System.out.println("没有加入数据");
            return;
        }
        //辅助节点，指定当前节点的位置
        BoyNode currNode = first;
        while (true) {
            //获取当前节点的下一个节点，判断是否为第一个节点
            if (currNode.getNext() == first) {
                System.out.println(currNode);
                return;
            } else {
                System.out.println(currNode);
                //让当前辅助节点，指向下一个节点，指针后移
                currNode = currNode.getNext();
            }

        }

    }

}

class BoyNode {
    private int no;
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public BoyNode() {
    }

    public BoyNode(int no, BoyNode next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}
