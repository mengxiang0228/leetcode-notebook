package N158;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 1222
 * 
 * @author lyx 
 * @date 2019年10月17日 下午3:45:14 
 *
 */
public class QueensKillKing {
	
	@Test
	public void queensAttacktheKingTest() {
		int[][] queens = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
		int[] king = {3,4};
//		int[] king = {0,0};
		List<List<Integer>> list = queensAttacktheKing(queens, king);
		System.out.println(list);
	}
	
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
//		int length = queens.length;
		int kingLeft =  king[1];// 横
		int kingTop = king[0];// 竖
		
		int[] hasValue = {99,99,99,99,99,99,99,99};
		for (int i = 0; i < queens.length; i++) {
			int queensTop = queens[i][0];
			int queensLeft = queens[i][1];
			int topDiff = kingTop - queensTop;
			int leftDiff = kingLeft-queensLeft;
//			System.out.println("["+queensTop+","+queensLeft+"]  "+topDiff +" "+ leftDiff);
			if(leftDiff == 0) {
				if(queensTop < kingTop && (hasValue[0] == 99 || queensTop > queens[hasValue[0]][0])) {
					hasValue[0] = i;
//					System.out.println("左侧有值");
				}else if(queensTop > kingTop && (hasValue[1] == 99 ||  queensTop < queens[hasValue[1]][0])) {
					hasValue[1] = i;
//					System.out.println("右侧有值");
				}
			}else if (topDiff == 0) {
				if(queensLeft < kingLeft && (hasValue[2] == 99 || queensLeft > queens[hasValue[2]][1])) {
					hasValue[2] = i;
//					System.out.println("上侧有值");
				}else if(queensLeft > kingLeft && (hasValue[3] == 99 || queensLeft < queens[hasValue[3]][1])) {
					hasValue[3] = i;
//					System.out.println("下侧有值");
				}
			}else if (Math.abs(topDiff) == Math.abs(leftDiff)) {
				
				//斜向
				if(topDiff < 0 && leftDiff < 0 && (hasValue[4] == 99 || topDiff > (kingTop - queens[hasValue[4]][0]))) {
					// 右下
					hasValue[4] = i;
//					System.out.println("右下有值");
				}else if (topDiff < 0 && leftDiff > 0 && (hasValue[5] == 99 || topDiff > (kingTop - queens[hasValue[5]][0]))) {
					// 左下
					hasValue[5] = i;
//					System.out.println("左下有值");
				}else if (topDiff > 0 && leftDiff < 0 && (hasValue[6] == 99 || topDiff < (kingTop - queens[hasValue[6]][0]))) {
					// 右下
					hasValue[6] = i;
//					System.out.println("右下有值");
				}else if (topDiff > 0 && leftDiff > 0 && (hasValue[7] == 99 || topDiff < (kingTop - queens[hasValue[7]][0]))) {
					// 左上
					hasValue[7] = i;
//					System.out.println("左上有值");
				}
				
			}
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>(8);
		List<Integer> list2 = null;
		for (int i =  0; i < 8; i++) {
			int index = hasValue[i];
			if(index != 99) {
				list2 = new ArrayList<Integer>(2);
				list2.add(queens[index][0]);
				list2.add(queens[index][1]);
				list.add(list2);
			}
		}
		return list;
        
    }
}
