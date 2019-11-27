package sort.code;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 选择排序
 * 每次找最小的值，进行排序
 *  O(n²) 
 * @author lyx 
 * @date 2019年11月27日 下午12:00:05 
 *
 */
public class SelectionSort {

	@Test
	public void testSort() {
		int[] list = new int[] {9,5,7,8,3};
		sort(list);
		assertArrayEquals(list, new int[] {3, 5, 7, 8, 9});
		System.out.println(Arrays.toString(list));
	}
	
	public void sort(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int minIndex = i;// 设置当前位置的值为最小值
			for (int j = i+1; j < list.length; j++) {
				if(list[j] < list[minIndex]) {
					minIndex = j;
				}
			}
			int temp = list[minIndex];
			list[minIndex] = list[i];
			list[i] = temp;
		}
	}
}
