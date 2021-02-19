package algorithm.code.bfs;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import algorithm.code.dfs.TreeNode;

public class Q101 {
	
	@Test
	public final void maxDepthTest() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		assertEquals(isSymmetric1(root), true);
	}
	
	/**
	 * 递归算法
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root.left, root.right);
    }
	
	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return true;
		}
		if(t1 == null || t2 == null) {
			return false;
		}
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}
	
	/**
	 * 迭代 BFS
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) {
		Queue<TreeNode> stock = new LinkedList<>();
		stock.add(root);
		stock.add(root);
		while (!stock.isEmpty()) {
			TreeNode t1 = stock.poll();
			TreeNode t2 = stock.poll();
			if(t1 == null && t2 == null) {
				continue;
			}
			if(t1 == null || t2 == null) {
				return false;
			}
			
			if(t1.val != t2.val) {
				return false;
			}
			stock.add(t1.left);
			stock.add(t2.right);
			stock.add(t1.right);
			stock.add(t2.left);
		}
		return true;
    }
	
}
