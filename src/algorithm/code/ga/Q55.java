package algorithm.code.ga;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 55. 跳跃游戏
 * 
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。
 * @author lyx 
 * @date 2020年3月3日 上午10:48:48 
 *
 */
public class Q55 {

	@Test
	public final void canJumpTest() {
		assertEquals(canJump(new int[] {2,3,1,1,4}), true);
		assertEquals(canJump(new int[] {3,2,1,0,4}), false);
		assertEquals(canJump(new int[] {3,2,1,1,0}), true);
		assertEquals(canJump(new int[] {2,0}), true);
		assertEquals(canJump(new int[] {2, 0, 0}), true);
	}
	
	/**
	 * 描线法,把每个位置当做一点，按每个位置可以跳跃的格数划线，如果这条线可以覆盖所有格，则可以到达最后
	 * @param nums
	 * @return
	 */
	public boolean canJump1(int[] nums) {
		int length = nums.length;
		boolean[] dp = new boolean[length];
		dp[0] = true;
		for (int i = 0; i < nums.length-1; i++) {
//			System.out.println("nums[i]:"+nums[i]);
			if(dp[i] == false) {
				return false;
			}
			int num = 1;
			while (num <= nums[i]) { 
//				System.out.println(num +", i+num:"+(i+num)+", nums:"+nums[i+num]);
				if(i+num >= length-1) {
					// 当线到达最后格时，既可以认为 成功
					return true;
				}
				if(num == nums[i] && nums[i+num] == 0) {
					// 当前格时i位置跳跃的最远位置，并且这个位置跳跃数是0，则
					break;
				}
				dp[i+num] = true;
				num++;
			}
//			System.out.println(Arrays.toString(dp));
		}
		return dp[length-1];
    }
	
	/**
	 * 算个贪心算法，有个指针一直往前,根据最大步数往前走， 判断指针是否能到头，或者指针到了某个位置时动不了了
	 * @param nums
	 * @return
	 */
	public boolean canJump2(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			if(num < i) {
				return false;
			}
			num = Math.max(num, i+nums[i]);
		}
		return true;
    }
	
	/**
	 * 自顶向下， 寻找0位置，找到后判断前面的值能否跳过0位置能跳过这可以到达末尾
	 * 原因：如果所有位置步数都大于0，则必定可以到达末尾。如果有0就要判断能不能跳过去
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int num = -1;
		for (int i = nums.length-2; i >= 0; i--) {
			if(nums[i] == 0 && i > num){
				num = i;
//				System.out.println("有0位置");
				continue;
			}
			if(num > 0 && nums[i]+i > num) {
				num = -1;
			}
//			System.out.println("num:"+num);
		}
		return num < 0;
	}
}
