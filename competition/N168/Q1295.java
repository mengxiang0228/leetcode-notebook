package N168;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 1295. 统计位数为偶数的数字
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * @author lyx 
 * @date 2019年12月23日 下午3:20:24 
 *
 */
public class Q1295 {
	
	@Test
	public void test() {
		int[] nums = {12,345,2,6,7896};
		int size =  findNumbers(nums);
		assertEquals(size, 2);
		
		int[] nums1 = {555,901,482,1771};
		size =  findNumbers(nums1);
		assertEquals(size, 1);
	}
	
	public int findNumbers(int[] nums) {
		int size = 0;
		for (int num : nums) {
			String.valueOf(num).length();
			if(String.valueOf(num).length()%2 == 0) {
				size ++;
			}
		}
		return size;
    }
}
