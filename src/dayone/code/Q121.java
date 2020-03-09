package dayone.code;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 * 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 * @author lyx 
 * @date 2020年3月9日 上午10:34:56 
 *
 */
public class Q121 {

	@Test
	public void maxProfitTest() {
		assertEquals(maxProfit(new int[] {7,1,5,3,6,4}), 5);
//		assertEquals(maxProfit(new int[] {7,6,4,3,1}), 0);
	}
	
	 public int maxProfit(int[] prices) {
		int buy = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if(buy > prices[i] ) {
				buy = prices[i];
			}else if (prices[i] - buy > maxProfit ) {
				maxProfit = prices[i]-buy;
			}
		}
		return maxProfit;
    }
}
