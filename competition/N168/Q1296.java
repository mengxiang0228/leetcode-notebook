package N168;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;


/**
 * 划分数组为连续数字的集合
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * @author lyx 
 * @date 2019年12月23日 下午3:20:45 
 *
 */
public class Q1296 {
	
	@Test
	public void test() {
		int[] nums = new int[] {5,6,7,8,9,6,7,8,9,10,11,12,13,14,15,12,13,14,15,19};
		boolean b =  isPossibleDivide(nums, 5);
		System.out.println(b);
		assertEquals(b, false);
	}
	
	@Test
	public void allTest() {
		int[] nums = {1,2,3,3,4,4,5,6};
		boolean b =  isPossibleDivide(nums, 4);
		System.out.println(b);
		assertEquals(b, true);
		
		
		nums =  new int[] {3,2,1,2,3,4,3,4,5,9,10,11};
		b =  isPossibleDivide(nums, 3);
		System.out.println(b);
		assertEquals(b, true);
		
		nums = new int[] {3,3,2,2,1,1};
		b =  isPossibleDivide(nums, 3);
		System.out.println(b);
		assertEquals(b, true);
		
		nums = new int[] {1,2,3,4};
		b =  isPossibleDivide(nums, 3);
		System.out.println(b);
		assertEquals(b, false);
		
		nums = new int[] {5,6,7,8,9,6,7,8,9,10,11,12,13,14,15,12,13,14,15,19};
		b =  isPossibleDivide(nums, 5);
		assertEquals(b, false);
	}
	
    public boolean isPossibleDivide(int[] nums, int k) {
    	if(nums.length%k != 0) {
    		return false;
    	}
    	Integer size = 0;
    	Integer last = 0;
    	Map<Integer, Integer> map = new TreeMap<>();
    	for (int num : nums) {
			map.put(num, map.getOrDefault(num,0) +1);
		}

    	for (int i = 0; i < nums.length/k; i++) {
    		for (Entry<Integer, Integer> entry : map.entrySet()) {
        		int num = entry.getKey();
        		if(entry.getValue() <= 0) {
        			continue;
        		}
        		entry.setValue(entry.getValue()-1); 
//        		System.out.println("size:"+size+" ,num:"+num+" ,last:"+last);
    			if(size == 0) {
    				last  = num;
    				size ++;
    				continue;
    			}

    			if (last == num-1) {
    				last  = num;
    				size ++;
    			}else {
    				return false;
    			}
    			
    			if (size == k) {
    				size = 0;
//    				System.out.println();
    				break;
    			}
    			
    		}
		}
    	
		return true;
        
    }
}
