package algorithm.code.ga;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

 * @author lyx 
 * @date 2020年3月5日 下午2:02:58 
 *
 */
public class Q392 {

	@Test
	public void isSubsequenceTest() {
//		assertEquals(isSubsequence("abc", "ahbgdc"),  true);
//		assertEquals(isSubsequence("axc", "ahbgdc"),  false);
		assertEquals(isSubsequence("abc", "ahbgdc"),  true);
	}
	
    public boolean isSubsequence(String s, String t) {
    	if(s.length() <= 0) {
    		return true;
    	}
    	char nextChar = s.charAt(0);
    	int num = 0;
    	for (int i = 0; i < t.length(); i++) {
			if(t.charAt(i) == nextChar) {
				if(num == s.length()-1) {
					return true;
				}
				num++;
				nextChar = s.charAt(num);
			}
		}
		return false;
    }
    
    public boolean isSubsequence1(String s, String t) {
    	if(s.length() <= 0) {
    		return true;
    	}
    	int index = -1;
    	for (char indexChar : s.toCharArray()) {
    		 index = t.indexOf(indexChar, index+1);
			if( index < 0 ) {
				return false;
			}
		}
		return true;
    }
}
