package algorithm.code.dfs;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 * @author lyx 
 * @date 2020年3月3日 下午4:34:35 
 *
 */
public class Q104 {
	
	@Test
	public final void maxDepthTest() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		assertEquals(maxDepth1(root), 3);
	}
	
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return Math.max(leftHeight, rightHeight)+1;
    }
	
	/**
	 * BFS 广度优先搜索
	 * BFS的层次遍历思想，记录二叉树的层数，
     * 遍历完，层数即为最大深度
	 * @param root
	 * @return
	 */
	
	public int maxDepth1(TreeNode root) {
		Queue<Tuple<TreeNode, Integer>> stack = new LinkedList<>();// 队列
		if(root!= null) {
			stack.add(new Tuple<TreeNode, Integer>(root, 1));
		}
		int depth = 0;
		while (!stack.isEmpty()) {
			Tuple<TreeNode, Integer> current = stack.poll(); //出栈
			root = current.getVal1();
			int currentDepth = current.getVal2();
			System.out.println("当前深度:"+currentDepth);
			if(root != null) {
				depth = Math.max(depth, currentDepth);
				System.out.println(depth);
				stack.add(new Tuple<TreeNode, Integer>(root.left, currentDepth+1));
				stack.add(new Tuple<TreeNode, Integer>(root.right, currentDepth+1));
			}
		}
		return depth;
    }
	
	public class Tuple<A, B> {
		
		private final A first;
		private final B second;
		
	    public Tuple(A a, B b){
	        first = a;
	        second = b;
	    }

	    public A getVal1() {
	    	return first;
	    }
	    
	    public B getVal2() {
	    	return second;
	    }
	    
	    @Override
	    public String toString(){
	        return "(" + first + ", " + second + ")";
	    }

	}
}


