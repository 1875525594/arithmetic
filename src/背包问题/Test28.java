package 背包问题;

import java.util.*;

/**完全背包
 单词拆分
 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出s。
 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

 示例 1：
 输入: s = "leetcode", wordDict = ["leet", "code"]
 输出: true
 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

 示例 2：
 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 输出: true
 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 注意，你可以重复使用字典中的单词。

 示例 3：
 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 输出: false
 */

public class Test28 {
    public static void main(String[] args) {
        String s="a";
        ArrayList<String> list = new ArrayList<>();
//        list.add("lee");
//        list.add("tc");
//        list.add("leet");
//        list.add("code");
        list.add("a");
        boolean b = wordBreak1(s, list);
        System.out.println(b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



    public static boolean wordBreak1(String s, List<String> wordDict) {
        //dp[i]含义：字符串的长度为i-1,
        //如果dp[j]=ture,说明在s的坐标在0~（j-1），在wordDict里面能直接找到或者能拼接。
        //如：
        //s   = leetcode
        //dp[]= fftttfft
        //wordDict = lee tc leet code
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i < dp.length; i++) {
            dp[i]=false;
        }
        //leetcode
        //lee  tc  leet code le tcode e
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j<=i; j++) {
                //substring为: [ )
                String substring = s.substring(j, i+1);
                if (dp[j]&&wordDict.contains(substring)){
                    dp[i+1]=true;
                }
            }
        }
        return dp[s.length()];
    }

}
