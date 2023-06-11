import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 砖墙
 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回穿过的砖块数量 。

 示例 1：
 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 输出：2

 示例 2：
 输入：wall = [[1],[1],[1]]
 输出：3
 * */
public class Test21 {
    public static void main(String[] args) {

    }
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hashMap = toArr(wall);
        int max=0;
        for (int k:hashMap.values()){
            if (k>max){
                max=k;
            }
        }
        max = wall.size()-max;
        return max ;
    }
    public HashMap<Integer, Integer> toArr(List<List<Integer>> wall) {
        int max=0;
        //[1,2,2,1],
        //[3,1,2],
        //[1,3,2],
        //[2,4],
        //[3,1,2],
        //[1,3,1,1]
        //--->间隙位置,查找间隙最多相同的数字即可
        //[1,3,5],
        //[3,4],
        //[1,4],
        //[2],
        //[3,4],
        //[1,4,5]
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < wall.size(); i++) {
            int temp=0;
            for (int j = 0; j < wall.get(i).size()-1; j++) {
               temp=temp+ wall.get(i).get(j);
               if (hashMap.get(temp)!=null){
                   Integer count = hashMap.get(temp);
                   count++;
                   hashMap.put(temp,count);
               }else {
                   hashMap.put(temp,1);
               }

            }

        }

        return hashMap;
    }

}
