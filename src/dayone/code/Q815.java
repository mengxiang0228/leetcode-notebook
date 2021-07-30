package dayone.code;


import javax.management.Query;
import java.util.*;

/**
 * 非自己思考
 * 815. 公交路线
 *
 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。

 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。

 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。

 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。

 * @author liyaxiang
 * @since 2021/6/28 16:57
 */
public class Q815 {


    /**
     * 学习的 广度搜索优先
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = routes.length;
        // 记录哪些站台时相通的
        boolean[][] edge = new boolean[routes.length][routes.length];
        // 每个站台可以有哪些车
        for (int i = 0; i < routes.length; i++) {// i 为公交
            for (int j : routes[i]) {
                // 记录 站台j 被公交i 路过
                List<Integer> list = map.getOrDefault(j, new ArrayList<>());// list为公交
                for (Integer k : list) {// 记录这个站台相通的公交, 即公交i路过站台j， 则公交i可以与站台j的其他公交换乘
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);
                map.put(j, list);
            }
        }

        int[] dis = new int[routes.length];// 记录每个站台步数
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new LinkedList<>();
        for (Integer bus : map.getOrDefault(source, new ArrayList<>())) {
            dis[bus] = 1;
            queue.offer(bus);
        }

        // 挨个坐起点的每辆车，然后在座换乘的每辆车
        while (!queue.isEmpty()){
            int x = queue.poll();
            for (int y = 0; y < n; y++) {
                if(edge[x][y] && dis[y] == -1){// x公交可以换乘y公交 并且y公交不是起点公交
                    dis[y] = dis[x]+1;// 则到达y的步数等于x+1
                    queue.offer(y);// 添加到队列，以后可以从y出发
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer bus : map.getOrDefault(target, new ArrayList<>())) {
            if(dis[bus] != -1){// 公交可达
                min = Math.min(min, dis[bus]);
            }
        }


        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
