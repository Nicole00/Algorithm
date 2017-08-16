package Test;

import java.util.Scanner;
/**
 * Created by wangchangyuan on 2017/8/15.
 */
public class Huiwen {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] nums = scan.nextLine().split(" ");
        int[] array = new int[n];
        int i = 0;
        for(String num:nums){
            array[i] = Integer.parseInt(num);
            i++;
        }
        int count = tran(array, n);
        System.out.println(count);
    }

    public static int tran(int[] array, int n){
        int start = 0;
        int end = n-1;
        int count = 0; //记录转换次数
        while(start < end){
            if(array[start] < array[end]){
                array[start+1] = array[start] + array[start+1];
                start++;
                count++;
            }
            else
                if(array[start] > array[end]){
                array[end - 1] = array[end] + array[end - 1];
                end--;
                count++;
                }else{
                    start++;
                    end--;
                }
        }
        return count;
    }
}
