/**最接近的三数之和
 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 返回这三个数的和。
 假定每组输入只存在恰好一个解。

 示例 1：
 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

 示例 2：
 输入：nums = [0,0,0], target = 1
 输出：0

 提示：
 3 <= nums.length <= 1000
 -1000 <= nums[i] <= 1000
 -104 <= target <= 104
 */

public class Test31 {
    public static void main(String[] args){
        Test31 test31 = new Test31();
        int[] nums={0,1,2};
        int i = test31.threeSumClosest(nums, 0);
        System.out.println(i);
    }
    public int threeSumClosest(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <  nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp =nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        int sum = sum(nums, 0);
        int after=0x3f3f3f;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    //[-4,-1,1,2,    6,9,11]  //0
                    int temp1 =nums[i]+nums[j]+nums[k];
                    if (temp1>=target){
                        //int temp2 =nums[i]+nums[j]+nums[k-1];
                        if ((temp1-target)<(target-after)){
                            int compare = compare(sum, temp1, target);
                            sum = compare;
                        }else {
                            //存之前，再次和历史比较历史
                            int compare = compare(sum, after, target);
                            sum=compare;
                        }
                        break;
                    }else {
                        //保存，作为历史记录。
                        after=temp1;
                    }

                }
            }
        }

        int compare = compare(sum, after, target);
        return compare;
    }
    public int threeSumClosest1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <  nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp =nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        int sum = sum(nums, 0);
        int after=0x3f3f3f;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    //[-4,-1,1,2,    6,9,11]  //0
                    int temp =nums[i]+nums[j]+nums[k];
                    int compare = compare(sum, temp, target);
                    sum=compare;
                }
            }
        }

        int compare = compare(sum, after, target);
        return compare;
    }
    public int compare(int sum,int temp, int target) {
        int k1=0;
        int k2=0;
        if (sum>target){
             k1 = sum-target;
        }else {
             k1 = target-sum;
        }

        if (temp>target){
            k2=temp-target;
        }else {
            k2=target-temp;
        }

        if (k1>k2){
            return temp;
        }else {
            return sum;
        }
    }

    public int sum(int[] nums, int index) {
        int k=0;
        k =nums[index]+nums[index+1]+nums[index+2];
        return k;
    }

}
