package algorithm.code;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * @author lyx 
 * @date 2020年2月13日 下午4:36:42 
 *
 */
public class Q54 {
	
	@Test
	public final void maxSubArrayTest() {
		int [] arr = null;
		arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(maxSubArray(arr), 6);
	}
	
	@Test
	public final void maxSubArray1Test() {
		int [] arr = null;
		arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(maxSubArray1(arr), 6);
	}
	
	/**
	 * 动态规划算法
	 * 
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	int maxValue = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1] > 0) {
				// 前一个值是负数，则两数相加的值一定比当前值小，不用考虑
				nums[i] += nums[i-1];
			}
			maxValue = Math.max(maxValue, nums[i]);
		}
    	
    	
		return maxValue;
        
    }
    
    /**
     * 贪心算法
     * 使用单个数组作为输入来查找最大（或最小）元素（或总和）的问题
     * 每一步都选择最佳方案
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
    	int maxValue = nums[0];
    	int currSum = nums[0];// 之前位置的子串最大值
    	for (int i = 1; i < nums.length; i++) {
    		// 到当前位置为止可以得到的最大子串值
    		currSum = Math.max(nums[i], currSum+nums[i]);
    		// 当前已知最大值和 到当前位置的子串值比大小 
    		maxValue = Math.max(maxValue, currSum);
    	}
    	return maxValue;
    	
    }
}
