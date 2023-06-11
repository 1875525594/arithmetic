import java.util.HashMap;
import java.util.Scanner;

/**
 题目描述：小明在学习二进制时，发现了一类不含101的数，也就是：- 将数字用二进制表示，不能出现101。
    现在给定一个正整数区间[l,r]，请问这个区间内包含了多少个不含101的数？
 输入描述：输入的唯一一行包含两个正整数l,r(1<=l<r<=109)。
 输出描述：输出的唯一一行包含一个整数，表示在 [l,r] 区间内一共有几个不含 101 的数。

 示例：
 输入描述：1 10
 输出描述：8

 * */
public class Test14 {
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
        int num=0;
        for (int i = n; i <= m; i++) {
            String temp="";
            int x=0;
            for (int j = 0; j < 32; j++) {
                int k =(i>>j)&1;
                temp=k+temp;
                //方式1：代替contains
                if (temp.length()>=3 &&
                        temp.charAt(temp.length()-1-x)=='1'&&
                        temp.charAt(temp.length()-1-x-1)=='0'&&
                        temp.charAt(temp.length()-1-x-2)=='1'){
                        num++;
                        break;
                    }
                if (temp.length()>=3){
                    x++;
                }
//方式2：contains
//                if (temp.contains("101")){
//                    num++;
//                    break;
//                }
            }

            //
//            if (temp.contains("101")){
//                num++;
//            }
        }
        num=m-n+1-num;
        System.out.println("===" + num);
    }

}
