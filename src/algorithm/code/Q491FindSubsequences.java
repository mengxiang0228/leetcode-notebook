package algorithm.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 
 * @author lyx 
 * @date 2019年11月1日 下午4:07:20 
 *
 */
public class Q491FindSubsequences {
	@Test
	public void test() {
		int[] nums = {4, 6, 7, 7};
		System.out.println(findSubsequences(nums));
		//FIXME 理解一点
	}
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> resutlList = new ArrayList<>();
	    if (nums.length <= 1) {
	        return resutlList;
	    }
	    getSubsequences(nums, Integer.MIN_VALUE, 0, resutlList, new Stack<>());
	    return resutlList;
	}
	
	private static void getSubsequences(int[] nums, int minValue,int start, List<List<Integer>> resutlList, Stack<Integer> stack) {
		System.out.println("进入");
		if(stack.size() >= 2) {
			resutlList.add(new ArrayList<>(stack));
		}
		// 用于排除重复值
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if(set.contains(nums[i]) || nums[i] < minValue) {
				continue;
			}
			stack.push(nums[i]);
			set.add(nums[i]);
			System.out.println(stack.toString());
			getSubsequences(nums, nums[i], i+1, resutlList, stack);
			stack.pop();
		}
		System.out.println("结束");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void get(int[] nums, int minValue, int start, List<List<Integer>> resultList, Stack<Integer> stack) {
//		if(stack.size() >= 2) {
//			resultList.add(new ArrayList<>(stack));
//		}
//		Set<Integer> hs = new HashSet<>();
//		for (int i = start; i < nums.length; i++) {
//			if(hs.contains(nums[i]) || nums[i] < minValue) {
//				// 将重复值跳过，将
//				continue;
//			}
//			stack.push(nums[i]);
//			
//			hs.add(nums[i]);
//			get(nums, nums[i], i+1, resultList, stack);
//			System.out.println("0  "+stack.toString());
//			stack.pop();
//			System.out.println("1  "+stack);
//		}
//	}
	
	
	
}
