package algorithm.code;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Q135 {

	@Test
	public void test() {
//		String[] coordinates = {"/a/b","/a","/c/d","/c/d/e","/c/f"};
//		int[] coordinates =  {1,0,2};
		int[] coordinates =  {1,3,4,5,2};
		System.out.println(candy(coordinates));
		assertEquals(candy(coordinates), 5);
	}
	
	/**
	 * 贪心算法，每次都是局部最优解
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		int[] left = new int[ratings.length];
		int[] right = new int[ratings.length];
		Arrays.fill(left, 1);
        Arrays.fill(right, 1);
		for (int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]  ) {
				left[i] = left[i-1]+1;
			}
		}

		for (int j = ratings.length-2; j >= 0; j--) {
			if(ratings[j] > ratings[j+1]  ) {
				right[j] = right[j+1]+1;
			}
		}
		int sum = 0;
		
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
		return sum;
	        
    }
}
