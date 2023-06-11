package 找到子数组和大于K;

import java.util.ArrayList;

/**找到数组和>=K的子数组的长度
 描述
 给定一个长度为 n 的整数数组，和一个目标值 k ，请你找出这个整数数组中和大于等于 k 的最短子数组的长度。
 如果不存在和大于等于 k 的子数组则输出 -1。

 示例1
 输入：[2,1,2,3],5
 返回值：2

 示例2
 输入：[2,3,4,5],16
 返回值：-1
*/
public class Test11 {
    public static void main(String[] args) {

    }
    public int shortestSubarray (ArrayList<Integer> nums, int k) {
        // write code here
        int min=0x3f3f3f3f;
        for (int i = 0; i < nums.size(); i++) {
            int end = preValue(nums, k, i);
            if(((end-i+1)<min)&&(end!=-1)){
                min=end-i+1;
            }else {
                return -1;
            }
        }
        return min;
    }
    public int preValue (ArrayList<Integer> nums, int target,int start) {
        // write code here
        int num=0;
        int end=0;
        for (int i = start; i < nums.size(); i++) {
            num=nums.get(i)+num;
            if (num>=target){
                end=i;
            }else {
                end=-1;
            }
        }
        return end;
    }

}