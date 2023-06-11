package 队列栈;

import java.util.*;

/**找最小数
 给一个正整数NUM1，计算出新正整数NUM2，NUM2为NUM1中移除N位数字后的结果，需要使得NUM2的值最小。 输入描述：
 1.输入的第一行为一个字符串，字符串由0-9字符组成，记录正整数NUM1，NUM1长度小于32。
 2.输入的第二行为需要移除的数字的个数，小于NUM1长度。
 如：
 2615371
 4
 输出描述：
 输出一个数字字符串，记录最小值NUM2。
 如：131

 29134
 3
 13

 99991
 3
 13

 12345

 题解：
 用一个单调非递减栈，依次将数字压入，如果即将压入的数字比栈里面顶层的数字小就把顶层数字删掉继续比较，
 直到当前数字大于等于栈顶数字或者栈为空，同时维护一个数字记录删除的数字个数是否符合题目要求。

 */

public class Test36 {
    public static void main(String[] args) {
        Test36 test36 = new Test36();
        String f = test36.f("12345", 3);
        System.out.println(f);
    }
    public  String f(String str,int n) {
        //Stack<Integer> stack = new Stack<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String sc = c+"";
            int x = Integer.parseInt(sc);
            if (stack.isEmpty()||x>=stack.peek()){
                stack.push(x);
            }else {
                //2615371
                // 4
                while (true){
                    Integer peek = stack.peek();
                    if (peek!=null&&peek>x&&n>0){
                        stack.poll();
                        n--;
                    }else {
                        stack.push(x);
                        break;
                    }
                }
            }

        }


        while (true){
            if (n==0)break;
            Integer poll = stack.poll();
            n--;
        }

        String ss="";
        while (true){
            Integer poll = stack.poll();
            ss=poll+ss;
            if (stack.isEmpty())break;
        }
        return ss;
    }

}
