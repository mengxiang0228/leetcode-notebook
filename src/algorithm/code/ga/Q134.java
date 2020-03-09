package algorithm.code.ga;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 加油站
 * 
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * @author lyx 
 * @date 2020年2月28日 下午5:37:04 
 *
 */
public class Q134 {
	
	@Test
	public final void canCompleteCircuitTest() {
//		assertEquals(canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}), 3);
		assertEquals(canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}), -1);
	}
	
	/**
	 * 1,2,3,4,5
	 * 3,4,5,1,2
	 * -2,-2,-2,3,3
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int index = -1;// 起点位置
		int hasGas = 0;// 剩余油量
		int allGas = 0;// 计算所有加油站油量是否够跑全程
		index = 0;
		for (int i = 0; i < gas.length; i++) {
			hasGas += gas[i]-cost[i];
			allGas += gas[i]-cost[i];
			if(hasGas < 0) {
				index = i+1;
				hasGas = 0;
			}
			
		}
		if(allGas < 0) {
			return -1;
		}
		return index;
    }

}
