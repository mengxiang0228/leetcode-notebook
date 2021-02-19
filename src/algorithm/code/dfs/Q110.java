package algorithm.code.dfs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 110. 平衡二叉树(红黑树是平衡二叉树)
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * @author lyx 
 * @date 2020年3月9日 下午3:47:39 
 *
 */
public class Q110 {

	@Test
	public void isBalancedTest() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		assertEquals(isBalanced1(root), true);
	}
	
	/**
	 * 自顶向下递归
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		if(Math.abs(height(root.left)-height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
    }
	
	private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	/**
	 * 自底向上
	 * @param root
	 * @return
	 */
	public boolean isBalanced1(TreeNode root) {
		if(root == null){
			return true;
		}
		TreeInfo treeInfo = isBanlanceHelper(root);
		return treeInfo.balance;
    }
	
	private TreeInfo isBanlanceHelper(TreeNode root) {
		if(root == null) {
			return new TreeInfo(-1, true);
		}
		TreeInfo left = isBanlanceHelper(root.left);
		TreeInfo right = isBanlanceHelper(root.right);
		if(!left.balance || !right.balance) {
			return new TreeInfo(-1, false);
		}
		if(Math.abs(left.height - right.height) < 2) {
			return new TreeInfo(Math.max(left.height, right.height) + 1, true);
		}
		return new TreeInfo(-1, false);
	}
	
	class TreeInfo{
		public int height;
		public boolean balance;
		
		public TreeInfo(int height, boolean balance) {
			this.height = height;
			this.balance = balance;
		}
	}
	
}
