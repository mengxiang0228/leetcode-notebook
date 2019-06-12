/**
 * 
 */
package sort.code;

/**
   *   快速排序
 * @author lyx
 * @date 2019年6月12日
 *   
 */
public class FastSort {

	public static void main(String[] args) {
		int[] list = new int[] {9,5,7,8,3};
		System.out.println(list.length);
		fastSort(list,0, list.length);
		
	}
	
	public static void fastSort(int[] a, int start, int end) {
		if (start < end) {
			int temp = a[start];
			int i = start;
			int j = end;
			
			do {
				while (a[i] <= temp && i <end) {
					i ++;
				}
				while (a[j] <= temp && j >start) {
					j --;
				}
				System.out.println(i+"   "+j);
				if ( i <= j) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
					i++;
					j--;
				}
			} while (i <= j);
		}
	}
}
