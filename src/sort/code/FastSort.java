/**
 * 
 */
package sort.code;

import java.util.Arrays;

/**
   *   快速排序
   *   最坏运行情况是 O(n²)
 * @author lyx
 * @date 2019年6月12日 重写：2019-11-26 练习:2020-03-31
 *   https://www.cnblogs.com/redbear/p/8891730.html
 */
public class FastSort {

	public static void main(String[] args) {
		int[] list = new int[] {6,9,5,7,8,3};
		System.out.println(Arrays.toString(list));
		fastSort2(list,0, list.length-1);
		
	}
	
	public static void fastSort(int[] a, int start, int end) {
		if (start < end) {
			System.out.println(Arrays.toString(a) +"  start:  "+start+ "  end:  "+end);
			int temp = a[start]; // 设置基准值
			int i = start;
			int j = end;
			while (i < j) { // 我们要进行循环，只要low和high没有碰头就一直进行,当low和high相等说明碰头了
				// 从右往左 找出比基准值小的值
				while (a[j] >= temp && i < j) {
					j --;
				}
				a[i] = a[j]; // i位置值已记录在 temp中
				
				// 从左往右 找出比基准值大的数
				while (a[i] <= temp && i < j) {
					i ++;
				}
				a[j] = a[i];// j位置的值已经替换到了i位置
				
			}
			a[i] = temp;// 将 start位置的值 放到 i值的位置
	        //递归调用左半数组
	        fastSort(a, start, i-1);
	        //递归调用右半数组
	        fastSort(a, i+1, end);
		}

	}
	
	/**
	 * 2020-03-31练习
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void fastSort2(int[] a, int start, int end) {
		if(start < end) {
			int temp = a[start];
			int i = start;
			int j = end;
			while (i < j) {
				while (a[j] >= temp && i< j) {
					j--;
				}
				a[i] = a[j];
				System.out.println(Arrays.toString(a));
				while (a[i] <= temp && i < j) {
					i++;
				}
				a[j] = a[i];
				System.out.println(Arrays.toString(a));
			}
			a[i] = temp;
			System.out.println(Arrays.toString(a));
			fastSort2(a, start, i-1);
			fastSort2(a, i+1, end);
		}
	}
	
}
