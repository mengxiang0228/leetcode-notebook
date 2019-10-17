package N158;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * 1221
 * 
 * @author lyx 
 * @date 2019年10月17日 下午3:45:07 
 *
 */
public class BalanceStr {
	
	@Test
	public void balancedStringSplitTest() {
		String string = "LRLR";
		assertEquals(balancedStringSplit(string), 2);
		string = "RLLLLRRRLR";
		assertEquals(balancedStringSplit(string), 3);
		
	}
	
	public static int balancedStringSplit(String s) {
		int num = 0;
		int rst = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'L') {
				num ++;
			}else {
				num --;
			}
			if(num == 0 ) {
				rst ++;
			}
		}
		
		return rst;
    }
}
