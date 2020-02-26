package algorithm.code.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @author lyx 
 * @date 2020年2月26日 下午3:03:22 
 *
 */
public class Q198 {
	@Test
	public final void robTest() {
		assertEquals(rob(new int[] {1,2,3,1}), 4);
		assertEquals(rob(new int[] {2,7,9,3,1}), 12);
	}
	
	public int rob(int[] nums) {
		int[] db = new int[3];
		for (int i = 0; i < nums.length; i++) {
			db[2] = Math.max(db[0]+nums[i], db[1]);
			db[0] = db[1];
			db[1] = db[2];
		}
		return db[2];
    }
}
