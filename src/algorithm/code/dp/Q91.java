package algorithm.code.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * @author lyx 
 * @date 2020年2月26日 下午12:01:03 
 *
 */
public class Q91 {
	@Test
	public void numDecodings1() {
		char c = 'A';
		System.out.println((char)(c+1));
		assertEquals(checkMethod("226"), 3);
		assertEquals(checkMethod("22"), 2);
		assertEquals(checkMethod("26"), 2);
		assertEquals(checkMethod("0"), 0);
		assertEquals(checkMethod("00"), 0);
		assertEquals(checkMethod("10"), 1);
		assertEquals(checkMethod("01"), 0);
		assertEquals(checkMethod("010"), 0);
		assertEquals(checkMethod("100"), 0);
		assertEquals(checkMethod("101"), 1);
		assertEquals(checkMethod("110"), 1);
		assertEquals(checkMethod("230"), 0);
		assertEquals(checkMethod("227"), 2);
		assertEquals(checkMethod("301"), 0);
		assertEquals(checkMethod("121"), 3);
		assertEquals(checkMethod("12120"), 3);
    }
	
	private int checkMethod(String s) {
		int i = 0;
//		i = numDecodings(s);
//		i = numDecodings1(s);
		i = numDecodings2(s);
		return i; 
	}
	/**
	 * 正向计算，
	 * 难点: 需要考虑后一位是0的情况，需要和前一位组合看为一体
	 * 
	 * @param s
	 * @return
	 */
    public int numDecodings(String s) {
    	if(s.startsWith("0") || s.contains("00")) {
    		return 0;
    	}else if (s.length() < 2) {
			return 1;
		}
    	
    	int[] dp = new int[s.length()];
    	dp[0] = 1;
    	dp[1] = dp[0];
    	int charInt = 0;
    	
    	for (int i = 1; i < s.length(); i++) {
    		// 当前位置和上一个位置字符
			int lastNum = Integer.valueOf(String.valueOf(s.charAt(i-1)));
			int nowNum = Integer.valueOf(String.valueOf(s.charAt(i)));
			charInt = lastNum*10+nowNum;
			dp[i] = dp[i-1];
			if((i+1 < s.length() && s.charAt(i+1) == '0') || (nowNum == 0 && charInt > 10 && charInt <= 26) ) { // 当前位置后一位是0
				// 则当前位置只能和后一位组合
				continue;
			}
			if(charInt > 10 && charInt <= 26) {
				if (i-2 >= 0) {
					dp[i] += dp[i-2];
				}else {
					dp[i] += 1;
				}
			}else if (nowNum == 0 && charInt > 26) {
				// 当前位置是0，和前一位组合大于26
				return 0;
			}
		}
//    	System.out.println(Arrays.toString(dp));
		return dp[s.length()-1];
    }
    
    /**
	 * 正向计算，
	 * 简化写法
	 * 
	 * @param s
	 * @return
	 */
    public int numDecodings1(String s) {
    	if(s.startsWith("0") || s.contains("00")) {
    		return 0;
    	}else if (s.length() < 2) {
			return 1;
		}
    	
    	int[] dp = new int[s.length()+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	int charInt = 0;
    	for (int i = 1; i < s.length(); i++) {
    		// 当前位置和上一个位置字符
			int lastNum = Integer.valueOf(String.valueOf(s.charAt(i-1)));
			int nowNum = Integer.valueOf(String.valueOf(s.charAt(i)));
			charInt = lastNum*10+nowNum;
			if(nowNum > 0) {
				dp[i+1] = dp[i];
			}
			
			if(charInt > 9 && charInt <= 26) {
				dp[i+1] += dp[i-1];
			}
			if(dp[i+1] == 0) {
				return 0;
			}
		}
//    	System.out.println(Arrays.toString(dp));
		return dp[s.length()];
    }
    
    /**
     * 正向计算，
     * 三格数组使用
     * 
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
    	if(s.charAt(0) == '0') {
    		return 0;
    	}
    	
    	int[] dp = new int[3];
    	dp[0] = 1;
    	dp[1] = 1;
    	int charInt = 0;
    	for (int i = 1; i < s.length(); i++) {
    		// 当前位置和上一个位置字符
    		int nowNum = s.charAt(i)-48;// 48 = '0'
    		charInt = s.charAt(i-1)*10-480+nowNum;
    		if(nowNum > 0) {
    			dp[2] = dp[1];
    		}
    		
    		if(charInt > 9 && charInt <= 26) {
    			dp[2] += dp[0];
    		}
    		if(dp[2] == 0) {
    			return 0;
    		}
    	    dp[0] = dp[1];
    	    dp[1] = dp[2];
    	    dp[2] = 0;
    	}
    	return dp[1];
    }
    
 
    
}
