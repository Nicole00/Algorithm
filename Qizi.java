
import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by wangchangyuan on 2017/8/21.
 */
public class Qizi {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] xx = scan.nextLine().split(" ");
        String[] yy = scan.nextLine().split(" ");
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++){
            x[i] = Integer.parseInt(xx[i]);
            y[i] = Integer.parseInt(yy[i]);
        }

        int k = 1;
        int sum = 0;

        while(k <= n){
            if(k == 1){
                System.out.print("0 ");
            }else
                if(k < n){
                sum = sum(n, k, x, y);
                System.out.print(sum + " ");
            }
            if(k == n){
                sum = sum1(n, x, y);
                System.out.println(sum);
            }
            k++;
        }
    }

    public static int sum(int n, int k, int[] x, int[] y){         //穷举中心点
        int[] sums = new int[n*n];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){           //最外两层用于找到每个中心点的坐标
                int[] array = new int[n];      //存放每个棋子格子与中心点的距离
                for(int l=0; l<n; l++){
                    array[l] = Math.abs(x[l] - i) + Math.abs(y[l] - j);
                }
                Arrays.sort(array);            //array存放的n个棋子分别到中心点的距离，对其进行排序，取最小的k个相加
                sums[count] = SUM(array, k);
                count++;
            }
        }
        Arrays.sort(sums);
        return sums[0];
    }

    public static int SUM(int[] array, int k){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += array[i];
        }
        return sum;
    }


    public static int sum1(int n, int[] x, int[] y){         //k即为n, 中心点不需要遍历
        int x1 = x[(n+1)/2];
        int y1 = y[(n+1)/2];
        int sum = 0;
        for(int i=0; i<x.length; i++){
            sum += Math.abs(x[i] - x1) + Math.abs(y[i] - y1);
        }
        return sum;
    }
}
