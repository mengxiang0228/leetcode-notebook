package algorithm.code;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。

 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。

 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 再例如，[1, 1, 2, 5, 7] 不是等差序列。

 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。

 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。

 题目数据保证答案是一个 32-bit 整数。

 * @author liyaxiang
 * @since 2021/8/11 19:00
 * 不会
 */
public class Q446 {

    @Test
    public void test1(){
        numberOfArithmeticSlices(new int[]{2,4,6,8,10});
    }

    /**
     * 参考答案
     * 哈希表 也可以叫动态规划
     * @param nums
     * @return
     */
    public static int numberOfArithmeticSlices(int[] nums) {
        int allCount = 0;
        // 获取每个元素 指定长度的值
        List<Map<Long, Integer>> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(new HashMap<>());
        }
        for (int i = 0; i < nums.length; i++) {
            // 第一层循环 结束位置
            for (int j = 0; j < i; j++) {
                // 第二次循环 计算 结束位置往前每个元素的差
                long sub = nums[i]-nums[j];
                int count = list.get(j).getOrDefault(sub,0);
                allCount +=count;
                // 动态规划 根据之前的结果获取本次的值
                list.get(i).put(sub, list.get(i).getOrDefault(sub,0)+count+1);
            }
            System.out.println("一次循环结束");
            System.out.println();
        }
        return allCount;
    }
}
