package dayone.code;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 1103. 分糖果 II
 * 
 * 排排坐，分糖果。

我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。

给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。

然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。

重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。

返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * @author lyx 
 * @date 2020年3月5日 上午10:57:31 
 *
 */
public class Q1103 {

	@Test
	public void distributeCandiesTest() {
		assertArrayEquals(distributeCandies(7, 4), new int[] {1,2,3,1});
		assertArrayEquals(distributeCandies(10, 3), new int[] {5,2,3});
	}
	
	public static void main(String[] args) {
		int i = 0;
		System.out.println(++i>0);
	}
	
	public int[] distributeCandies(int candies, int num_people) {
		int[] dp = new int[num_people];
		int num = 1;
		int index = 0;
		while (candies > 0) {
			if(candies <= num) {
				num = candies;
				candies = 0;
			}
			candies -= num;
			
			dp[index] += num;
			num++;
			if(++index >= num_people) {
				index = 0;
			}
		}
		return dp;

    }
}
