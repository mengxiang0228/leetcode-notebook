package algorithm.code.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author lyx 
 * @date 2020年2月26日 下午4:14:54 
 *
 */
public class Q96 {
	
	@Test
	public final void numTreesTest() {
//		assertEquals(numTrees(2), 3);
		assertEquals(numTrees(3), 5);
	}
	
	/**
	 * 与元素本身无关，只与数组长度有关
	 * @param n
	 * @return
	 */
    public int numTrees(int n) {
    	int[] db = new int[n+1];// 存储i个元素的可能性
    	db[0] = 1;
    	db[1] = 1;
    	for (int i = 2; i <= n; i++) {// 当前元素个数
			for (int j = 1; j <= i; j++) {// 相当于一个滑块向右移动，一次移动一个元素，然后求左右两侧元素组合的可能性
				db[i] += db[i-j]*db[j-1]; //右侧 i-j个元素， 左侧 j-1个元素,则最后结果是左右可能性的积
			}
		}
		return db[n];

    }

}
