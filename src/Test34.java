import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**流水线
 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？ 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 输入描述：
 输出描述：
 示例1： 输入
 3 5
 8 4 3 2 10
 输出
 13
 */

public class Test34 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int i1 = scanner.nextInt();
            arr[i]=i1;
        }
        Arrays.sort(arr);
        int[] arr2 = new int[m];
        int sumTime=0;
        //初始化
        for (int i = 0; i < m; i++) {
            if (i<=n-1){
                arr2 [i] = arr[i];
            } else {
                sumTime=arr2[i-1];
                break;
            }
        }

        //
        int min =arr2[0];
        int j =0;
        for (int i = m; i < arr.length; i++) {
            arr2[j]=arr2 [j] + arr[i];
            j++;
            if (j>m-1){
                j=0;
            }
        }

        int max = getMax(arr2);

        System.out.println(max);
    }

    public static int getMax(int[] arr2){
        int max=arr2[0];
        for (int i = 0; i < arr2.length; i++) {
            if (max<arr2[i]){
                max=arr2[i];
            }
        }
        return max;
    }



}
