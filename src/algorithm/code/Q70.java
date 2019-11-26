package algorithm.code;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯，需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶，你有多少种不同的方法可以爬到楼顶呢？
 * @author lyx 
 * @date 2019年11月26日 下午2:18:45 
 *
 */
public class Q70 {

	@Test // 暴力破解
	public void test() {
		assertEquals(climbStairs(3), 3);
		assertEquals(climbStairs(24), 75025);
	}
	@Test // 记忆方法
	public void testClimbStairs1() {
		assertEquals(climbStairs1(3), 3);
		assertEquals(climbStairs1(24), 75025);
	}
	@Test // 斐波那契
	public void testClimbStairs4() {
		assertEquals(climbStairs4(3), 3);
		assertEquals(climbStairs4(24), 75025);
	}
	
	/**
	 * 暴力方法破解，时间会超
	 * @param n
	 * @return
	 */
	 public int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}
		int count = climbStairs(n-1)+climbStairs(n-2);
		return count;
	 }
	 
	 /**
	 *  记忆方法
	 * @param n
	 * @return
	 */
	 public int climbStairs1(int n) {
		int[] memo = new int[n+1];
		 
		return climbStairs1_Sun(n, memo);
	 }
	 
	 /**
	 *  记忆方法 递归部分(会超时)
	 * @param n
	 * @return
	 */
	 public int climbStairs1_Sun(int n, int[] memo) {
		if(n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}
		if(memo[n] > 0) {
			return memo[n];
		}
		memo[n] = climbStairs1_Sun(n-1, memo)+climbStairs1_Sun(n-2, memo);
		return memo[n];
	 }
	 
	 /**
	  *  方法四：斐波那契数
	  * @param n
	  * @return
	  */
	 public int climbStairs4(int n) {
		if(n <= 2) {
			 return n;
		}
		int a = 1;
		int b = 2;
		for (int i = 3; i <= n; i++) {
			int res  = a + b;
			a = b;
			b = res;
			
		}
		return b;
	 }
	 
}
