package N175;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 
 * @author lyx 
 * @date 2020年2月13日 下午2:42:33 
 *
 */
public class Q1346 {

	@Test
	public final void checkIfExistTest1() {
		int[] arr = null;
		boolean b = false;
		arr = new int[]{10,3,5,3};
		b = checkIfExist(arr);
		assertEquals(b, true);
		
		arr = new int[]{-10,12,-20,-8,15};
		b = checkIfExist(arr);
		assertEquals(b, true);
		
		arr = new int[]{4,-7,11,4,18};
		b = checkIfExist(arr);
		assertEquals(b, false);
		
		
	}
	
    public boolean checkIfExist(int[] arr) {
    	Arrays.sort(arr);
    	Set<Integer> set = new HashSet<>(arr.length);
    	for (Integer number : arr) {
    		if(set.contains(number)) {
    			// 集合中包含当前值 
    			return true;
    		}
			if(number < 0 && number%2 == 0) {
				// 添加 当前值/2的值到集合中
				set.add(number/2);
			}else if (number >= 0) {
				set.add(number*2);
			}
		}
		return false;
    }
}
