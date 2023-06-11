import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 最大数
 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

 示例 1：
 输入：nums = [10,2]
 输出："210"

 示例 2：313 331
 输入：nums = [3,31,34,5,9]---9 5 3 31 30001
 输出："9534330"
 * */
public class Test22 {
    public static void main(String[] args) {
        int k =2;
        int l=98/10;
        String s =k+"";
        String s2 =l+"";
        System.out.println(l);
    }
    public String solve (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compareTo(arr[i], arr[j])) {
                    //a+b >=b+a 则不需要交换
                } else {
                    //否则进行交换
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        String res = "";
        //把数字全部拼接起来
        for (int i = 0; i < arr.length; i++) {
            if(arr[0]==0){
                res="0";
            }else{
                res += Integer.toString(arr[i]);
            }

        }
        return res;
    }

    public  boolean compareTo(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        int cmp1 = Integer.parseInt(strA + strB);
        int cmp2 = Integer.parseInt(strB + strA);
        if (cmp1 >= cmp2) {
            return true;
        } else {
            return false;
        }
    }
}
