package algorithm.code;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

 * @author lyx 
 * @date 2020年2月13日 下午5:53:15 
 *
 */
public class Q62 {

	@Test
	public void uniquePathsTest() {
		assertEquals(uniquePaths(3, 2), 3);
	}
	
	@Test
	public void uniquePaths1Test() {
		assertEquals(uniquePaths1(3, 2), 3);
	}
	
	/**
	 * 使用二维数组存储每个位置的次数
	 * @param m
	 * @param n
	 * @return
	 */
    public int uniquePaths(int m, int n) {
    	int[][] num = new int[m][n];
    	// 最左侧和最上侧都只可能经历一次，因为只能向下或向右移动
    	for (int i = 0; i < m; i++) {
			num[i][0] = 1;
		}
    	for (int i = 0; i < n; i++) {
    		num[0][i] = 1;
    	}
    	// 从左往右依次计算单元格值
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				num[i][j] = num[i-1][j]+num[i][j-1];
			}
		}
		return num[m-1][n-1];
    }
    
    /**
     * 使用一维数组一行一行生成数据
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
    	int[] num = new int[n];
    	Arrays.fill(num, 1);
    	
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				num[j] += num[j-1]; 
			}
		}
		return num[n-1];
    }
}
