package dayone.code;


import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * LCP 07. 传递信息
 *
 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：

 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人

 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。

 示例 1：

 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3

 输出：3

 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。

 示例 2：

 输入：n = 3, relation = [[0,2],[2,1]], k = 2

 输出：0

 解释：信息不能从小 A 处经过 2 轮传递到编号 2

 限制：

 2 <= n <= 10
 1 <= k <= 5
 1 <= relation.length <= 90, 且 relation[i].length == 2
 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]


 * @author liyaxiang
 * @since 2021/7/1 14:32
 */
public class LCP07 {
    @Test
    public void test1(){
        assertEquals(DFS.numWays(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3), 3);
    }
    /**
     * 广度搜索优先
     * 一层一层往下周 总共k层
     */
    static class BFS{

        public static int numWays(int n, int[][] relation, int k) {
            int end = n-1;

            Map<Integer, List<Integer>> map = new HashMap<>(16);
            // 记录路线
            for (int[] ints : relation) {
                List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
                list.add(ints[1]);
                map.put(ints[0], list);
            }
            int step = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            while (!queue.isEmpty() && step < k){
                // 走k步看都能走到哪些节点
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int index = queue.poll();
                    List<Integer> list = map.getOrDefault(index, new ArrayList<>());
                    for (Integer next : list) {
                        queue.offer(next);
                    }
                }
            }

            int allWay = 0;
            if(step == k){
                while (!queue.isEmpty()){// 能走k步走到
                    if(queue.poll() == n){
                        allWay++;
                    }
                }
            }
            return allWay;
        }


    }

    /**
     * 动态规划
     */
    static class DP{
        public static int numWays(int n, int[][] relation, int k) {
            int[][] dp = new int[k + 1][n];
            dp[0][0] = 1;
            for (int i = 0; i < k; i++) {
                for (int[] ints : relation) {
                    dp[i+1][ints[1]] += dp[i][ints[0]];
                }
            }
            return dp[k][n-1];
        }
    }
    /**
     * 深度搜索优先算法
     * 先按一条线一直往下走
     */
    static class DFS{
        private static int allWay = 0;

        public static int numWays(int n, int[][] relation, int k) {
            int end = n-1;

            Map<Integer, List<Integer>> map = new HashMap<>(16);
            // 记录路线
            for (int[] ints : relation) {
                List<Integer> list = map.getOrDefault(ints[0], new ArrayList<>());
                list.add(ints[1]);
                map.put(ints[0], list);
            }
            dfs(0, 0, n, k, map);
            return allWay;
        }

        /**
         * 深度优先
         * @param index 当前位置
         * @param steps 已走步数
         * @param k
         * @param wapMap
         */
        public static void dfs(int index, int steps, int n, int k, Map<Integer, List<Integer>> wapMap ){
            if(steps ==k){
                if(index == n-1){
                    allWay += 1;
                }
                return;
            }
            for (Integer toUser : wapMap.getOrDefault(index, new ArrayList<>(0))) {
                dfs(toUser, steps+1, n, k, wapMap);
            }
        }
    }

}
