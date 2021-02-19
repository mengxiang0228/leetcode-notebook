package algorithm.code.search;


import java.util.Random;

/**
 * @author liyaxiang
 * @since 2021/1/8 11:30
 */
public class SkipListMy1 {
    private static final int MAX_LEVEL = 16;    // 结点的个数

    private int levelCount = 1;   // 索引的层级数

    private Node head = new Node();    // 头结点

    private Random random = new Random();

    // Node内部类
    public class Node{
        private int data = -1;
        private Node next[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        // 重写toString方法
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append("; leves: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public Node find(int value){
        Node p = head;
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.next[i] != null && p.next[i].data < value){
                p = p.next[i];
            }
        }
        if(p.next[0] != null && p.next[0].data == value){
            return p.next[0];    // 找到，则返回原始链表中的结点
        }else{
            return null;
        }
    }

    // 插入操作
    public void insert(int value){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];
        for(int i = 0; i < level; ++i){
            // 元素所有索引指向head
            update[i] = head;
        }
        Node p = head;
        for (int i = level-1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].data < value){

                p = p.next[i];
            }
            // 当前值的上一个节点
            update[i] = p;
        }
        for(int i = 0; i < level; ++i){
            // 在前后节点之间插入新值
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
        if(levelCount < level){
            // 存储最高层级
            levelCount = level;
        }

    }

    // 随机函数
    private int randomLevel(){
        int level = 1;
        for(int i = 1; i < MAX_LEVEL; ++i){
            if(random.nextInt() % 2 == 1){
                level++;
            }
        }

        return level;
    }

    // 显示跳表中的结点
    public void display(){
        Node p = head;
        while(p.next[0] != null){
            System.out.println(p.next[0] + " ");
            p = p.next[0];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SkipListMy1 skipListMy1  = new SkipListMy1();
        skipListMy1.insert(1);
        skipListMy1.insert(2);
        skipListMy1.insert(9);
        skipListMy1.insert(5);
        skipListMy1.insert(7);
        skipListMy1.display();
        System.out.println(skipListMy1.head + " ");
    }

}
