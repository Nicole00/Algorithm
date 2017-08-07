package NowCoder;

/**
 * Created by wangchangyuan on 2017/7/10.
 */
 //整数的二进制表示中1的数量
public class NumberOf1 {
    public static void main(String[] args){
        int n = 33;
        NumberOf1 f = new NumberOf1();
        int count = f.Numberof1(n);
        System.out.println(count);

        int count1 = f.Numberof1_2(n);
        System.out.println(count1);
    }

    public int Numberof1(int n){
        String nToBinary = Integer.toBinaryString(n);
        System.out.println(nToBinary);
        int count = 0;
        for(int i=0; i<nToBinary.length(); i++){
            if(nToBinary.charAt(i) == '1')
                count++;
        }
        return count;
    }

    //位操作
    public int Numberof1_2(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
