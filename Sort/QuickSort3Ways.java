import java.util.Arrays;
import java.util.Random;

public class QuickSort3Ways {


    private QuickSort3Ways() {
    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {

        if (l >= r)
            return;
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        sort(arr, l, lt - 1, rnd);
        sort(arr, gt, r, rnd);

    }


    private static <E> void swap(E arr[], int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Integer a[] = {1, 3, 6, 8, 4, 2, 0, 2};
        sort(a);
        for (Integer n : a)
            System.out.print(n + " ");
        System.out.println();
        int[] dataSize = {1000, 10000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("QuickSort", arr);
            SortingHelper.sortTest("QuickSort3Ways", arr2);
        }
    }

}
