package repeat;


import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 排序
 *
 * @author liyaxiang
 * @since 2022/11/2 10:22
 */
public class FastSort20221102 {
    public static void main(String[] args) {
        int[] list = new int[] {6,9,5,7,8,3};
        System.out.println(Arrays.toString(list));
        fastSort(0, list.length-1, list);
        System.out.println(Arrays.toString(list));
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
//        Executor
//        Future
//        Callable
//        AtomicInteger
    }


    public static void fastSort(int start, int end, int[] list){
        if(start >= end || list.length <= 1){
            return;
        }
        int midPoint = list[start];
        int i = start;
        int j = end;

        while (i<j){
            while (list[j] > midPoint && i <j){
                j --;
            }
            list[i] = list[j];
            while (list[i] <= midPoint && i<j){
                i++;
            }
            list[j] = list[i];
        }
        list[i] = midPoint;
        System.out.println(Arrays.toString(list));
        fastSort(start, i-1, list);
        fastSort(i+1, end, list);
    }
}
