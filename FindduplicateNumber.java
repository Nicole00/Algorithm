package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nicole on 2017/8/23.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class FindduplicateNumber {
    public static void main(String[] args){
        int[] numbers = {4, 3, 1, 0, 2, 5, 3};
        int len = numbers.length;
        int[] duplication = new int[1];
        boolean res = duplicate1(numbers, len, duplication);
        if(res)
            System.out.println(duplication[0]);
        else
            System.out.println(res);
    }


    public static boolean duplicate1(int numbers[],int length,int [] duplication) {  //用hashMap存储
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<length; i++){
            if(map.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            else
                map.put(numbers[i], 1);
        }
        return false;
    }


    //因为数组中的数值都在0到n-1的范围内，所以可以将值作为索引下标去对该索引位置的数据做更改。
    public static boolean duplicate2(int numbers[], int length, int[] deplication){
        int index;
        boolean flag = false;
        for(int i=0; i<length; i++){
            index = numbers[i];
            if(index >= length)
                index -= length;
            if(numbers[index] >= length){
                deplication[0] = index;
                flag = true;
                return flag;
            }
            numbers[index] = numbers[index] + length;
        }
        return flag;
    }
}
