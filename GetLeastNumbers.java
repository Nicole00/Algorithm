import java.util.ArrayList;

/**
 * Created by wangchangyuan on 2017/7/3.
 */
// 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。采用partition方法

public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] input = {9, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        GetLeastNumbers g = new GetLeastNumbers();
        ArrayList<Integer> out = g.GetLeastNumbers_Solution(input, k);
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i));
        }

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        int len = input.length;
        if (input == null) {
            return null;
        }
        if (k <= 0 || k > input.length) {
            return null;
        }
        if (len == k) {
            for (int i = 0; i < len; i++) {
                out.add(input[i]);
            }
            return out;
        }

        int start = 0;
        int end = len - 1;
        int index = partition(input, start, end);
        while (index != k) {
            if (index > k) {
                end = index - 1;
                index = partition(input, start, end);
            }
            if (index < k) {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for (int j = 0; j < index; j++) {
            out.add(input[j]);
        }
//        return GetLeastNumbers_Solution1(input, 0, input.length-1, k);
        return out;
    }


    private static int partition(int[] a, int start, int end) {
        int nPos = start;
        for (int i = start + 1; i < end; i++) {
            if (a[i] < a[start]) {
                nPos++;
                swap(a, i, nPos);
            }
        }
        swap(a, nPos, start);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
        return nPos + 1;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}