package Test;

import java.util.ArrayList;
/**
 * Created by wangchangyuan on 2017/8/16.
 */
//顺时针打印数组
public class PrintMatrix {
    public static void main(String[] args) {
        int[][] array = {{1}, {2}, {3}, {4}, {5}};
        ArrayList<Integer> res = printMatrix(array);
        System.out.print("[");
        for(int i=0; i<res.size(); i++){
            if(i == res.size()-1)
                System.out.print(res.get(i));
            else
                System.out.print(res.get(i) + ",");
        }



        System.out.println("]");
    }


    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0, bottom = rows-1, left = 0, right = columns-1;
        while(top<=bottom && left <= right){
            for(int i = left; i<=right; i++){         //从左往右打印
                result.add(matrix[top][i]);
            }

            for(int j = top+1; j<=bottom; j++){         //从上往下打印
                result.add(matrix[j][right]);
            }

            if(top != bottom){
                for(int k=right-1; k>=left; k--){           //从右往左打印
                    result.add(matrix[bottom][k]);
                }
            }

            if(right != left)
                for(int h = bottom-1; h>top; h--){         //从下往上打印
                    result.add(matrix[h][left]);
                }
            top++;
            bottom--;
            left++;
            right--;
        }

        return result;
    }

}
