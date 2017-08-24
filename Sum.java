
import java.util.Scanner;
/**
 * Created by Nicole on 2017/8/24.
 */
public class Sum {
    public static void main(String[] args){
//        int n = 5;
//        System.out.println(Sum_Solution(n));

        Scanner scan = new Scanner(System.in);
        while(true){
            int a = Integer.parseInt(scan.nextLine());
            int b = Integer.parseInt(scan.nextLine());
            System.out.println(Add(a, b));
        }

    }

    /*
     * 求1+2+3+...+n
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public static int Sum_Solution(int n){
        int a = n;
        boolean bool_Res = (a != 0) && ((a = a+Sum_Solution(n-1))!= 0);
        return a;
    }

    /*
    *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public static int Add(int a, int b){ //转换为二进制，利用异或和与运算求和
        if((a & b) == 0)
            return (a ^ b);
        else{
            return Add(a^b, (a&b) << 1);
        }
    }

}
