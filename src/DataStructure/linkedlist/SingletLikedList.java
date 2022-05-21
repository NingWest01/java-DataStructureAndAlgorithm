package DataStructure.linkedlist;

import java.util.Stack;

public class SingletLikedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "有用", "智多星");
        HeroNode hero5 = new HeroNode(5, "刘秀", "拼命三郎");
        //HeroNode hero5 = new HeroNode(5, "有用", "智多星");
        SingletLiked singletLiked1 = new SingletLiked();
        SingletLiked singletLiked2 = new SingletLiked();
        singletLiked1.addByOrder(hero3);
        singletLiked1.addByOrder(hero1);
        singletLiked2.addByOrder(hero2);
        singletLiked2.addByOrder(hero4);
        singletLiked1.addByOrder(hero5);
        SingletLiked.list(singletLiked1.getHead());

        System.out.println("=================");
        /*System.out.println("======================");
        SingletLiked.list(singletLiked2.getHead());
        System.out.println("======================");
        HeroNode orderly = SingletLiked.orderly(singletLiked1.getHead(), singletLiked2.getHead());
        SingletLiked.list(orderly);*/
        //HeroNode node = SingletLiked.getNode(singletLiked.getHead(), 1);
        //SingletLiked.list(singletLiked.getHead());
        //SingletLiked.stack(singletLiked.getHead());
        //SingletLiked.reverser(singletLiked.getHead());
        //SingletLiked.list(singletLiked.getHead());
        //System.out.println(node);
        //singletLiked1.delete(hero5);
        //System.out.println("该链表一共有：" + SingletLiked.length(singletLiked.getHead()) + "节点");
        //singletLiked.update(hero4);

    }

}

class SingletLiked {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 添加节点
     *
     * @param heroNode 要添加的节点
     */
    public void add(HeroNode heroNode) {
        //临时的节点变量 作为指向引用 指向头节点
        HeroNode temp = head;
        //找到最后一个节点的位置
        while (temp.next != null) {
            temp = temp.next;
        }
        //将添加的新节点 放到链表最后
        temp.next = heroNode;
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     */
    public static HeroNode orderly(HeroNode head1, HeroNode head2) {
        if (head1.next == null && head2.next == null) {
            return null;
        }
        //定义总链表来存储最新的有序链表
        HeroNode heroNode = new HeroNode(0,"","");
        //定义临时节点
        HeroNode tmp = heroNode;
        //定义头一的临时链表
        HeroNode l1 = head1.next;
        //定义头二的临时链表
        HeroNode l2 = head2.next;
        //当两个链表都不为空的时候
        while (l1 != null && l2 != null){
            //当l1大的时候
            if(l1.no > l2.no){
                //让一个临时节点来当指针，指向，正再添加的位置，防止出现问题
                tmp.next = l2;
                //将这个
                l2 = l2.next;
                tmp = tmp.next;
            }else{
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }
        }
        //当l1为空的时候，应为链表有序，直接将它加到链表的最后
        if(l1 == null){
            tmp.next = l2;
        }else{
            tmp.next = l1;
        }
        //为什么要返回它，不能返回操作的节点,应为它只有最后一个
        return heroNode;
    }

    /**
     * 使用栈的方式 对链表进行反转打印
     */
    public static void stack(HeroNode head) {
        //判断是否为空
        if (head.next == null) {
            return;
        }
        //创建一个栈集合
        Stack<HeroNode> stack = new Stack<>();
        HeroNode tmp = head.next;
        while (tmp != null) {
            //将链表的每一个节点入栈
            stack.add(tmp);
            tmp = tmp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 单链表反转 反转
     */
    public static void reverser(HeroNode head){
        //判断输入数据的正确性
        if(head.next == null || head.next.next == null){
            return;
        }
        //辅助指针来遍历节点
        HeroNode cur = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur != null){
            //取到当前节点的后一个节点，应为有用
            next = cur.next;
            //让当前的节点指向反转链表的第一个节点 引用指向
            cur.next = reverseHead.next;
            //给新链表的next赋值为cur的当前值
            reverseHead.next = cur;
            //节点后移
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 查询单链表中的倒数第k个节点[新浪面试题]
     * 思路 ：先得到链表的总长度 length方法
     * 总长度 - index 这获得的是需要的前一个节点
     */
    public static HeroNode getNode(HeroNode head, int index) {
        //判断输入数据是否合理
        if (head.next == null || index < 0) {
            return null;
        }
        //获得链表的总长度
        int length = SingletLiked.length(head);
        //
        int i = length - index;
        if (i == 0) {
            return head.next;
        }
        HeroNode tmp = head.next;
        int k = 1;
        while (tmp.next != null) {
            if (k == i) {
                return tmp.next;
            }
            k++;
            tmp = tmp.next;
        }
        return null;
    }

    /**
     * 得到链表的长度
     */
    public static int length(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode heroNode = head.next;
        int i = 0;
        while (heroNode != null) {
            i++;
            heroNode = heroNode.next;
        }
        return i;
    }

    /**
     * 删除节点
     */
    public void delete(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //定义临时结点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //如果 temp 为空了证明 到最后了
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                //证明有该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据 flag 判断是否找到
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有该节点的no,不能删除");
        }
    }

    /**
     * 修改链表数据
     */
    public void update(HeroNode heroNode) {
        //判断节点是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //定义辅助节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            //节点后移
            temp = temp.next;
        }
        if (flag) {
            //flag 为 true 即找到节点 ，让它替换原来的节点
            temp.name = heroNode.name;
        } else {
            System.out.println("不能修改，没有对应的位置");
        }
    }

    /**
     * 顺序排列
     */
    public void addByOrder(HeroNode heroNode) {
        //创建一个临时的节点
        HeroNode temp = head;
        //判断添加的数据是否已在链表中
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明链表为空
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //节点后移
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("%d -" + heroNode.name + "已经存在\n", heroNode.no);
        } else {
            //先将原先节点的后节点给这个接待您，防止节点丢失
            heroNode.next = temp.next;
            //让节点放在指定位置
            temp.next = heroNode;
        }
    }

    /**
     * 显示链表
     */
    public static void list(HeroNode head) {
        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头不算，因为没数据
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            //后移，不然为死循环
            temp = temp.next;
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}