/** Dijkstra算法
 在一个有 n 个点， m 个边的有向图中，
 已知每条边长，求出 1 到 n 的最短路径，返回 1 到 n 的最短路径值。
 如果 1 无法到 n ，输出 -1
 图中有重边，无自环。

 输入：5,5,[[1,2,2],[1,4,5],[2,3,3],[3,5,4],[4,5,5]]
 返回值： 9

 输入：2,1,[[1,2,4]]
 返回值： 4
*/
public class Test09 {
    public static void main(String[] args) {
        int[][] a={{1,2,2},{1,4,5},{2,3,3},{5,3,4}};
        int shortestPath = findShortestPath(5, 5, a);
        System.out.println(shortestPath);
    }

    public static int findShortestPath (int n, int m, int[][] graph) {
        int INF = 0x3f3f3f3f;
        // write code here
        int[][] newGraph = new int[n + 10][n + 10];
        //初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    newGraph[i][j] = 0;
                } else {
                    newGraph[i][j] = INF;
                }
            }
        }
        //赋值，获取邻接矩阵
        for (int [] g: graph) {
            int i = g[0];
            int j = g[1];
            int value = g[2];
            //去重复边，取最短边
            newGraph[i][j]= newGraph[i][j]>=value?value:newGraph[i][j];
            //newGraph[i][j] = value;
        }

        //Dijkstra算法
        Boolean[] view = new Boolean[n+1];
        //权值
        int[] pathValue = new int[n+1];
        //顶点名
        int[] path = new int[n+1];
        for (int i = 1; i <=n; i++) {
            pathValue[i]=-1;
            path[i]=-1;
        }



        return newGraph[1][n] >= INF/2 ? -1 : newGraph[1][n];
    }
    public static void Dijkstra (int n, int sources, int[][] newGraph,Boolean[] view,int[] pathValue,int[] path ) {

        for (int i = 1; i <=n ; i++) {
            int min =10000;
            for (int j = 1; j <= n; j++) {
                if (newGraph[i][j]<=min){
                    newGraph[i][j]=min;
                }

                pathValue[i]=newGraph[i][j]+path[i];
                path[i] = i;
            }
        }
    }
}