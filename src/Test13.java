import java.util.HashMap;
import java.util.Scanner;
/**
 信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，取值范围为1~65535，用一个数组记录误码出现的情况，
 每个误码出现的次数代表误码频度，请找出记录中包含频度最高误码的最小子数组长度。

 输入描述
 误码总数目：取值范围为0~255，取值为0表示没有误码的情况。
 误码出现频率数组：误码ID范围为1~65535，数组长度为1~1000。

 输出描述
 包含频率最高的误码最小子数组长度

 示例1
 输入:
 5
 1 2 2 4 1
 输出:2
 说明:频度最高的有1和2，他们的频度均为2.
 可能的记录数组为[2,2]和 [1,2,2,4,1]
 最短的长度为2.

 示例2
 输入:
 7
 1 2 2 4 2 1 1
 输出:4
 说明最短的为[2,2,4,2]

 * */
public class Test13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (in.hasNextInt()) { // 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            n = in.nextInt();
            //System.out.println(a + b);
            break;
        }

        int[] ints = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            for (int i = 0; i < n; i++) {
                ints[i] = in.nextInt();
            }
            //System.out.println(a + b);
            break;
        }

        int max=0;
        int index=-1;
        for (int i = 0; i < ints.length; i++) {
            if (hashMap.containsKey(ints[i])){
                Integer integer = hashMap.get(ints[i]);
                integer++;
                hashMap.put(ints[i],integer);
                if (integer>max){
                    max=integer;
                    index=i;
                }
            }else {
                hashMap.put(ints[i],0);
            }

        }

        //1 22 3
        int temp = ints[index];
        int l=0;
        for (int i = 0; i < index; i++) {
            if (ints[i]==temp){
                l=index-i+1;
                break;
            }
        }

        System.out.println("===" + l);
    }

}
