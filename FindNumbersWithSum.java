import java.util.ArrayList;

/**
 * Created by wangchangyuan on 2017/7/3.
 */
public class FindNumbersWithSum {
    public static void main(String[] args){
        int[] a = {1,2,4,7,11,16};
        int sum = 10;
        FindNumbersWithSum f = new FindNumbersWithSum();
        ArrayList<Integer> res = f.FindNumbersWithSum(a, sum);
        //System.out.print(res.get(0));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> num1 = new ArrayList<Integer>();
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        int count = 0; //记录有count对满足和为sum
        int start = 0;
        int end = array.length-1;
        while(start <= end){
            if(array[start] + array[end] > sum) {
                end--;
            }else if(array[start] + array[end] < sum){
                start ++;
            }else{
                count++;
                num1.add(array[start]);
                num2.add(array[end]);
                start++;
                end--;
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(count == 0){
            return result;
        }
        int min = num1.get(0) * num2.get(0);
        int num_min = num1.get(0), num_max = num2.get(0); //记录两个和为sum 的值
        for(int i=1; i<count; i++){
            if(num1.get(i) * num2.get(i) < min){
                min = num1.get(i) * num2.get(i);
                num_min = num1.get(i);
                num_max = num2.get(i);
            }
        }
        result.add(num_min);
        result.add(num_max);
        return result;
    }
}
