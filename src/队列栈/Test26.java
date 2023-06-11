package 队列栈;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 每个右括号都有一个对应的相同类型的左括号。

 示例 1：
 输入：s = "()"
 输出：true

 示例 2：
 输入：s = "({[]})[]{}"
 输出：true

 示例 3：
 输入：s = "(]"
 输出：false
 */

public class Test26 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        boolean flag=true;
        if (s.length()%2!=0){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='('){
                stack.push(c);
            }else if (c=='{'){
                stack.push(c);
            }
            else if (c=='['){
                stack.push(c);
            }


            else if (c==')'){
                Character peek = stack.peek();
                if (peek!=null){
                    if (peek=='('){
                        stack.poll();
                    }else {
                        flag=false;
                        break;
                    }
                }else {
                    return false;
                }

            }
            else if (c=='}'){
                Character peek = stack.peek();
                if (peek!=null){
                    if (peek=='{'){
                        stack.poll();
                    }else {
                        flag=false;
                        break;
                    }
                }else {
                    return false;
                }

            }

            else if (c==']'){
                Character peek = stack.peek();
                if (peek!=null){
                    if (peek=='['&&peek!=null){
                        stack.poll();
                    }else {
                        flag=false;
                        break;
                    }
                }else {
                    return false;
                }

            }

        }

        //栈中，isEmpty():没有元素，返回ture
        if (!stack.isEmpty()){
            return false;
        }
        return flag;
    }


}
