/**
 * 
 */
package algorithm.code;

import org.junit.Test;

/**
 * 4. 寻找两个有序数组的中位数
 * @author lyx
 * @date 2019年6月3日
 *   
 */
public class FindMedianSortedArrays {
	
//	public static void main(String[] args) {
//		System.out.println(4/3);
//	}
	@Test
	public void test() {
		int[] i1 = {};
		int[] i2 = {};
		try {
			double d = findMedianSortedArrays(i1, i2);
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int length = m+n;
		int[] all = new int[length];
		int l1= 0 ,l2 = 0, l3 = 0;
		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 0) {
			all = nums2;
			l3 = n;
		}
		if (n == 0) {
			all = nums1;
			l3 = m;
		}
		double r1 = 0;
		while (l3 < length-1) {
			
			while (l1 < m && nums1[l1] <= nums2[l2]) {
				all[l3++] = nums1[l1++];
			}
			if (l1 >= m) {
				while (l2 < n) {
					all[l3++] = nums2[l2++];
				}
			}
			
			while (l2 < n && nums1[l1] > nums2[l2]) {
				all[l3++] = nums2[l2++];
			}
			
			if (l2 >= n) {
				while (l1 < m) {
					all[l3++] = nums1[l1++];
				}
			}
		}
		r1 =  all[(length-1)/2];
		if (length%2 == 0) {
			return (double)(r1 + all[(length-1)/2+1])/2;
		}
		return r1;
    }
}
