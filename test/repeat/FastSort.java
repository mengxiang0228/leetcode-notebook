package repeat;


import java.util.Arrays;

/**
 * 快速排序
 *
 * @author liyaxiang
 * @since 2021/9/6 14:44
 */
public class FastSort {
    public static void main(String[] args) {
        int[] list = new int[] {6,9,5,7,8,3};
        System.out.println(Arrays.toString(list));
        fastSort(0, list.length-1, list);
    }

    public static void fastSort(int start, int end, int[] a){
        if(start < end){
            int i = start;
            int j = end;
            int temp = a[start];
            while (i < j){
                while (a[j] >= temp && i < j){
                    j--;
                }
                a[i] = a[j];
                while (a[i] <= temp && i < j ){
                    i++;
                }
                a[j] = a[i];
            }
            a[i] = temp;
            System.out.println(Arrays.toString(a));
            fastSort(start, i-1, a);
            fastSort(i+1, end, a);
        }


    }

}
