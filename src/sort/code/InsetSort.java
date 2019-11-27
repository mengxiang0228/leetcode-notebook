/**
 * 
 */
package sort.code;

import java.util.Arrays;

/**
   *    插入排序
   * 	将数组左侧看作一个 有序的数组，将后面元素依次插入这个有序数组中
[9, 5, 7, 8, 3] // 9 插入后 9 左侧为有序的
[5, 9, 7, 8, 3] // 5 插入后 5-9 有序
[5, 7, 9, 8, 3] // 7 插入后 5-7-9 有序
[5, 7, 8, 9, 3] // 8 插入后 5-7-8-9 有序
[3, 5, 7, 8, 9] // 3 插入后  3, 5, 7, 8, 9 有序

 * @author lyx
 * @date 2019年6月12日
 *   
 */
public class InsetSort {
	
		
	public static void main(String[] args) {
		int[] list = new int[] {9,5,7,8,3};
		
		for (int i = 0; i < list.length; i++) {
			int temp = list[i];
			int j = i-1;
			while (j >= 0 && list[j] > temp) {
				// 只与已排好的部分排序,给temp元素确认在有序数组中的位置，并且将后面的元素后移
				list[j+1] = list[j];
				j = j-1;
			}
			list[j+1] = temp;
			System.out.println(Arrays.toString(list));
		}
		
		System.out.println(Arrays.toString(list));
	}
}
