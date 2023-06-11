package dfs与bfs;

import java.util.*;

/**BFS
 腐烂的橘子
 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 值 0 代表空单元格；
 值 1 代表新鲜橘子；
 值 2 代表腐烂的橘子。
 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

 示例 1：
 输入：grid = [[2,1,1],
             [1,1,0],
             [0,1,1]]
 输出：4

 示例 11：
 输入：grid = [[2,1,1],
             [1,1,0],
             [0,1,2]]
 输出：2

 2 2
 示例 2：
 输入：grid = [[2,1,1],
             [0,1,1],
             [1,0,1]]
 输出：-1
 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。

 示例 3：
 输入：grid = [[0,2]]
 输出：0
 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 返回：直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。

 注意：可能有多个橘子！则使用 多源广度优先遍历！
 * */
public class Test23 {
    public static void main(String[] args) {
        int k =2;
        int l=98/10;
        String s =k+"";
        String s2 =l+"";
        System.out.println(l);
    }
    public int orangesRotting(int[][] grid) {


        // 边界 长宽
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // count 表示新鲜橘子的数量
        int count = 0;

        // 遍历二维数组 找出所有的新鲜橘子和腐烂的橘子
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                // 新鲜橘子计数
                if (grid[r][c] == 1) {
                    count++;
                    // 腐烂的橘子就放进队列
                } else if (grid[r][c] == 2) {
                    // 缓存腐烂橘子的坐标
                    queue.add(new int[]{r, c});
                }
            }
        }

        // round 表示腐烂的轮数，或者分钟数
        int round = 0;

        // 如果有新鲜橘子 并且 队列不为空
        // 直到上下左右都触及边界 或者 被感染的橘子已经遍历完
        while (count > 0 && !queue.isEmpty()) {

            // BFS 层级 + 1
            round++;

            // 拿到当前层级的腐烂橘子数量， 因为每个层级会更新队列
            int n = queue.size();

            // 遍历当前层级的队列
            for (int i = 0; i < n; i++) {
                // 踢出队列（拿出一个腐烂的橘子）
                int[] orange = queue.poll();
                // 退出橘子的坐标
                int r = orange[0];
                int c = orange[1];
                // ↑ 上邻点 判断是否边界 并且 上方是否是健康的橘子
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    // 感染它
                    grid[r-1][c] = 2;
                    // 好橘子 -1
                    count--;
                    // 把被感染的橘子放进队列 并缓存
                    queue.add(new int[]{r-1, c});
                }

                // ↓ 下邻点 同上
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }

                // ← 左邻点 同上
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }

                // → 右邻点 同上
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }

            }
        }

        // 如果此时还有健康的橘子
        // 返回 -1
        // 否则 返回层级
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }

}
