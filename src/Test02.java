import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test02 {
    public static void main(String[] argss) {
        String[] words = {"apple","pleas","please"};
        String[] puzzles  = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};
        int aelpxyz = getBitMask("aelwxyz", 0);
        ArrayList<Integer> subset = getSubset(aelpxyz);
        int apple = getBitMask("apple", 0);

        System.out.println(subset);
        System.out.println(apple);

    }

    //获取子集
    private static ArrayList<Integer>  getSubset(int word) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (true){
            int temp =-word&word;
            if (arr.size()>0){
                for (int i = 0; i <arr.size(); i++) {
                    int tt=arr.get(i)|temp;
                    //去空集，去重复子集
                    if (tt!=0&&arr.get(i)!=tt){
                        arr.add(tt);
                    }
                }
            }
            arr.add(temp);
            word=word-temp;
            if (word==0)break;
        }
        return arr ;
    }

    //转二进制
    private static int getBitMask(String word,int k) {
        /*
         a  1
         ab  11
         ac  101
         acd 1101
        * */
        int mask = 0;
        for (int i = k; i < word.length(); i++) {
            char ch = word.charAt(i);
            mask = mask | (1 << (ch - 'a'));
        }
        return mask;
    }


}
