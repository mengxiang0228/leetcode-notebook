package algorithm.code;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @author lyx
 * @date 2019年4月22日
 *
 */
public class ThreeNumberSum {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
			int start = i+1;
			int end = nums.length-1;
			int sum = 0 - nums[i];
			if(i != 0 && nums[i]==nums[i-1]) {
				continue;
			}
			
			while (start < end) {
				if (nums[start] +nums[end] == sum) {
					list.add(Arrays.asList(nums[i], nums[start], nums[end]));
					
					while (start <end && nums[start] == nums[start+1]) {
						start ++;
					}
					while (start <end && nums[end] == nums[end-1]) {
						end --;
					}
					start ++;
					end --;
				}else if (nums[start] +nums[end] < sum) {
					while (start <end && nums[start] == nums[start+1]) {
						start ++;
					}
					start ++;
					
				}else {
					end --;
				}
			}
			
		}
		return list;
        
    }
	
	/**
	 * 	244 ms	72.6 MB	
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int start = i+1;
			int end = nums.length-1;
			int sum = 0 - nums[i];
			while (start < end) {
				if (nums[start] +nums[end] == sum) {
					String numString = nums[i]+","+nums[start]+","+nums[end];
					if (!map.containsKey(numString)) {
						map.put(numString, null);
						list.add(Arrays.asList(nums[i], nums[start], nums[end]));
					}
					
					while (start <end && nums[start] == nums[start+1]) {
						start ++;
					}
					while (start <end && nums[end] == nums[end-1]) {
						end --;
					}
					start ++;
					end --;
				}else if (nums[start] +nums[end] < sum) {
					while (start <end && nums[start] == nums[start+1]) {
						start ++;
					}
					start ++;
					
				}else {
					end --;
				}
			}
			
		}
		return list;
		
	}
	
	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> list2 = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i +1; j < nums.length; j++) {
				int b = nums[j];
				for (int k = j+1; k < nums.length; k++) {
					int c = nums[k];
					if (a+b+c == 0) {
						String numString = a+","+b+","+c;
						if (!map.containsKey(numString)) {
							System.out.println(numString);
							map.put(numString, 0);
							list2 = new ArrayList<Integer>();
							list2.add(a);
							list2.add(b);
							list2.add(c);
							list.add(list2);
						}
						
					}

				}
			}
		}
		return list;
        
    }
}
