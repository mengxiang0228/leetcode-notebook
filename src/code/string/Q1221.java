package code.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 1221. 分割平衡字符串
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * @author liyaxiang
 * @since 2021/9/7 14:01
 */
public class Q1221 {

    @Test
    public void test1(){
        System.out.println();
        assertEquals(balancedStringSplit("RLRRLLRLRL"), 4);
        assertEquals(balancedStringSplit("RLRRRLLRLL"), 2);
        assertEquals(balancedStringSplit("LLLLRRRR"), 1);
    }


    public int balancedStringSplit(String s) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'L'){
                num++;
            }else {
                num--;
            }
            if(num == 0){
                count++;
            }
        }
        return count;
    }
}
