package Test;

public class NodeTest {
    public static void main(String[] args) {

    }
}
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
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
