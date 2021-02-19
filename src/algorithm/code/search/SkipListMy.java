//package algorithm.code.search;
//
//
//import java.util.Random;
//
///**
// * 跳表实现
// * 0： 当前节点
// * @author liyaxiang
// * @since 2020/11/12 16:58
// */
//public class SkipListMy {
//    private static final int MAX_LENGTH = 21;
//    private Node head;
////    class Head {
////        private Node head;
////        private Node end;
////        private int size;
////        public Head(){
////            head = new Node(MAX_LENGTH);
////            end = null;
////            size = 0;
////        }
////
////        private void put(int value){
////            Node node = new Node(value);
////            Node start = this.head;
////            if(this.size == 0){
////
////            }
////
////
////            while (true){
////
////            }
////        }
////    }
//    class Node{
//        private int value;
//        private Node nextNode;//下一个节点
//        private Node[] forwards = null;// 记录跳表链表节点
//
//        public Node(int value) {
//            this.value = value;
//            forwards = new Node[getLayers()];// 获取当前节点层数
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public Node getSkipNode(int num){
//            return this.forwards[num];
//        }
//    }
//
//    private static Integer getLayers(){
//        Random random = new Random();
//        return random.nextInt(MAX_LENGTH);// 0-maxLength
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//
//    public static void put(Node head, Node valueNode){
//        if(head == null){
//            head = valueNode;
//            return;
//        }
//        Node start = head;
//        Node oldNode = null;
//        while (start != null){
//            if(){
//
//            }
//        }
//    }
//
//    public static void skip(Node now, Node skipNode, Node valueNode, int layer){
//        Node nextSkipNode = null;
//        if(layer == -1){// 不跳了，走
//            nextSkipNode = now.nextNode;
//            while (nextSkipNode != null){
//                if(nextSkipNode.getValue() > valueNode.getValue()){// 新增插到当前节点前面
//                    nextSkipNode.lastNode.nextNode = valueNode;
//                    valueNode.nextNode = nextSkipNode;
//                    return;
//                }else if(nextSkipNode.getValue() == valueNode.getValue()){// 重复值
//                    return;
//                }
//                nextSkipNode = now.nextNode;
//            }
//            // 最后节点
//            nextSkipNode = valueNode;
//        }
//        for (int i = layer-1; i > 0; i--) {
//            nextSkipNode = skipNode.forwards[i];
//            if(nextSkipNode == null){
//                continue;
//            }
//            if(nextSkipNode.getValue() > valueNode.getValue()){// 跳过了 // 下降一层继续跳
//
//                continue;
//            }else if(nextSkipNode.getValue() < valueNode.getValue()){// 没跳到
//                // 继续往下跳
//                skip(skipNode, nextSkipNode, valueNode, nextSkipNode.getLayer());
//            }else  {// 有重复值，不管他
//                return;
//            }
//        }
//    }
//
//}
//
