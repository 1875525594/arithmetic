package dfs与bfs;

/**找单词
 给一个符串和一个二维字符数组，如果该字符串存在于该数组中，
 则按字符串的字符顺序输出字符每一个字符所在单元格的位置下标字符串，如果找不到返回字符串"N"。

 1，需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是水平相邻或垂直相邻的单元格。
 2，同一个单元格内的字母不允许被重复使用。
 3，找单词，给定N*N矩阵，目标单词，返回坐标。（矩阵中只含有一条路径）

 例子：
 N=4
 D,D,C,A
 A,A,D,D
 C,A,T,G
 F,G,H,N

 目标单词：CDAATG
 输出0,2, 1,2, 1,1, 2,1, 2,2, 2,3

 */

public class Test38 {
    public static void main(String[] args){
        Test38 test38 = new Test38();
        char[][] chars = {
                {'A','A','A'},
                {'A','B','A'}};

        boolean cdaatg = test38.exist(chars, "AAB");
        System.out.println(cdaatg);
    }

//    public  void f(char[][] grid,String str){
//        int N = grid.length;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (grid[i][j]==str.charAt(0)){
//                    ArrayList<Integer> dfs = dfs1(grid, i, j, str, 0, list);
//                    if (dfs.size()!=0) System.out.println(list);
//                }
//            }
//        }
//
//    }
//
//    public ArrayList<Integer> dfs1(char[][] grid,int i,int j,String str,int k,ArrayList<Integer> list) {
//        if (i<0||i>=grid.length||j<0||j>=grid[0].length){
//            return null;
//        }
//
//        if (grid[i][j]!=str.charAt(k)) return null;
//
//
//
//        System.out.println("=="+k);
//        // N=4
//        // D,D,C,A
//        // A,A,D,D
//        // C,A,T,G
//        // F,G,H,N
//        if (grid[i][j]==str.charAt(k)){
//            grid[i][j]='a';
//            k++;
//            list.add(i);
//            list.add(j);
//            if (k<str.length()){
//                dfs1(grid,i,j+1,str,k,list);
//                dfs1(grid,i+1,j,str,k,list);
//                dfs1(grid,i,j-1,str,k,list);
//                dfs1(grid,i-1,j,str,k,list);
//            }
//        }
//
//        if (k==str.length()-1) list.clear();
//        return list;
//    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1){
            System.out.println(i+","+j);
            return true;
        }

        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = 'a';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res =
                dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);
        if (res==true) System.out.println(i+","+j);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }

    boolean dfs3(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0
                || j >= board[0].length || j < 0
                || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
//        board[i][j] = 'a';
        //走递归，沿着当前坐标的上下左右4个方向查找
        dfs3(board, word, i + 1, j, index + 1);
        dfs3(board, word, i - 1, j, index + 1);
        dfs3(board, word, i, j + 1, index + 1);
        dfs3(board, word, i, j - 1, index + 1);

        //递归之后再把当前的坐标复原
//        board[i][j] = tmp;
        return false;
    }

//    public boolean exist1(char[][] board, String word) {
//
//        for (int x = 0; x < board.length; x++) {
//            for (int y = 0; y < board[0].length; y++) {
//                if (board[x][y]==word.charAt(0)){
//                    int[][] arr = new int[board.length][board[0].length];
//                    int k=0;
//                    arr[x][y]=-1;
//                    int i=x;
//                    int j=y;
//                    if (word.length()<=1){
//                        return true;
//                    }else while (true){
//                        k++;
//                        if (i+1<=board.length-1&&arr[i+1][j]!=-1&&board[i+1][j]==word.charAt(k)){
//                            arr[i+1][j]=-1;
//                            i++;
//                        }else if (i-1>=0&&arr[i-1][j]!=-1&&board[i-1][j]==word.charAt(k)){
//                            arr[i-1][j]=-1;
//                            i--;
//                        }else if (j+1<=board[0].length-1&&arr[i][j+1]!=-1&&board[i][j+1]==word.charAt(k)){
//                            arr[i][j+1]=-1;
//                            j++;
//                        }else if (j-1>=0&&arr[i][j-1]!=-1&&board[i][j-1]==word.charAt(k)){
//                            arr[i][j-1]=-1;
//                            j--;
//                        }else {//以上都找不到，break;
//                            break;
//                        }
//                        if (k==word.length()-1){
//                            return true;
//                        }
//                    }
//                }
//
//
//
//            }
//        }
//
//        return false;
//    }





}
