/**
 * 
 */
package algorithm.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 四数之和 https://leetcode-cn.com/problems/4sum/
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：答案中不可以包含重复的四元组。
 * @author lyx
 * @date 2019年4月22日
 *   
 */
public class FourNumberSum {
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0));
	}
	
	//网上参考
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
		
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-3; i++) {
    		 //去重
    		if(i>0 && nums[i]==nums[i-1])
                continue;
			for (int j = i+1; j < nums.length-2; j++) {
				if(j>i+1 && nums[j]==nums[j-1])
                    continue;
	                
				int start = j +1;
				int end = nums.length-1;
				int sum = target - nums[i] - nums[j];
				while (start < end) {
					if (nums[start] + nums[end] == sum) {
						list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
						while (start < end && nums[start] == nums[start+1] ) {
							start ++;
						}
						while (start < end && nums[end] == nums[end-1] ) {
							end --;
						}
						start++;
						end --;
					}else if (nums[start]+nums[end] <sum) {
						start ++;
					}else {
						end --;
					}
				}
			}
			
		}
    	
		return list;
        
    }
	 
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-3; i++) {

			for (int j = i+1; j < nums.length-2; j++) {
				int start = j +1;//头指针
				int end = nums.length-1;//尾指针
				int sum = target - nums[i] - nums[j];
			
				while (start < end) {
					if (nums[start] + nums[end] == sum) {
						String numString = nums[i]+","+nums[j]+","+nums[start]+","+nums[end];
						if (!map.containsKey(numString)) {
							list.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
							map.put(numString, null);
						}
						while (start < end && nums[start] == nums[start+1] ) {
							//如果start当前值和下一个值相同则跳过
							start ++;
						}
						while (start < end && nums[end] == nums[end-1] ) {
							//如果end当前值和下一个值相同则跳过
							end --;
						}
						start++;
						end --;
					}else if (nums[start]+nums[end] <sum) {
						start ++;
					}else {
						end --;
					}
				}
			}
			
		}
    	
		return list;
        
    }
}
