package sort.code;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * 1122. 数组的相对排序
 *给你两个数组，arr1 和 arr2，
 *
 *     arr2 中的元素各不相同
 *     arr2 中的每个元素都出现在 arr1 中
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 示例：

 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 输出：[2,2,2,1,4,3,3,9,6,7,19]

 实际使用： 页面排序： 根据整个组织页面的排序 生成个人可见页面的排序
 * @author liyaxiang
 * @since 2021/3/31 19:36
 */
public class Q1122 {

    @Test
    public void relativeSortArrayTest() {
//        assertArrayEquals(relativeSortArray(new Integer[]{2,3,1,3,2,4,6,7,9,2,19}, new Integer[]{2,1,4,3,9,6}), new Integer[]{2,2,2,1,4,3,3,9,6,7,19} );

//        System.out.println(Arrays.toString( relativeSortArray(new Integer[]{9, 1,1,2,3,4,5}, new Integer[]{3,2,1})));
        System.out.println(relativeSortArray2(Arrays.asList(9L, 1L, 1L, 2L, 3L, 4L, 5L, 19L, 10L, 7L), Arrays.asList(3L, 1L, 2L, 19L)));
    }

    public static Integer[] relativeSortArray(Integer[] arr1, Integer[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        //降序 -1 v1 > v2
        Arrays.sort(arr1, (v1,v2)->{
            Integer v1Index = map.get(v1);
            Integer v2Index = map.get(v2);
            if(v1Index == null && v2Index == null){
                return 0;
            }
            if(v1Index == null){
                return 1;
            }
            if(v2Index == null){// 负数 不交换
                return -1;
            }
            return v1Index-v2Index;// -1 v1 比v2靠前
        });
        return  arr1;
    }


    public static List<Long> relativeSortArray2(List<Long> arr1, List<Long> arr2) {
        Map<Long, Integer> map = new HashMap<>(arr2.size());
        for (int i = 0; i < arr2.size(); i++) {
            map.put(arr2.get(i), i);
        }

        //降序 -1 v1 > v2
        Collections.sort(arr1, (v1,v2)->{
            Integer v1Index = map.get(v1);
            Integer v2Index = map.get(v2);
            if(v1Index == null && v2Index == null){
                return (int) (v2-v1);
            }
            if(v1Index == null){
                return 1;
            }
            if(v2Index == null){// 负数 不交换
                return -1;
            }
            return v1Index-v2Index;// -1 v1 比v2靠前
        });
        return  arr1;

    }
}
