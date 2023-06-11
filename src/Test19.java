import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**滑动窗口： 找到字符串中所有字母异位词
 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 示例 1:
 输入: s = "cbaebabacd", p = "abc"
 输出: [0,6]
 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

 示例 2:
 输入: s = "abab", p = "ab"
 输出: [0,1,2]
 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * */
public class Test19 {
    public static void main(String[] args) {
        String s ="abab";
        String p ="ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int pL = p.length();
        int[] arrS = new int[26];
        int[] arrP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int k = p.charAt(i)-'a';
            arrP[k]++;
        }
        // abab
        // ab

        //初始化窗口
        for (int i = 0; i < s.length()-pL+1; i++) {
            int temp=i;
            //窗口初始化
            for (int j = i; j < i+pL; j++) {
                int k = s.charAt(j)-'a';
                arrS[k]++;
            }

            //窗口内判断
            for (int j = i; j < i+pL; j++) {
                int k = s.charAt(j)-'a';
                if (arrS[k]!=arrP[k]){
                    break;
                }
                //最后一个比较完，还是没有触发break，加入list
                if (j==i+pL-1){
                    list.add(temp);
                }
            }

            //清空窗口
            for (int j = i; j < i+pL; j++) {
                int k = s.charAt(j)-'a';
                arrS[k]=0;
            }

        }
        return list;
    }

}
