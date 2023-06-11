import java.util.ArrayList;
import java.util.List;

/**
 每日温度
 给定一个整数数组 temperatures ，表示每天的温度，
 返回一个数组 answer，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 如果气温在这之后都不会升高，请在该位置用 0 来代替。

 示例 1:
 输入: temperatures = [73,74,75,71,69,72,76,73]
 输出: [1,1,4,2,1,1,0,0]

 示例 2:
 输入: temperatures = [30,40,50,60]
 输出: [1,1,1,0]

 示例 3:
 输入: temperatures = [30,60,90]
 输出: [1,1,0]

 * */
public class Test20 {
    public static void main(String[] args) {
        int temperatures[]={73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures1(temperatures);
        System.out.println(ints);
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp=1;
            //73,74,75,71,69,72,76,73
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[i]<temperatures[j]){
                    temp=j-i;
                    arr[i]=temp;
                    break;
                }
                arr[i]=0;
            }

        }

        return arr;
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        arr[temperatures.length-1]=0;
        //73,74,75,71,69,72,76,73
        //1 , 1, 4, 2, 1, 1, 0, 0
        for (int i = temperatures.length-2; i > 0; i--) {
            if (temperatures[i]<temperatures[i+1]){
                arr[i]=1;
            }else {
                dg(arr,i,i,temperatures);
            }
        }

        return arr;
    }

    public static void dg(int[] arr,int i,int j,int[] temperatures) {
        //0 , 1, 2, 3, 4, 5, 6, 7
        //73,74,75,71,69,72,76,73
        //1 , 1, 4, 2, 1, 1, 0, 0
       int k= arr[j+1]+j+1;
       if (arr[k]==0){
           k= arr[j+1]+j;
       }
       int index=k;
       System.out.println(arr[i]+"--"+arr[index]);
       if (temperatures[i]>temperatures[index]){
            dg(arr,i,index,temperatures);
       }else {
           arr[i]=index-i;
       }

    }

}
