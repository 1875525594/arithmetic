/**对角线遍历
 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。

 示例 1：
 输入：mat = [
             [1,2,3,2],
             [4,5,6,2],
             [7,8,9,2]
            ]
 输出：[1,2,4,7,5,3,6,8,9]

 示例 2：
 输入：mat = [
            [1,2],
            [3,4]
            ]
 输出：[1,2,3,4]


 提示：
 m == mat.length
 n == mat[i].length
 1 <= m, n <= 104
 1 <= m * n <= 104
 -105 <= mat[i][j] <= 105
 */

public class Test33 {
    public static void main(String[] args){
        Test33 test33 = new Test33();
        int [][]mat={{1,2,3},{4,5,6},{7,8,9}};
        test33.findDiagonalOrder(mat);
        //System.out.println(i);
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int length = mat.length;
        int k=length*length;
        int[] arr = new int[k];
        int l=0;
        int temp=0;
        for (int i = 0; i < mat.length; i++) {
            if (temp%2!=0){
                int[] raw = findRaw(mat, i);
                int[] reverse = reverse(raw);
                for (int j = 0; j < reverse.length; j++) {
                    arr[l]=reverse[j];
                    l++;
                }
            }else {
                int[] raw = findRaw(mat, i);
                for (int j = 0; j < raw.length; j++) {
                    arr[l]=raw[j];
                    l++;
                }
            }
            temp++;
        }

        for (int i = 1; i < mat.length - 1; i++) {
            if (temp%2!=0){
                int[] raw = findRawJ(mat, i);
                int[] reverse = reverse(raw);
                for (int j = 0; j < reverse.length; j++) {
                    arr[l]=reverse[j];
                    l++;
                }
            }else {
                int[] raw = findRawJ(mat, i);
                for (int j = 0; j < raw.length; j++) {
                    arr[l]=raw[j];
                    l++;
                }
            }
            temp++;
        }

        return arr;
    }


    public int[] findRaw(int[][] mat,int k) {
        int l=0;
        int[] arr = new int[k+1];
        int i=k;
        int j=0;
        while (true){
            arr[l]=mat[i][j];
            i--;
            j++;
            l++;
            if (i<0)break;
        }
        return arr;
    }

    public int[] findRawJ(int[][] mat,int k) {
        //输入：mat = [
        //             [1,2,3,2],
        //             [4,5,6,2],
        //            ]
        int l=0;
        int[] arr = {};//3-1+1
        int i= mat.length-1;//3
        int j=k;//1
        while (true){
            arr[l]=mat[i][j];
            i--;
            j++;
            l++;
            if (j>=mat.length)break;
        }
        return arr;
    }

    public int[] reverse(int[]arr) {
        int[] ints = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            ints[arr.length-1-i]=arr[i];
        }
        return ints;
    }


}
