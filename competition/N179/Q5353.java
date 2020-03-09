package N179;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import sun.security.krb5.KdcComm;
import sun.tools.jar.resources.jar;

/**
 * 5353. 灯泡开关 III
 * 
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。

在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。

灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：

    灯处于打开状态。
    排在它之前（左侧）的所有灯也都处于打开状态。

请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。

 * @author lyx 
 * @date 2020年3月9日 上午11:37:04 
 *
 */
public class Q5353 {

	@Test
	public void numTimesAllBlueTest() {
//		assertEquals(numTimesAllBlue(new int[] {2,1,3,5,4}), 3);
//		assertEquals(numTimesAllBlue(new int[] {3,2,4,1,5}), 2);
//		assertEquals(numTimesAllBlue(new int[] {4,1,2,3}), 1);
//		assertEquals(numTimesAllBlue(new int[] {2,1,4,3,6,5}), 3);
//		assertEquals(numTimesAllBlue(new int[] {1,2,3,4,5,6}), 6);
		assertEquals(numTimesAllBlue(new int[] {2,3,1}), 1);
	}
	
    public int numTimesAllBlue1(int[] light) {
    	int[] data = new int[light.length]; //1 = 亮； 2 = 蓝 
    	int brightNum = 0;// 亮的没变蓝的
    	int size = 0;
    	for (int i = 0; i < light.length; i++) {
    		int j = light[i]-1;
    		data[j] = 1; // 将j位置的灯点亮
    		brightNum ++;
			if(j == 0 || data[j-1] == 2) {
				// 前面的灯是蓝的，说明之前的灯都是蓝的
				data[j] = 2;
				brightNum --;// 减没变蓝的灯数
				int k = j+1;
				while (k < light.length && data[k] == 1) {
					// 判断后面当前灯后面的是否点亮，点亮则变色
					data[k] = 2;
					k++;
					brightNum --;
				}
				if(brightNum <= 0) {
					// 没有亮着没变蓝的灯
					size ++;
				}
			}
//			System.out.println(Arrays.toString(data));
//			System.out.println(size);
		}
		return size;
    }
    
    public int numTimesAllBlue(int[] light) {
    	int lightNum = 0;// 亮的灯数
    	int size = 0;
    	for (int i = 0; i < light.length; i++) {
    		lightNum = Math.max(lightNum, light[i]);
    		if(lightNum == i+1) {
    			size++;
    		}
//			System.out.println(Arrays.toString(data));
//			System.out.println(size);
		}
		return size;

    }
    
}
