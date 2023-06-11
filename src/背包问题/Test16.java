package 背包问题;

import java.util.Scanner;

/**01背包问题。
 步骤：创建数组dp[i][j]来存储贪心值，
 i代表参与的物品的编号，j代表目前最大容量大小。
 其中 i--对应->nums[i-1]


 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 示例 1：
 输入：nums = [1,5,11,5]
 输出：true
 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。

 示例 2：
 输入：nums = [1,2,3,5]
 输出：false
 解释：nums 不可以分为和相等的两部分


 提示：
 1 <= nums.length <= 200
 1 <= nums[i] <= 100
 * */
public class Test16 {
    public static void main(String[] args) {
        int [] nums={1,2,3,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int k;
        if (sum%2!=0){
            return false;
        }else {
            k=sum/2;
        }


        int[][] ints = new int[nums.length + 1][k + 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i][0]=0;
        }
        for (int j = 0; j < ints[0].length; j++) {
            ints[0][j]=0;
        }
         //  0 1 2 3 4
         //0 0 0 0 0 0
//   1,1 //1 0 1 1 1 1
//   1,1 //2 0 1 2 3 3
//   2,2 //3 0 1 2 3 4
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 1; j < k+1; j++) {
                //不选当前sum[i-1]
                int temp1= ints[i-1][j];
                int temp2=0;
                //选当前sum[i-1]，则当前sum[i-1]后，剩下的容量：j-nums[i-1]，这时ints[i-1][j-nums[i-1]]为最大。
                if (j>=nums[i-1]){
                    temp2 =ints[i-1][j-nums[i-1]]+nums[i-1];
                }

                if (temp1>temp2){
                    ints[i][j]=temp1;
                }else {
                    ints[i][j]=temp2;
                }

            }
        }
        if (ints[nums.length][k]==k){
            return true;
        }else return false;

    }

}
