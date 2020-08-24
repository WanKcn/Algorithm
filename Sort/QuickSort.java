import java.util.Arrays;
import java.util.Random;

public class QuickSort {


    private QuickSort() {
    }


    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1,rnd);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r,Random rnd) {

        if (l >= r)
            return;
        int p = partition(arr, l, r,rnd);
        sort(arr, l, p - 1,rnd);
        sort(arr, p + 1, r,rnd);
    }

    public static <E extends Comparable<E>> int partition(E arr[], int l, int r,Random rnd) {

        int p = l +rnd.nextInt(r - l + 1);
        swap(arr, l, p);
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }

        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E arr[], int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
//        Integer a[] = {1, 3, 6, 8, 4, 2, 0, 2};
//        sort(a);
//        for (Integer n : a)
//            System.out.print(n + " ");
        int[] dataSize = {1000, 10000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("QuickSort", arr);
            SortingHelper.sortTest("IsertionSort", arr2);
        }
    }

}
