package Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wangchangyuan on 2017/8/18.
 */
public class CreazyQueue {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());        //有n个人
        int[] array = new int[n];                         //存储n个人的身高
        String[] nums = scan.nextLine().split(" ");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(nums[i]);
        }

        int sum = maxValue(array, n);
        System.out.println(sum);

    }



    //获取队列最大疯狂值
    public static int maxValue(int[] array, int n){
        Arrays.sort(array);         //数组从小到大排序
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(array[n-1]);       //先将最大的值放入队列

        int count = 0;
        int min = 0;
        int max = n-2;
        int number = n - 1;           //还剩多少个数

        if(number%2 == 0){             //剩下偶数个数，左右两边可以对称放
            while(count < (n-1)/2){
                if(count % 2 == 0){       //count为偶数 往当前队列两侧放最小值
                    min = entry_quueue_min(array, queue, min);
                    count++;
                }else{                    //count为奇数，往当前队列两侧放最大值
                    max = entry_quueue_max(array, queue, max);
                    count++;
                }
            }
        }else{                            //还剩奇数个数，最后剩下的数可以放前也可以放后，需要比较
            while(count < (n-1)/2){
                if(count % 2 == 0){
                    min = entry_quueue_min(array, queue, min);
                    count++;
                }else{
                    max = entry_quueue_max(array, queue, min);
                    count++;
                }
            }
            //判断最后剩余的一个数放在最前面还是最后面
            int last_num = array[max];
            int first1 = queue.getFirst();
            int last1 = queue.getLast();
            int sum11 = Math.abs(first1 - last_num);
            int sum22 = Math.abs(last1 - last_num);
            if(sum11 >= sum22)                   //放在前面的差值更大，则将最后一个数放在前面
                queue.addFirst(last_num);
            else                                 //放在后面的差值更大，则将最后一个数放在后面
                queue.addLast(last_num);
        }
        int sum = 0;                             //对最后的疯狂队列求相邻差的和
        for(int i=0; i<n-1; i++){
            sum += Math.abs(queue.get(i) - queue.get(i+1));
        }
        return sum;
    }


    //将最小值和次小值加入到队列两侧
    public static int entry_quueue_min(int[] array, LinkedList<Integer> queue,int index){
        int first = queue.getFirst();
        int last = queue.getLast();
        int sum1 = Math.abs(first - array[index]) + Math.abs(last - array[index + 1]);
        int sum2 = Math.abs(first - array[index + 1] + Math.abs(last - array[index]));
        if(sum1 >= sum2){
            queue.addFirst(array[index++]);
            queue.addLast(array[index++]);
        }else{
            queue.addLast(array[index++]);
            queue.addFirst(array[index++]);
        }
        return index;
    }

    //将最大值和次大值加入到队列两侧
    public static int entry_quueue_max(int[] array, LinkedList<Integer> queue,int index){
        int first = queue.getFirst();
        int last = queue.getLast();
        int sum1 = Math.abs(first - array[index]) + Math.abs(last - array[index - 1]);
        int sum2 = Math.abs(first - array[index - 1] + Math.abs(last - array[index]));
        if(sum1 >= sum2){
            queue.addFirst(array[index--]);
            queue.addLast(array[index--]);
        }else{
            queue.addLast(array[index--]);
            queue.addFirst(array[index--]);
        }
        return index;
    }

}
