package NowCoder;
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
/**
 * Created by wangchangyuan on 2017/7/10.
 */
public class Power {
    public static void main(String[] args){
        double base = 5.0;
        int exp = 5;
        double result = Power.power1(base, exp);
        System.out.println(result);
    }

    public double power(double base, int exp){
        if(Math.abs(base - 0) < 0.000001)
            return 0;
        if(exp == 0 || Math.abs(base - 1) <0.00001)
            return 1;
        double result = 1;
        if(exp > 0){
            for(int i = 0; i<exp; i++){
                result *= base;
            }
        }else{
            for(int i = 0; i<(-exp); i++){
                result *= 1/base;
            }
        }
        return result;
    }

    public static double power1(double base, int exp){
        int exp1 = exp < 0? -exp : exp;
        double res = 1.0;
        while(exp1 != 0){
            if((exp1 & 1) == 1)
                res *= base;
            base *= base;
            exp1 >>= 1;
        }
        return exp > 0? res: 1/res;
    }
}
