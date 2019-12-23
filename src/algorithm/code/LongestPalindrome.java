/**
 * 
 */
package algorithm.code;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * @author lyx
 * @date 2019年6月3日
 *   
 */
public class LongestPalindrome {
	
	@Test
	public void test() {
		assertEquals(longestPalindrome("glknendplocymmvwtoxvebkekzttzfdhykknufqdkntsknksnqvgfbsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"), "sknks");
		assertEquals(longestPalindrome("aaaa"), "aaaa");
		assertEquals(longestPalindrome("aaa"), "aaa");
		assertEquals(longestPalindrome("aa"), "aa");
		assertEquals(longestPalindrome("a"), "a");
		assertEquals(longestPalindrome("cbbd"), "bb");
	}
	
	public static String longestPalindrome(String s) {
		String reString = ""; 
		StringBuffer string = new StringBuffer();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			string.setLength(0);
			string.append(s.charAt(i));
			int a = 1;
			//aba
			while (i-a >= 0 && i+a < s.length() && s.charAt(i-a) == s.charAt(i+a)) {
				string.insert(0, s.charAt(i-a));
				string.append( s.charAt(i+a));
				a++;
			}
			a--;
			if (max < a+a+1) {
				max = a+a+1;
				reString =  string.toString();
//				System.out.println(max);
//				System.out.println(reString);
			}
			
			// bb
			a = 1;
			string.setLength(0);
			while (i-a >= 0 && i+a-1 < s.length() && s.charAt(i+a-1) == s.charAt(i-a)) {
//				System.out.println(string);
//				System.out.println(i-a +"_"+ i+"_"+ (i+a-1));
				string.insert(0, s.charAt(i-a));
				string.append(s.charAt(i-a));
				a++;
			}
			a--;
			if (max < a+a) {
				max = a+a;
				reString =  string.toString();
//				System.out.println(max);
//				System.out.println(reString);
			}
			
		}
		return reString;
        
    }
	
	/**
	 * 动态规划 看不懂搁着
	 * @param s
	 * @return
	 */
	public String longestPalindrome1(String s) {
		// TODO 最长回文，看不懂
		int length = s.length();
		boolean[][] P = new boolean[length][length];
		int maxLen = 0;
	    String maxPal = "";
	    for (int len = 1; len <= length; len++) {
	    	for (int start = 0; start < length; start++) {
				int end = start+len-1;
				if(end >= length) {
					break;
				}
				P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
				// TODO 最长回文，未完成
	    	}
			
		}
		return s;
		
	}
}
