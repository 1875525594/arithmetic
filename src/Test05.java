/** 给定两个字符串str1和str2,输出两个字符串的最长公共子串
        题目保证str1和str2的最长公共子串存在且唯一。
 方法：动态规划，表格法
         str1：
 str2： 0
*/
public class Test05 {
    public static void main(String[] args) {

    }


    public char[][] surroundedArea (char[][] board) {
        // write code here
        //
        //找边界入口 ---
        for (int j= 0; j <board[0].length; j++) {
            if (board[0][j]=='O'){
                dfs(board,0,j);
            }
            if (board[board.length-1][j]=='O'){
                dfs(board,board.length-1,j);
            }
        }
        // |
        for (int i = 0; i < board.length; i++) {
            if (board[i][0]=='O'){
                dfs(board,i,0);
            }
            if (board[i][board.length-1]=='O'){
                dfs(board,i,board.length-1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='a'){
                    board[i][j]='X';
                }
            }
        }

        return board;
    }
    public static void dfs (char[][] board,int i,int j) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] != 'O'){
            return ;
        }
        board[i][j]='a';
        dfs(board, i + 1, j);//上
        dfs(board, i - 1, j);//下
        dfs(board, i, j + 1);//右
        dfs(board, i, j - 1);//左
    }
}