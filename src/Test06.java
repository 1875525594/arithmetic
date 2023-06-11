/** 相关企业
 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 ，标点符号和普通字母一样处理。
 例如输入字符串"I am a student. "，则输出"student. a am I"。
*/
public class Test06 {
    public static void main(String[] args) {
        String str ="Let's take LeetCode contest";
        String s = reverseWords(str);
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        String temp ="";
        String ss="";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)==' '){
                String reverse = reverse(temp);
                ss=ss+reverse+" ";
                temp="";
            }else if (i==(s.length()-1)){
                temp=temp+s.charAt(s.length()-1);
                String reverse = reverse(temp);
                ss=ss+reverse;
            }else {
                temp=temp+s.charAt(i);
            }

        }
        return ss;
    }
    public static String reverse(String s) {
        String temp="";
        for (int i = s.length()-1; i >= 0; i--) {
            temp=temp+s.charAt(i);
        }
        return temp;
    }

}