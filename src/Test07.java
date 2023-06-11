import java.util.*;

/** 相关企业

*/
public class Test07 {
    public static void main(String[] args) {
        //= new int[5][2];
//        int[][] ints={{1,2},{4,5},{7,10},{2,3},{4,4}};
//        for (int i = 0; i < ints.length; i++) {
//            int anInt = ints[0];
//            System.out.println("==="+anInt);
//        }
        //[0,1],[0,2],[3,5],[5,4],[4,3]
                        //4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4
        //int[][] ints={{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        int[][] ints={{0,1},{1,2},{2,0}};
        boolean b = validPath(3, ints, 0, 2);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        //相当于创建了一个大小为n的一维数组，类型为List类型。
        //对比，new int[n] adj , 创建了一个大小为n的一维数组,类型为int
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        //直连的端点，放入数组中adj[]中
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            adj[x].add(y);
            adj[y].add(x);
        }

        boolean[] visited = new boolean[n];
        //
        dfs(source, destination, adj, visited);
        return visited[destination];

    }

    public static boolean dfs(int source, int destination, List<Integer>[] adj, boolean[] visited) {
        visited[source] = true;
        if (source == destination) {
            return true;
        }

        for (int i = 0; i < adj[source].size(); i++) {
            int next=adj[source].get(i);
            if (!visited[next]){
                dfs(next,destination,adj,visited);
            }
        }
//        for (int next : adj[source]) {
//            if (!visited[next] && dfs(next, destination, adj, visited)) {
//                return true;
//            }
//        }
        return false;
    }

}