package NowCoder;

/**
 * Created by wangchangyuan on 2017/7/10.
 */
 //将数组中的奇数在前，偶数在后
public class AdjustArray {
    public static void main(String[] args){
        int[] a = {1,3,5,7,2,4,6};
        AdjustArray f = new AdjustArray();
        f.reOrderArray2(a);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }

    //方法一 开辟一个新数组，依次存入奇数和偶数
    public void reOrderArray(int[] array){
        int [] a = reOrderArray1(array);
        for(int i=0; i<array.length; i++){
            array[i] = a[i];
        }
    }

    public int[] reOrderArray1(int[] array){
        int len = array.length;
        int[] arr = new int[len];
        int count = 0;
        for(int i=0; i<len; i++){
            if((array[i] & 1) == 1){
                arr[count] = array[i];
                count ++;
            }
        }
        for(int j=0; j<len; j++){
            if((array[j] & 1) == 0){
                arr[count] = array[j];
                count ++;
            }
        }
        return arr;
    }

    //方法二 在原数组中移动奇数偶数
    public void reOrderArray2(int [] array) {
        int len = array.length;
        //i 表示第一个偶数，j表示在i后面的第一个奇数
        int i = 0;
        int j=1;

        while(i<len && j < len){
            if(i > j) j = i;
            if((array[i]&1) == 1)
                i++;
            if((array[j]&1) == 0)
                j++;
            if(i < len && j < len && (array[i]&1) == 0 && (array[j]&1) == 1 && j>i){
                int tem = array[j];
                for(int k=j; k > i; k--){
                    array[k] = array[k-1];
                }
                array[i] = tem;
                i++;
                j++;
            }
        }
    }

    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
