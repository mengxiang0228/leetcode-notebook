package algorithm.code;

import org.junit.Test;

/**
 * 最短路径
 * 
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
 * @author lyx 
 * @date 2019年11月27日 下午2:58:22 
 *
 *动态规划
 */
public class Q64 {
	@Test
	public void testSort() {
		int[][] list = new int[][] {
			  {1,3,1},
			  {1,5,1},
			  {4,2,1}
			};
		System.out.println(minPathSum(list));
	}
	
	
	/**
	 * 动态规划，以新数组存储路径和数据
	 * @param grid
	 * @return
	 * 时间：m*n
	 * 空间:m*n-额外空间
	 */
	public int minPathSum(int[][] grid) {
		int[][] list = new int[grid.length][grid[0].length];
//		grid.length: 列
//		grid[0].length: 行
		for (int i = grid.length-1; i >= 0; i--) {// 每一行
			for (int j = grid[0].length-1; j >= 0; j--) {// 每一列
				int now = grid[i][j];
				int right = 9999;	// 右侧元素
				int down = 9999;	// 下侧元素
				if(i != grid.length-1) { //不是最后一行
					down = list[i+1][j]; 
				}
				if(j != grid[0].length-1) { //不是最后一列
					right = list[i][j+1]; 
				}
				if(i == grid.length-1 && j == grid[0].length-1) {
					// 最后一格元素
					list[i][j] = now;
				}else {
					
					list[i][j] = now + Math.min(right, down);
				}
            }
		}
		return list[0][0];
    }
}
