package 队列栈;

import java.util.*;

/**字符串解码
 给定一个经过编码的字符串，返回它解码后的字符串。
 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 示例 1：
 输入：s = "3[a]2[bc]"
 输出："aaabcbc"

 示例 2：
 输入：s = "3[a2[c]]"
 输出："accaccacc"

 示例 3：
 输入：s = "2[abc]3[cd]ef"
 输出："abcabccdcdcdef"

 示例 4：
 输入：s = "abc3[cd]xyz"
 输出："abccdcdcdxyz"

 提示：
 1 <= s.length <= 30
 s 由小写英文字母、数字和方括号 '[]' 组成
 s 保证是一个 有效 的输入。
 s 中所有整数的取值范围为 [1, 300]

 思路：使用两个栈，一个存放数字 stackNumber(存数字)，一个存放非数字 stackABC（存放字符串，以及‘[’）
 1，遇到']',先从stackABC陆续出栈进行拼接，直到遇到‘[’停止出栈，得到字符串str，
 2，出栈 stackNumber数字number，进行与str进行number加倍。
 3，加倍完成得到的新字符串，重新存入stackABC。
 4，重复1，2，3，遍历完成，最终stackABC存放的是纯字符串，反向打印出来即可。
 */

public class Test32 {
    public static void main(String[] args){
        Test32 test32 = new Test32();
        String s="3[a]2[bc]";
        String s1 = test32.decodeString(s);
         System.out.println(s1);
    }
    public String decodeString(String s) {
        String ll="";
        Deque<Integer> stackNumber = new LinkedList<>();
        Deque<String> stackABC = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //入栈
            if (Character.isDigit(c)){
                String number = getNumber(s, i);
                int k = Integer.parseInt(number);
                stackNumber.push(k);
                int length = number.length();
                i=i+length-1;
            }else if (c!='['&&c!=']'){//
                String abc = getABC(s, i);
                stackABC.push(abc);
                int length = abc.length();
                i=i+length-1;
            }else if (c=='['){
                stackABC.push("[");
            }


            //出栈
            if (c==']'){
                String temp="";
                while (true){
                    String peek = stackABC.peek();
                    if (!peek.equals("[")){
                        String poll = stackABC.poll();
                        temp=poll+temp;
                    }else {
                        stackABC.poll();//弹出'['
                        Integer number = stackNumber.poll();
                        String add = add(temp, number);
                        stackABC.push(add);//重新存放，保证栈的相对位置。
                        break;
                    }
                }

            }

        }

        //打印
        while (!stackABC.isEmpty()){
            String poll = stackABC.poll();
            ll=poll+ll;
        }

        return ll;
    }

    public String add(String s,int number) {
        String temp="";
        for (int i = 0; i < number; i++) {
            temp=temp+s;
        }
        return temp;
    }
    public String getNumber(String s,int i) {
        String temp="";
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (Character.isDigit(c)){
                 temp =temp+c+"";
            }else {
                break;
            }
        }
        return temp;
    }
    public String getABC(String s,int i) {
        String temp="";
        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);
            if (!Character.isDigit(c)&&c!='['&&c!=']'){
                temp =temp+c+"";
            }else {
                break;
            }
        }
        return temp;
    }

}
