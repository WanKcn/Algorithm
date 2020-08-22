import java.util.*;

// 交换数组中部的第n大和第m大数

public class Solution {
    /**
     * @param a int整型一维数组 原始数组a
     * @param n int整型 第n大
     * @param m int整型 第m大
     * @return int整型一维数组
     */
    public int[] sovle(int[] a, int n, int m) {
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        int temp1 = 0, temp2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[a.length - n])
                temp1 = i;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[a.length - m])
                temp2 = i;
        }

        swap(a, temp1, temp2);

        return a;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
