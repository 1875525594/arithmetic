import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01 {
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        //Test01 test01 = new Test01();
        //boolean valid = test01.isValid("){");
        //System.out.println("s1:");
        ArrayList<Callable<Object>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int number1=i;
            int key =i;
            //线程安全。通过单线程分配任务id后，
            boolean add = list.add(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("线程:" + Thread.currentThread().getId() + "="+"进行了" + number1);
                    return 1;
                }
            });
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("==="+list.get(i));
        }
        try {
            //invokeAll唤醒所有线程执行任务
            executorService.invokeAll(list);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==="+list.get(0));

    }



}
interface AA{
 int f(int a);
}

