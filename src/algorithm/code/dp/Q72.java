package algorithm.code.dp;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

    插入一个字符
    删除一个字符
    替换一个字符
 * @author lyx 
 * @date 2020年2月14日 上午11:02:37 
 * 照着实现的
 */
public class Q72 {


	@Test
	public void minDistanceTest() {
		
		assertNotEquals(minDistance("hsrse", "ros"), 1);
    }
	
	/**
	 * 距离编辑算法，三个公式
	 * dp[i-1][j-1]: 替换或跳过
	 * dp[i-1][j]  : 删除
	 * dp[i][j-1]  : 插入
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
    	int n = word1.length();
    	int m = word2.length();
    	if(m*n == 0) {
    		return m+n;
    	}
    	int[][] nums = new int[n+1][m+1];
    	// [i][j] 指的是 a 中前 i 个字符和 b 中前 j 个字符之间的距离 
    	// 第一行，是 word1 为空变成 word2 最少步数，就是插入操作
    	// 第一列，是 word2 为空，需要的最少步数，就是删除操作
    	for (int i = 0; i < n+1; i++) {
			nums[i][0] = i;
		}
    	
    	for (int i = 0; i < m+1; i++) {
			nums[0][i] = i;
		}
    	for (int[] is : nums) {
			System.out.println(Arrays.toString(is));
		}
    	System.out.println();
    	for (int i = 1; i < n+1; i++) {
    		for (int j = 1; j < m+1; j++) {
    			int left = nums[i-1][j]+1;//左侧值,插入
    			int down = nums[i][j-1]+1;// 上侧值 ，删除
    			int left_down = nums[i - 1][j - 1];// 左上值， 替换
    			System.out.println("left:"+word1.charAt(i - 1)+" , down:"+word2.charAt(j - 1));
    			
    			if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
    				left_down += 1;
    			}
//    			System.out.println("left:"+left+" , down:"+down+" , left-down: "+left_down);
		        nums[i][j] = Math.min(left, Math.min(down, left_down));
		        for (int[] is : nums) {
					System.out.println(Arrays.toString(is));
				}
		        System.out.println();
    		}
		}
    	System.out.println( nums[n][m]);
		return nums[n][m];
    }
    
    // h -> r   1
    // h -> ro  2
    // h -> ros 3
    
    // ho-> ros 3   =>  上侧: h->ros 删除o, 左侧: ho->ro  插入s

    
}
