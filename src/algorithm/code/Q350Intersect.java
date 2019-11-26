package algorithm.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 350. 两个数组的交集 II
 * 
 * @author lyx 
 * @date 2019年11月1日 下午2:03:24 
 *
 */
public class Q350Intersect {
	
	@Test
	public void intersectTest() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
//		int[] nums1 = {1,2,2,1};
//		int[] nums2 = {2,2};
		System.out.println(Arrays.toString(intersectSort(nums1, nums2)));
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		List<Integer> list  = new ArrayList<Integer>(nums1.length);
		List<Integer> smallList = new ArrayList<Integer>(nums1.length);
		for (int num0 : nums1) {
			smallList.add(num0);
		}
		int num = 0;
		int index = -1;
		for (int i = 0; i < nums2.length; i++) {
			num = nums2[i];
			index = smallList.indexOf(num);
			if(index >= 0) {
				smallList.set(index, null);
				list.add(num);
			}
		}
		int[] restult = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	restult[i] = list.get(i);
        }

		return restult;
        
    }
	
	// 排序解法
	public int[] intersectSort(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list  = new ArrayList<Integer>(nums1.length);
		
		int num = 0;
		int index = 0;
		for (int i = 0; i < nums1.length; i++) {
			num = nums1[i];
			if(index >= nums2.length) {
				break;
			}
			for (int j = index; j < nums2.length; j++) {
				if(num < nums2[j]) {
					break;
				}
				index ++;
				if(num == nums2[j]) {
					list.add(num);
					break;
				}
			}
			
		}
		int[] restult = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	restult[i] = list.get(i);
        }

		return restult;
        
    }
}
