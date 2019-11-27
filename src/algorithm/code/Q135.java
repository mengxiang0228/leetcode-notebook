package algorithm.code;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Q135 {

	@Test// 贪心算法
	public void test() {
//		String[] coordinates = {"/a/b","/a","/c/d","/c/d/e","/c/f"};
//		int[] coordinates =  {1,0,2};
		int[] coordinates =  {1,3,4,5,2};
		System.out.println(candy(coordinates));
		assertEquals(candy(coordinates), 5);
	}
	
	@Test// 峰值谷值计算
	public void testCandy1() {
		int[] coordinates =  {1,3,4,5,2};
		System.out.println(candy1(coordinates));
		assertEquals(candy1(coordinates), 11);
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
	/**
	 * 方法 4：常数空间一次遍历， 找峰和谷
	 * @param ratings
	 * @return
	 */
	public int candy1(int[] ratings) {
		if (ratings.length <= 1) {
            return ratings.length;
        }
		int up = 0;// 上升
		int down = 0;// 下降
		int oldSlope = 0;// 原来是上升还是下降
		int candies = 0;// 糖果总数
		for (int i = 1; i < ratings.length; i++) {
			int newSlope = ratings[i] > ratings[i-1]?1:(ratings[i] < ratings[i-1] ? -1: 0);// 计算是上升还是下降
			if((oldSlope > 0 && newSlope == 0 ) || (oldSlope < 0 && newSlope >= 0)) {
				// 处于谷底   上个点上升，当期点不变||上一个点下降当前点上升/不变
				candies += count(up) + count(down) + Math.max(up, down);
				up = 0;
				down = 0;
			}
			if(newSlope > 0) {
				up ++;
			}
			if(newSlope < 0 ) {
				down ++;
			}
			if(newSlope == 0) {
				candies ++;
			}
			oldSlope = newSlope;
		}
		candies += count(up) + count(down) + Math.max(up, down)+1;
		return candies;
	}
	
	public int count(int n) {
		return (n*(n+1))/2;
	}
	
}
