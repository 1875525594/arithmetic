package dfs与bfs;

/**岛屿数量
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 此外，你可以假设该网格的四条边均被水包围。

 示例 1：
 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1

 示例 2：
 输入：grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 输出：3

 提示：
 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] 的值为 '0' 或 '1'
 */

public class Test30 {
    public static void main(String[] args){
        Test30 test30 = new Test30();
        char[][] intervals={
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
//        char[][] intervals={
//                {'1','0','1','1','0','1','1'},
//        };
        int i = test30.numIslands(intervals);
        System.out.println(i);
        //System.out.println(merge);
    }

    public int numIslands(char[][] grid) {
        int k=0;
        System.out.println(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    System.out.println(grid);
                    k++;
                }
            }
        }
        return k;
    }

    public void dfs(char[][] grid,int i,int j) {
        if (i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if (i>=0&&i<=grid.length-1&&j>=0&&j<=grid[0].length-1){
            if (grid[i][j]=='0'||grid[i][j]=='2') return;
        }
        grid[i][j]='2';
        dfs(grid,i,j+1);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);
    }

}
