package algorithm.code;

import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
	
	public static void main(String[] args) {
		TwoNumberSum twoNumberSum = new TwoNumberSum();
		int[] nums =  {2, 17, 4, 11, 15, 5};
		int[] results = twoNumberSum.twoSum(nums, 9);
		System.out.println(Arrays.toString(results));
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		map.put(key, value)
	}
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int findnum = target - nums[i]; 
			if (map.containsKey(findnum)) {
				return new int[] {map.get(findnum), i};
			}
			map.put(nums[i], i);
		}
		return new int[] {-1, -1};
        
    }
	
	public int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int findnum = target - nums[i]; 
			for (int j = i+1; j < nums.length; j++) {
				if (findnum == nums[j]) {
					return new int[] {i, j};
				}
				
			}
		}
		return new int[] {-1, -1};
        
    }
}
