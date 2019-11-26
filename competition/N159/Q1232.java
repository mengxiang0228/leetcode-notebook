package N159;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * @author lyx 
 * @date 2019年11月4日 下午2:21:13 
 *
 */
public class Q1232 {
	
	@Test
	public void test() {
//		int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		int[][] coordinates = {{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}};
		assertEquals(checkStraightLine(coordinates), true);
	}
	
	public boolean checkStraightLine(int[][] coordinates) {
		int[] one = coordinates[0];
		int[] two = coordinates[1];
		double k = 0;
		if((one[0]-two[0]) != 0) {
			k = (one[1]-two[1])/(one[0]-two[0]);// (y2-y1) = k(x2-x1)
		}
		double b = one[1] - k*one[0];// b = y-kx
		for (int i = 2; i < coordinates.length; i++) {
			int[] js = coordinates[i];
			if(k*js[0]+b != js[1]) {
				return false;
			}
			
		}
		return true;
        
    }
	
	
}
