package 最长公共子串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 给定两个字符串str1和str2,输出两个字符串的最长公共子串
        题目保证str1和str2的最长公共子串存在且唯一。
 方法：动态规划，表格法
         str1：
 str2： 0

 示例1
 输入："1AB2345CD","12345EF"
 返回值："2345"
*/
public class Test04 {
    public static void main(String[] args) {
        String str1= "22222";
        String str2="22222";
        String lcs = LCS(str1, str2);
    }


        public static String LCS (String str1, String str2) {
        // write code here
        int[][] ints = new int[str1.length()+1][str2.length()+1];
        int max=0;
        int x=0;

        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    if (ints[i-1][j-1]>=1){
                        ints[i][j]=ints[i-1][j-1]+1;
                        if (ints[i][j]>max){
                            max= ints[i][j];
                            x=i;
                        }
                    }else {
                        ints[i][j]=1;
                        if (ints[i][j]>max){
                            max= ints[i][j];
                            x=i;
                        }
                    }
                }
            }
        }

        System.out.println(ints);
        //01AB 2345 CD
        //01 2345 EF
        String str="";
        for (int i = x-max; i <= x-1; i++) {
            //5
            str=str+str1.charAt(i);
        }
        return str;
    }
}