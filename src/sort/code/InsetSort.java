/**
 * 
 */
package sort.code;

import java.util.Arrays;

/**
   *    插入排序
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
				list[j+1] = list[j];
				j = j-1;
			}
			list[j+1] = temp;
		}
		
		System.out.println(Arrays.toString(list));
	}
}
