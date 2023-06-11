/**
 给定一个整数数组，你需要找出一个连续子数组，将这个子数组升序排列后整个数组都将是升序数组。
 请你找出满足题设的最短的子数组。

 示例1
     输入：[2,6,4,8,10,9,15]
 返回值：5
 说明：只需对 6,4,8,10,9 排序即可得到升序数组

 示例2
 输入：[1,2,3,5,4]
 返回值：2
 说明：
 对 5,4 排序即可得到升序数组
*/
public class Test10 {
    public static void main(String[] args) {
        int[] a={2,6,4,8,10,9,15};
        int unsortedSubarray = findUnsortedSubarray(a);
        System.out.println(unsortedSubarray);
    }
    public static int findUnsortedSubarray (int[] nums) {
        // write code here

        int start=-1;
        int end=-1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]>nums[i+1]){
                if (start==-1){
                    start=i;
                }else {
                    end=i+1;
                }
            }
        }



        return end-start+1;
    }

}