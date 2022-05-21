package DataStructure.linkedlist;

/**
 * @author NingWest  双向链表
 */
public class BidirectionalLinkedList {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "有用", "智多星");
        HeroNode2 hero5 = new HeroNode2(5, "刘秀", "拼命三郎");

        BidirectionalNode node = new BidirectionalNode();
        node.addByOrder(hero1);
        node.addByOrder(hero4);
        node.addByOrder(hero3);
        node.addByOrder(hero2);
        node.addByOrder(hero5);
        node.list();

        /*System.out.println("添加链表==========");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");
        node.add(hero6);
        node.list();
        System.out.println("修改===============");
        hero3 = new HeroNode2(3, "有没有吴用", "智多星");
        node.update(hero3);
        node.list();
        System.out.println("链表删除==============");
        node.delete(hero3);
        node.list();*/
    }
}

class BidirectionalNode {

    /**
     * 设置头节点
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 获得头节点
     */
    public HeroNode2 getHead() {
        return head;
    }
    /**
     * 按照顺序添加节点
     */
    public void addByOrder(HeroNode2 heroNode) {
        //创建一个临时的节点
        HeroNode2 temp = head;
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
            //
            heroNode.next = temp.next;
            if(temp.next != null){
                temp.next.prev = heroNode;
            }
            temp.next = heroNode;
            heroNode.prev = temp;

        }
    }

    /**
     * 删除节点
     */
    public void delete(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //定义临时结点
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            //如果 temp 为空了证明 到最后了
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                //证明有该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据 flag 判断是否找到
        if (flag) {
            temp.prev.next = temp.next;
            //如果要删除的是最后一个节点，会有问题，空指针的问题，所以要判断
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        } else {
            System.out.println("没有该节点的no,不能删除");
        }
    }

    /**
     * 修改链表数据
     */
    public void update(HeroNode2 heroNode) {
        //判断节点是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //定义辅助节点
        HeroNode2 temp = head.next;
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
     * 双向链表的添加
     */
    public void add(HeroNode2 heroNode) {
        //临时的节点变量 作为指向引用 指向头节点
        HeroNode2 temp = head;
        //找到最后一个节点的位置
        while (temp.next != null) {
            temp = temp.next;
        }
        //形成一个双向链表  让最后一个链表的下一个指向新添加的链表
        temp.next = heroNode;
        //将新添加的链表的前一个指向，当前链表的最后一个
        heroNode.prev = temp;
    }

    /**
     * 显示链表
     */
    public void list() {
        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头不算，因为没数据
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            //后移，不然为死循环
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    /**
     * 指向前端的节点
     */
    public HeroNode2 prev;
    /**
     * 指向后端端的节点
     */
    public HeroNode2 next;
    /**
     * 序号
     */
    public int no;
    /**
     * 名称
     */
    public String name;
    /**
     * 昵称
     */
    public String nickName;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}