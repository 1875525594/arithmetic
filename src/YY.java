import java.util.Scanner;

public class YY {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        int m = 0;
        while (in.hasNextInt()) { // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n = in.nextInt();
            m = in.nextInt();
            //System.out.println(a + b);
            break;
        }

        int[][] g = new int[n][m];
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    g[i][j] = in.nextInt();
                }
            }
            //System.out.println(a + b);
            break;
        }
        int num = 0;
        int dfs = dfs(g, 0, 0, num);
        System.out.println("==="+dfs);
        System.out.println(num);


    }
    //
    public static int dfs(int[][] g, int i, int j, int num) {
        //不是1，直接return
        if (i < 0 || i >= g.length
                || j < 0 || j >= g[0].length
                || g[i][j] != 1) {
            return 100;
        }

        if (g[i][j] == 1) {
            //路过，置为0
            g[i][j] = 0;
            dfs(g, i, j + 1, num); //右
            dfs(g, i + 1, j, num); //下
            dfs(g, i, j - 1, num); //左
            num++;
        }

        if (g[i][j] == 0) {
            dfs(g, i, j + 1, num); //右
            dfs(g, i + 1, j, num); //下
            dfs(g, i, j - 1, num); //左
            dfs(g, i - 1, j, num); //上
        }
        return num;

    }
}
