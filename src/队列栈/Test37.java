package 队列栈;

import java.util.*;

/**报文解压缩
 为了提升数据传输的效率，会对传输的报文进行压缩处理。
 输入一个压缩后的报文，请返回它解压后的原始报文。
 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。
 注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。

 输入描述：
 输入压缩后的报文：
 1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
 2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
 输出描述
 解压后的原始报文
 注：1）原始报文长度不会超过1000，不考虑异常的情况

 示例
 输入
 3[m2[c]]
 输出
 mccmccmcc
 说明：m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc

 输入
 10[k]2[mn3[j2[op]]]
 输出：kkkkkkkkkkmnjopopjopopjopopmnjopopjopopjopop
      kkkkkkkkkkmnjopopjopopjopopmnjopopjopopjopop

 */

public class Test37 {
    public static void main(String[] args){
        Test37 test37 = new Test37();
        String f = test37.f("3[m2[c]]");
        System.out.println(f);
    }

    public  String f(String str){
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String sc ="";
            if (Character.isDigit(c)){
                String[] arr = getNumber(str, i);
                sc=arr[0];
                int k = Integer.parseInt(arr[1]);
                i=k;
            }else {
                sc =c+"";
            }

            //10[k]2[mn3[j2[op]]]
            if (c!=']'){
                stack.push(sc);
            }else {
                String s="";
                while (true){
                    String poll = stack.poll();
                    if (poll.equals("["))break;
                    s=poll+s;
                }
                String poll = stack.poll();
                int k = Integer.parseInt(poll);
                String add = add(s, k);
                stack.push(add);
            }
        }

        String temp="";
        while (true){
            if (stack.isEmpty())break;
            String poll = stack.poll();
            temp=poll+temp;
        }
        return temp;
    }

    public String add (String str,int k){
        String temp="";
        for (int i = 0; i < k; i++) {
            temp=temp+str;
        }
        return temp;
    }
    public String[] getNumber (String str,int i){
        String[] arr = new String[2];
        String temp="";
        int index=0;
        while (true){
            char c = str.charAt(i);
            if (Character.isDigit(c)){
                temp=temp+c;
                index=i;
                i++;
            }else {
                break;
            }
        }
        arr[0]=temp;
        arr[1]=index+"";
        return arr;
    }




}
