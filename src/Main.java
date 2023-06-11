import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String sql="ffff (123) ffff (12werw21) ffff (32523)" +
                "ffff (435)" +
                "ffff (5efg)" +
                "ffff (wer4fg)" +
                "ffff (gk7g)" +
                "ffff (qwrwq)";
        Pattern compile = Pattern.compile("ffff \\(([0-9]+\\w*)\\)");
        Matcher matcher = compile.matcher(sql);
        int i=2;
        String replace="";
        while (matcher.find()){

            String group = matcher.group(1);
            //String g="ss";
            //String g="\""+group+"\"";
            System.out.println("=="+group);
            sql = sql.replaceAll(group,"\""+group+"\"");
            System.out.println(sql);
        }

    }
}