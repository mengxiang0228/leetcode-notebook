package N168;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

/**
 * 1298. 你能从盒子里获得的最大糖果数
 * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：

    状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
    糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
    钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
    内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。

给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。

请你按照上述规则，返回可以获得糖果的 最大数目 。

 * @author lyx 
 * @date 2019年12月24日 下午3:26:26 
 *
 */
public class Q1298 {

	@Test
	public void test() {
		int[] status =  {1,0,1,0};
		int[] candies =  {7,5,4,100};
		int[][] keys = {{},{},{1},{}};
		int[][] containedBoxes = {{1,2},{3},{},{}};
		int[] initialBoxes = {0};
		int num = maxCandies1(status, candies, keys, containedBoxes, initialBoxes);
		System.out.println(num);
		assertEquals(num, 16);
	}
	
	@Test
	public void test1() {
		int[] status =  {1,0,0,0,0,0};
		int[] candies =  {1,1,1,1,1,1};
		int[][] keys = {{1,2,3,4,5},{},{},{},{},{}};
		int[][] containedBoxes = {{1,2,3,4,5},{},{},{},{},{}};
		int[] initialBoxes = {0};
		int num = maxCandies1(status, candies, keys, containedBoxes, initialBoxes);
		System.out.println(num);
		assertEquals(num, 6);
	}
	@Test
	public void test2() {
		int[] status =  {1,1,1};
		int[] candies =  {100,1,100};
		int[][] keys = {{},{0,2},{}};
		int[][] containedBoxes = {{},{},{}};
		int[] initialBoxes = {1};
		int num = maxCandies1(status, candies, keys, containedBoxes, initialBoxes);
		System.out.println(num);
		assertEquals(num, 1);
	}
	
	@Test
	public void test3() {
		int[] status =  {1};
		int[] candies =  {100};
		int[][] keys = {{}};
		int[][] containedBoxes = {{}};
		int[] initialBoxes = {};
		int num = maxCandies1(status, candies, keys, containedBoxes, initialBoxes);
		System.out.println(num);
		assertEquals(num, 0);
	}
	@Test
	public void test4() {
		int[] status =  {1,1,1};
		int[] candies =  {2,3,2};
		int[][] keys = {{},{},{}};
		int[][] containedBoxes = {{},{},{}};
		int[] initialBoxes = {2,1,0};
		int num = maxCandies1(status, candies, keys, containedBoxes, initialBoxes);
		System.out.println(num);
		assertEquals(num, 7);
	}
	
	/**
	 * 内存
	 * @param status			盒子是否开启 1开 0关
	 * @param candies			糖果数量
	 * @param keys				盒子的钥匙
	 * @param containedBoxes	盒子里面的盒子
	 * @param initialBoxes		初始给的盒子
	 * @return
	 */
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		List<Integer> canUseBox = new ArrayList<>();
		List<Integer> noUseBox = new ArrayList<>();
		int num = 0; // 糖果数
		// 初始化盒子
		for (int boxId : initialBoxes) {
			if(status[boxId] == 0) {
				// 盒子是关的
				noUseBox.add(boxId);
			}else {
				canUseBox.add(boxId);
			}
		}
		
		for (int i = 0; i < canUseBox.size(); i++) {
			int boxId = canUseBox.get(i);
//			System.out.println("开启盒子:"+boxId);
			num += candies[boxId];// 增加糖果数
			int[] boxs =  containedBoxes[boxId]; //盒子里的盒子
			int[] boxKeys = keys[boxId]; // 盒子里的钥匙
//			System.out.println("盒子里的盒子："+Arrays.toString(boxs) +"  ;  盒子里的钥匙:"+Arrays.toString(boxKeys));
			// 获取盒子里的盒子
			for (Integer sunBoxId : boxs) {
				if(status[sunBoxId] == 0) {
					// 盒子是关的
					noUseBox.add(sunBoxId);
				}else {
					canUseBox.add(sunBoxId);
				}
			}
			// 用钥匙将盒子开启
			for (Integer key : boxKeys) {
				status[key] = 1;// 有钥匙没盒子情况
				if(noUseBox.contains(key)) {
					// 钥匙能开启现有的盒子
					canUseBox.add(key);
				}
			}
		}
		
		return num;
        
    }
	
	/**
	 * 优化 内存使用，使用队列出队(先到先出)
	 * @param status
	 * @param candies
	 * @param keys
	 * @param containedBoxes
	 * @param initialBoxes
	 * @return
	 */
	public int maxCandies1(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		Queue<Integer> canUseBoxQuery = new LinkedList<>();
		Set<Integer> noUseBox = new HashSet<>();
		int num = 0; // 糖果数
		// 初始化盒子
		for (int boxId : initialBoxes) {
			if(status[boxId] == 0) {
				// 盒子是关的
				noUseBox.add(boxId);
			}else {
				canUseBoxQuery.add(boxId);
			}
		}
		
		while (!canUseBoxQuery.isEmpty()) {
			int boxId = canUseBoxQuery.poll();
			num += candies[boxId];// 增加糖果数
			int[] boxs =  containedBoxes[boxId]; //盒子里的盒子
			int[] boxKeys = keys[boxId]; // 盒子里的钥匙
//			System.out.println("盒子里的盒子："+Arrays.toString(boxs) +"  ;  盒子里的钥匙:"+Arrays.toString(boxKeys));
			// 获取盒子里的盒子
			for (Integer sunBoxId : boxs) {
				if(status[sunBoxId] == 0) {
					// 盒子是关的
					noUseBox.add(sunBoxId);
				}else {
					canUseBoxQuery.add(sunBoxId);
				}
			}
			// 用钥匙将盒子开启
			for (Integer key : boxKeys) {
				status[key] = 1;// 有钥匙没盒子情况
				if(noUseBox.remove(key)) {
					// 钥匙能开启现有的盒子
					canUseBoxQuery.add(key);
				}
			}
		}
		
		return num;
        
    }
	public static void main(String[] args) {
		List<Integer> hasBox = new ArrayList<>();// 有的盒子
		hasBox.add(1);
		int a = 0;
		for (int i = 0; i < hasBox.size(); i++) {
			if(a == 2) {
				break;
			}
			hasBox.add(++a);
		}
		System.out.println(hasBox);
	}
}
