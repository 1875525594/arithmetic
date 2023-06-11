import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] ints = f(4, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }
    public static int[] f(int n,int m  ) {
        Scanner scanner = new Scanner(System.in);
        int[] k = new int[n];
        int j=0;
        while (scanner.hasNextInt()){
            int i = scanner.nextInt();
            k[j]=i;
            j++;
            if (j>=n)break;
        }
        int sum=0;

        //排序 小——>大
        for (int i = 0; i < k.length; i++) {
            for (int l = 0; l < k.length-1; l++) {
                if (k[l+1]<k[l]){
                    int temp = k[l+1];
                    k[l+1]=k[l];
                    k[l]=temp;
                }
            }
        }

        /*
        1 m
        1 2 m
        1 2 3 m
        1 2 3 4 m
        */
        for (int i = 0; i < k.length-1; i++) {
            sum =k[i]+sum;
            //平均值大于后一根，需要平衡,则继续累加下一根
            if ( ((sum+m)/(i+1)) >k[i+1]){
            }else {
                int temp=(sum+m)/(i+1);
                for (int l = 0; l < i + 1; l++) {
                    k[l]=temp;
                }
            }
        }

        return k;

    }

}
