package 队列栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 整数除法仅保留整数部分。
 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。

思路：栈方法，遇到'*'、'/'时候，
 用：int temp= 栈顶元素*下一个元素
 或者 int temp=栈顶元素/下一个元素。
 然后，将temp重新入栈。
 最后，将栈内所有元素累加即为结果
 如3+2*2+4
 栈内变化。
 [3,2]
 [3,4]
 [3,4,4]

 示例 1：
 输入：s = "3+2*2+4"
 输出：11

 3 2 2 1
 示例 2：
 输入：s = " 3/2 "
 输出：1

 示例 3：
 输入：s = " 3+5/2 "
 输出：5

 * */
public class Test24 {
    public static void main(String[] args) {
        Test24 test24 = new Test24();
        int calculate = test24.calculate("1*10");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        String str = s.replace(" ", "");
        Deque<Integer> stack = new LinkedList<>();
        int[] object1 = getNumber(s, 0);
        int i1 = object1[1];
        stack.push(object1[0]);
        //3-2*2+4
        for (int i = i1; i < s.length(); ) {
            char c = s.charAt(i);
            i++;
            switch (c){
                case '+':
                    //int temp1 = s.charAt(i)-'0';
                    int number1 = getNumber(s, i)[0];
                    stack.push(number1);
                    break;
                case '-':
                    int number2 = getNumber(s, i)[0];
                    stack.push(-number2);
                    break;
                case '*':
                    int number3 = getNumber(s, i)[0];
                    Integer peek3 = stack.peek();
                    stack.poll();
                    int tt3=peek3*number3;
                    stack.push(tt3);
                    break;
                case '/':
                    int number4 = getNumber(s, i)[0];
                    Integer peek4 = stack.peek();
                    stack.poll();
                    int tt4=peek4/number4;
                    stack.push(tt4);
                    break;
            }
            i = getNumber(s, i)[1];
            if (i>=s.length()-1)break;
        }

        int sum=0;
        while (stack.peek()!=null){
            Integer poll = stack.poll();
            sum=sum+poll;
        }

        return sum;
    }
    public int[] getNumber(String str,int i) {
        //str.equals()
        String s="";
        int index=-1;
        for (int j = i; j <str.length(); j++) {
            char c = str.charAt(j);
            if (Character.isDigit(c)){
                s=s+c;
            }else {
                index=j;
                break;
            }
            if (j==str.length()-1){
                index=str.length()-1;
            }
        }

        int i1 = Integer.parseInt(s);
        int[] a={i1,index};
        return a;
    }

}
