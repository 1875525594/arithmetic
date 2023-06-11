package floyd算法;

import java.util.ArrayList;
import java.util.List;

/** floyd算法
 在一个有 n 个点， m 个边的有向图中，
     已知每条边长，求出 1 到 n 的最短路径，返回 1 到 n 的最短路径值。
 如果 1 无法到 n ，输出 -1
 图中有重边，无自环。

 输入：5,5,[[1,2,2],
          [1,4,5],
          [2,3,3],
          [3,5,4],
          [4,5,5]]
 返回值： 9
注意：[1,2,2]，表示顶点1，2，它们之间长度为2，

 输入：2,1,[[1,2,4]]
 返回值： 4
*/
public class Test08 {
    public static void main(String[] args) {
        int[][] a={{0,1,5},{0,3,7},
                {1,2,4},{1,3,2},
                {2,0,3},{2,1,3},{2,3,2},
                {3,2,1}};
        int shortestPath = findShortestPath(4, 4, a);
        System.out.println(shortestPath);
    }

    public static int findShortestPath (int n, int m, int[][] graph) {
        int INF = 0x3f3f3f3f;
        // write code here
        int[][] newGraph = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    newGraph[i][j] = 0;
                } else {
                    newGraph[i][j] = INF;
                }
            }
        }
        //赋值，构造邻接矩阵
        for (int [] g: graph) {
            int i = g[0];
            int j = g[1];
            int value = g[2];
            //去重复边，取最短边
            newGraph[i][j]= newGraph[i][j]>=value?value:newGraph[i][j];
            //newGraph[i][j] = value;
        }

        //floyd算法,
        //paths中转点数组
        int[][] paths = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j]=-1;
            }
        }

        //构造任意点之间的最短路径（newGraph[][]二维数组表示）
        // 中转点-->i-->j
        //每次更新中转点，来更新i———>j的距离。
        for (int mid = 0; mid <n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

//                    newGraph[i][j] = newGraph[i][j] > (newGraph[i][mid] + newGraph[mid][j])
//                            ? (newGraph[i][mid] + newGraph[mid][j]) : newGraph[i][j];

                    if (newGraph[i][j] > (newGraph[i][mid] + newGraph[mid][j])){
                        newGraph[i][j]=newGraph[i][mid] + newGraph[mid][j];
                        paths[i][j]=mid;
                    }
                }
            }
        }
        System.out.println(paths.toString());
        shortestPath(1,0,paths);
        return newGraph[1][n-1] >= INF/2 ? -1 : newGraph[1][n-1];
    }

    //递归找出路径。
    public static void shortestPath (int start, int end, int[][] paths) {
        if (paths[start][end]==-1){
            //输出形式，1-3 3-2 2-0
            System.out.println(start+"-"+end);
        }else {
            int mid = paths[start][end];
            shortestPath(start,mid,paths);
            shortestPath(mid,end,paths);
        }

    }

}