package N179;

import org.junit.Test;

/**
 * 5352. 生成每种字符都是奇数个的字符串
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。

返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。

 * @author lyx 
 * @date 2020年3月9日 上午11:24:06 
 *
 */
public class Q5352 {
	
	@Test
	public void generateTheStringTest() {
		System.out.println(generateTheString(5));
	}
	
	public String generateTheString(int n) {
		if(n <= 0) {
			return "";
		}
		StringBuilder str = new StringBuilder(n);
		for (int i = 0; i < n-1; i++) {
			str.append("a");
		}
		if(n%2 == 0) {
			str.append("b");
		}else {
			str.append("a");
		}
		return str.toString();
    }
}
