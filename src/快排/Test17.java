package 快排;

import java.util.ArrayList;
import java.util.Arrays;

/**和大于等于K的最短子数组（要连续!）
 给定一个长度为 n 的整数数组，和一个目标值 k ，请你找出这个整数数组中和大于等于 k 的最短子数组的长度。
 如果不存在和大于等于 k 的子数组则输出 -1。

 示例1
 输入：[2,1,2,3],5
 返回值：2,(因为[2,3]==5,长度==2)

 示例2
 输入：[2,3,4,5],16
 返回值：-1
 * */
public class Test17 {
    public static void main(String[] args) {
        int [] nums={2,1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);

        int i = shortestSubarray(list, 5);
        System.out.println(i);
    }

    public static int shortestSubarray (ArrayList<Integer> nums, int k) {
        // write code here
        //[2,1,2,3,5,6],5 ===>1
        //1,2,2,6,3,5
        //[6,5,3,2,2,1] 12
        int size = nums.size();
        Integer[] ints = nums.toArray(new Integer[size]);
        //System.out.println(objects);
        //1 2 3 6
        //2 3 6 1
//        for (int i = 0; i < ints.length;i++) {
//            for (int j = 0; j < ints.length-1-i; j++) {
//                if (ints[j]<ints[j+1]){
//                    int temp=ints[j];
//                    ints[j]=ints[j+1];
//                    ints[j+1]=temp;
//                }
//            }
//        }



        int i = preSubarray(ints, k);
        //int[][] dp = new int[nums.size()+1][sum+1];
        return i;
    }

    public static int preSubarray (Integer[] ints, int k) {

        int sum=0;
        for (int i = 0; i < ints.length; i++) {
            sum =sum+ ints[i];
            if (sum>=k){
                return i+1;
            }
        }

        return -1;

    }

    public static int dp (Integer[] ints, int k) {
        int[][] dp = new int[ints.length + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < k+1; j++) {
            dp[0][j]=0;
        }


        return -1;

    }

    public static void fast (Integer[] ints, int l,int r) {
        if (l>r){
            return ;
        }
        int i=l;
        int j=r;
        // 3 2 1 4 2 6 3
        int temp =ints[l];
        while (i<j){
            while (ints[j]<=temp&&i<j){
                //while (ints[j]>=temp&&i<j){
                j--;
            }
            ints[i]=ints[j];
            while (ints[i]>=temp&&i<j){
                //while (ints[i]<=temp&&i<j){
                i++;
            }
            ints[j]=ints[i];
        }
        ints[i]=temp;

        int mid=i;
        fast(ints,l,mid-1);
        fast(ints,mid+1,r);

    }

}
