/**
 * 
 */
package algorithm.code;

/**
 * 5. 最长回文子串
 * @author lyx
 * @date 2019年6月3日
 *   
 */
public class LongestPalindrome {
	
	public static void main(String[] args) {
		longestPalindrome("abccbfg");
	}
	public static String longestPalindrome(String s) {
		String string = "";
		int max = 0;
		int length = 0;
		for (int i = 1; i < s.length(); i++) {
			string = String.valueOf(s.charAt(i));
			int a = 1;

			while (i-a >= 0 && i+a < length && s.charAt(i-a) == s.charAt(i+a)) {
				a++;
			}
			
			while (i-a >= 0 && i+a < length && s.charAt(i-a) == s.charAt(i+a)) {
				a++;
			}
			
			if (max < a) {
				length = i;
				max = a;
			}
		}
		System.out.println(max+" "+ length);
		return s;
        
    }
}
