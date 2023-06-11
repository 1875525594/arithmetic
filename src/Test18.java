import java.util.*;

/**给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:
 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:
 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:
 输入: s = "pw wkpe w"
 输出: 4
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * */
public class Test18 {
    public static void main(String[] args) {
        String s ="anviaj";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int l=0;
        int max=0;

        for ( int i=0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer object = hashMap.get(c);
            if (object==null){
                l++;
            }else {
                //回溯
                i=object+1;
                hashMap.clear();
                l=1;
            }
            if (l>max){
                max=l;
            }
            hashMap.put(s.charAt(i),i);
        }
        return max;
    }

}
