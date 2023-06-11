import java.util.*;

/**合并区间
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 示例 1：
 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 示例 2：
 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


 提示：
 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 */

public class Test29 {
    public static void main(String[] args){

        Test29 test29 = new Test29();
        int[][] intervals={{1,4},{0,2},{3,5}};
        int[][] merge = test29.merge(intervals);
        System.out.println(merge);
    }

    public int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if (intervals[i][0]<=intervals[j][0]
                        &&(intervals[i][1]>=intervals[j][0])
                        //&&(intervals[i][1]<=intervals[j][1])
                )
                {
                    if (intervals[i][1]<=intervals[j][1]){
                        intervals[i][1]=intervals[j][1];
                        int[][] delete = delete(intervals, j);
                        intervals=delete;
                        i =-1;
                        break;
                    }else {
                        int[][] delete = delete(intervals, j);
                        intervals=delete;
                        i =-1;
                        break;
                    }

                }
                //[[1,4],[0,2]]
                //[0 [1   4] 8]
                if (intervals[j][0]<=intervals[i][0]
                        &&(intervals[i][0]<=intervals[j][1])
                        )
                {
                    if (intervals[j][1]<=intervals[i][1]){
                        intervals[i][0]=intervals[j][0];
                        int[][] delete = delete(intervals, j);
                        intervals=delete;
                        i =-1;
                        break;
                    }else {
                        intervals[i][0]=intervals[j][0];
                        intervals[i][1]=intervals[j][1];
                        int[][] delete = delete(intervals, j);
                        intervals=delete;
                        i =-1;
                        break;
                    }

                }
            }

        }
        return intervals;
    }

    public int[][] delete(int[][] intervals,int index) {
        int length = intervals.length;
        int[][] arr = new int[length-1][2];
        intervals[index][0]=intervals[length-1][0];
        intervals[index][1]=intervals[length-1][1];
        for (int i = 0; i < intervals.length-1; i++) {
            arr[i][0]=intervals[i][0];
            arr[i][1]=intervals[i][1];
        }
        return arr;
    }


    }
