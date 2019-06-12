/**
 * 
 */
package code.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author lyx
 * @date 2019年4月25日
 *   
 */
public class repeatString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int length = s.length();
    	int max = 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0, j = 0; j< length ; j++) {
			if (map.containsKey(s.charAt(j))) {
				
				//重置起始位置 j和i
				i = Math.max(map.get(s.charAt(j)),i);
			}
			max = Math.max(max, j-i+1);
			map.put(s.charAt(j), j+1);
			
		}
		return max;
    }
    
    public static int lengthOfLongestSubstring1(String s) {
    	int length = s.length();
    	Set<Character> set = new HashSet<Character>();
    	int max = 0,  i = 0, j = 0;
    	while (i<length && j < length) {
			if (set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}else {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, j-i);
			}
		}
    	
		return max;
    }
}
