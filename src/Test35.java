import java.util.*;

/**服务失效判断
 题目描述：
 某系统中有众多服务，每个服务用字符串（只包含字母和数字，长度<=10）唯一标识，服务间可能有依赖关系，如A依赖B，则当B故障时导致A也故障。
 依赖具有传递性，如A依赖B，B依赖C，当C故障时导致B故障，也导致A故障。
 给出所有依赖关系，以及当前已知故障服务，要求输出所有正常服务。
 依赖关系：服务1-服务2  表示“服务1”依赖“服务2”
 不必考虑输入异常，用例保证：依赖关系列表、故障列表非空，且依赖关系数，故障服务数都不会超过3000，服务标识格式正常。
 输入描述:
 半角逗号分隔的依赖关系列表（换行）
 半角逗号分隔的故障服务列表

 输出描述:
 依赖关系列表中提及的所有服务中可以正常工作的服务列表，用半角逗号分隔，按依赖关系列表中出现的次序排序。
 特别的，没有正常节点输出单独一个半角逗号。

 示例1
 输入
 a1-a2,a5-a6,a2-a3,a4-a1
 a5,a2
 输出
 a6,a3
 说明
 a1依赖a2，a2依赖a3，所以a2故障，导致a1不可用，但不影响a3；a5故障不影响a6。所以可用的是a3、a6，
 在依赖关系列表中a6先出现，所以输出:a6,a3

 示例2
 输入
 a1-a2
 a2
 输出
 ,
 说明
 a1依赖a2，a2故障导致a1也故障，没有正常节点，输出一个逗号
 */

public class Test35 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String yanbeng = scanner.nextLine();
        String guzhang = scanner.nextLine();

        String[] yanbengArr = yanbeng.split(",");
        String[] guzhangArr = guzhang.split(",");
        ArrayList<String> guzhanglist = new ArrayList<>();
        for (int i = 0; i < guzhangArr.length; i++) {
            guzhanglist.add(guzhangArr[i]) ;
        }

        HashSet<String> set = new HashSet<>();
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        for (int i = 0; i <yanbengArr.length; i++) {
            String s = yanbengArr[i];
            String[] split = s.split("-");
            set.add(split[0]);
            set.add(split[1]);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(split[1],split[0]);
            arrayList.add(hashMap);
        }

        for (int i = 0; i < guzhanglist.size(); i++) {
            for (int j = 0; j < arrayList.size(); j++) {
                HashMap<String, String> hashMap = arrayList.get(j);
                String s = hashMap.get(guzhanglist.get(i));
                set.remove(guzhanglist.get(i));
                set.remove(s);
                if (s!=null)guzhanglist.add(s);
            }
        }

        for (String s:set){
            System.out.println(s+" ");
        }

    }


}
