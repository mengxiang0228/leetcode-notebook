package N168;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 1297. 子串的最大出现次数
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：

    子串中不同字母的数目必须小于等于 maxLetters 。
    子串的长度必须大于等于 minSize 且小于等于 maxSize 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-number-of-occurrences-of-a-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author lyx 
 * @date 2019年12月24日 上午10:32:30 
 *
 */
public class Q1297 {

	@Test
	public void test() {
		assertEquals(maxFreq("aababcaab", 2, 3, 4), 2);
		assertEquals(maxFreq("aaaa", 1, 3, 3), 2);
		assertEquals(maxFreq("aabcabcab", 2, 2, 3), 3);
		assertEquals(maxFreq("abcde", 2, 3, 3), 0);
		
		
	}
	
	/**
	 * maxSize多余，因为长子串如果有多个，则长子串拆分得到的短子串页应该有相同数量
	 * 如 长子串 aab有2个，则 aa有2个，ab有2个
	 * 所以，只需要判断字符串满足最小长度minMax即可
	 * @param s
	 * @param maxLetters
	 * @param minSize
	 * @param maxSize(多余值)
	 * @return
	 */
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		Map<String, Integer>  map = new HashMap<>();
		int diffLetter = 0;
		int maxRepeat = 0;
		StringBuilder sunStr = null;
		char[] chars =  s.toCharArray();
		
		for (int i = 0; i < chars.length-minSize+1; i++) {
			sunStr = new StringBuilder(minSize);
			diffLetter = 0;
			for (int j = i; j < chars.length; j++) {
				char c = chars[j];
				if(sunStr.length() <= 0 || sunStr.indexOf(String.valueOf(c)) < 0) {
					// 新的子串或者 子串不包含当前字符，则 不同元素个数++
					diffLetter ++;
				}
				sunStr.append(c);
				if(diffLetter > maxLetters || sunStr.length() > minSize) {
					// 不同字符数超了 
					// 长度超了
					break;
				}
				if (sunStr.length() == minSize) {
					int num =  map.getOrDefault(sunStr.toString(), 0);
//					System.out.println(sunStr+ " i:"+i + " j:"+j);
					map.put(sunStr.toString(), ++num);
					maxRepeat = Math.max(maxRepeat, num);// 取最大的重复次数
				}
			}
		}
		return maxRepeat;
    }
}
