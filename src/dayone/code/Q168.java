package dayone.code;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 68. Excel表列名称
 *
 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

 例如：

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...

 示例 1：

 输入：columnNumber = 1
 输出："A"


 * @author liyaxiang
 * @since 2021/6/29 14:48
 */
public class Q168 {

    public static void main(String[] args) {
//        System.out.println(701%26);
//        System.out.println(701/26);
//        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(26));
//        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle(2147483647));
    }

    @Test
    public void test1(){
        assertEquals(convertToTitle(26), "Z");
        assertEquals(convertToTitle(28), "AB");
        assertEquals(convertToTitle(701), "ZY");
        assertEquals(convertToTitle(2147483647), "FXSHRXW");
        assertEquals(convertToTitle(29), "AC");
        assertEquals(convertToTitle(52), "AZ");

    }
    /**
     * 1 65
     * 2 66
     * 0 90
      */

    /**
     *  需要优化 A-Z 0+A--25+A，可以通过原值-1 来取余
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        String column = "";
        while (columnNumber >0 ){
            columnNumber -=1;
            column = (char)(columnNumber%26+'A')+column;// 尾
            columnNumber = columnNumber/26;// 取整
        }
        return column;
    }

    /**
     * 官方解法
     * @param columnNumber
     * @return
     */
    public static String convertToTitle1(int columnNumber) {
        String column = "";
        while (columnNumber > 0 ){// 取整
            columnNumber --;
            column = (char)(columnNumber%26+'A')+column;
            columnNumber = columnNumber/26;
        }
        return column;
    }
}
