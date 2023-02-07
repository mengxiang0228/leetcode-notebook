package sort.code;


import java.util.Arrays;

/**
 * 归并排序
 * 将数组拆分为多个数组 每个数组进行排序，最后将排序结果整合
 * @author liyaxiang
 * @since 2021/8/31 17:38
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] list = new int[] {9,5,7,8,3};
        sort(0, list.length-1,list);
    }

    public static void sort(int start, int end, int[] list){
        if (start >= end){
            // 无法再分只有一个元素
            return;
        }
        int split = (start+end)/2;
        sort(start, split, list);
        sort(split+1, end, list);
        sort1(start, split, end, list);
    }

    public static void sort1(int start, int split, int end, int[] list){
        int[] temp = new int[end-start+1];
        int index = 0;
        int i = start;
        int j = split+1;
        while (i<= split && j<=end){
            System.out.println(i+"   "+j);
            if(list[i] <= list[j]){
                temp[index++] = list[i];
                i++;
            }else {
                temp[index++] = list[j];
                j++;
            }
        }
        while (i <= split){
            temp[index++] = list[i++];
        }
        while (j <= end){
            temp[index++] = list[j++];
        }

        // 把新数组中的数覆盖nums数组
        for(int k=0;k<temp.length;k++){
            list[k+start] = temp[k];
        }
        System.out.println("临时数组"+ Arrays.toString(temp));
        System.out.println(Arrays.toString(list));
    }

}
