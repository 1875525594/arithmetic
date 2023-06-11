import java.util.*;

/**关联端口组合并
  时间限制:1s空间限制: 256MB 限定语言:不限
 题目描述:
 有M (1<=M<=10)个端口组，每个端口组是长度为N(1<=N<=100)的整数数组，
 如果端口组间存在2个及以上不同端口相同，则认为这两个端口组互相关联，可以合并。
 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组，输出合并后的端口组用二维数组表示

 输入描述:
 端口组内数字可以重复
 输出描述:
 1.组内相同端口仅保留一个，从小到大排序
 2.组外顺序保持输入顺序
 补充说明:
 M，N不再限定范围内，统一输出一组空数组[[]]


 * 示例1
 输入:
 4
 4
 2,3,2
 1,2
 5
 输出:[[4],[2,3],[1,2],[5]]
 说明:仅有一个端口2相同，不可以合并

 * 示例2
 输入:
 3
 2,3,1
 4,3,2
 5
 输出:[[1,2,3,4],[5]
 说明:
 存在两个2,3有交集，可以合并

 示例3
 输入:
 6
 10
 4,2,1              2,4   1 2 3 4 6 9
 9
 3,6,9,2            3,6   2 3 4 6 9
 6,3,4
 8
 输出:[[10],[1,2,3,4,6,9],[9],[8]]

 示例4
 输入:
 11
 输出:[[]]
 说明:11超出范围，输出[[]]


 解题思路:
 1.将输入的组合转化为set集合 (有去重和排序的功能)，加入list集合中
 2.每输入一个组合，则对list进行遍历，找出其中有两个并集的集合进行合并，合并完加入原来list集合中。再次执行步骤2
 注意:两个集合合并后，是合并到靠前的那个集合，同时删除靠后的那个集合(题目要求组外保持输入顺序)
 */

public class Test27 {
    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);

        //二维数组, 外层用list保存, 内层用set集合保存, set集合有去重和排序的功能,
        //每输入一个组合, 对list进行遍历, 找出其中有两个并集的集合进行合并

        String numStr = myScanner.nextLine();
        int m = Integer.parseInt(numStr);
        if(m > 10) System.out.println("[[]]");

        else {
            List<Set<Integer>> list = new LinkedList<>();
            //myScanner.nextLine();//读取行

            //循环
            for(int i = 0; i < m; i ++ ) {
                String[] strings = myScanner.nextLine().split(",");//读取行 分成zi字符串数组strings
                int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();//转换成字符串数组nums

                Set<Integer> set = new TreeSet<>();

                if(nums.length == 1 ) {//只有一个元素, 直接添加
                    set.add(nums[0]);
                    list.add(set);//加入list
                } else {
                    for(int num : nums) {
                        set.add(num);//数字加到set集合中
                    }
                    list.add(set);//这个新的set加到list, 默认加到最后
                    merge(set, list, list.size() - 1 );//看是否需要合并set和list内的set
                }
            }

            System.out.println(list);//输出结果
        }


    }

    public static void merge(Set<Integer> set, List<Set<Integer>> list, int index) {
        for(int i = 0; i < list.size(); i ++ ) {//遍历list中的每个set
            if(i == index) continue;//如果是相同 就不继续了

            Set<Integer> setIdx = list.get(i);//当前索引的set集合
            Set<Integer> setTemp = new TreeSet<>();
            setTemp.addAll(set);//临时集合 保存交集
            setTemp.retainAll(setIdx);//待判断的set和当前的setIdx的交集, 返回交集
            //当交集>=2 则需要合并
            if(setTemp.size() >= 2) {
//                set.addAll(setIdx); //把新传入的set与setIdx合并
//                list.remove(i);//两个都移除后
//                list.remove(index);
//                int st = i < index ? i : index;//存靠前的下标
//                list.add(st, set);//加上并集set 在st位置

                //存靠前的下标
                int preIndex = i < index ? i : index;
                //删除靠前的下标
                int postIndex = i > index ? i : index;
                //将后面的set合并到前面那个set
                Set<Integer> preSet = list.get(preIndex);
                preSet.addAll(list.get(postIndex));
                list.remove(postIndex);
                //新建的组合再进行判断合并, 因为合并之后，前面的set可能会与新合并的集合再次合并
                merge(preSet, list, preIndex);
            }
        }
    }


}
