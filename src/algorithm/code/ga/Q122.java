package algorithm.code.ga;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
 * @author lyx 
 * @date 2020年2月28日 下午2:28:04 
 *
 */
public class Q122 {
	
	@Test
	public final void maxProfitTest() {
		assertEquals(maxProfit(new int[]{7,1,5,3,6,4}), 7);
		assertEquals(maxProfit(new int[]{1,2,3,4,5}), 4);
		assertEquals(maxProfit(new int[]{7,6,4,3,1}), 0);
	}
	@Test
	public final void maxProfit1Test() {// 谷时买，峰时卖
//		assertEquals(maxProfit1(new int[]{7,1,5,3,6,4}), 7);
//		assertEquals(maxProfit1(new int[]{1,2,3,4,5}), 4);
//		assertEquals(maxProfit1(new int[]{7,6,4,3,1}), 0);
		assertEquals(maxProfit1(new int[]{5,2,3,2,6,6,2,9,1,0,7,4,5,0}), 20);
	}
	
	/**
	 * 贪心算法
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0; // 利润
		for (int i = 1; i < prices.length; i++) {
			if(prices[i-1] < prices[i]) {//
				profit += prices[i]-prices[i-1];
//				System.out.println(prices[i-1] + "  "+ prices[i]);
			}
		}
		return profit;
    }
	
	/**
	 * 谷时买，峰时卖
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
		int buy = -1;
		int profit = 0; // 利润
		for (int i = 1; i < prices.length; i++) {
//			System.out.println(prices[i-1] + " "+ prices[i]);
			if(prices[i-1] <  prices[i]) {
				if(buy < 0 || ( buy > 0 && buy > prices[i-1])) {
					buy = prices[i-1];
					
				}
			}
			if(prices[i-1] <  prices[i] && (i+1>=prices.length || prices[i] >= prices[i+1])) {
//				System.out.println("购入价格:"+buy+"卖出价格:"+prices[i]);
				profit += prices[i]-buy;
				buy = -1;
			}
		}
//		System.out.println();
		return profit;
	}
	
	
}
