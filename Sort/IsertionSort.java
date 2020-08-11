import java.util.Arrays;

public class IsertionSort {
    private IsertionSort() {
    }

    private static <E> void swap(E arr[], int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0)
//                    swap(arr, j, j - 1);
//                else
//                    break;
//            }
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--)
                swap(arr, j, j - 1);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 进行暂存
            E temp = arr[i];
            // 实际存储位置
            int j;
//            for (j = i; j - 1 >= 0; j--) {
//                if (temp.compareTo(arr[j - 1]) < 0)
//                    arr[j] = arr[j - 1];
//                else
//                    break;
//            }
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        // [0..i) 未排序，[i,n)已排序
        for (int i = arr.length - 1; i >= 0; i--) {
            // 进行暂存
            E temp = arr[i];
            // 实际存储位置
            int j;
//            for (j = i; j + 1 < arr.length; j++) {
//                if (temp.compareTo(arr[j + 1]) > 0)
//                    arr[j] = arr[j + 1];
//                else
//                    break;
//            }
            for (j = i; j + 1 < arr.length && temp.compareTo(arr[j + 1]) > 0; j++)
                arr[j] = arr[j + 1];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2, 4, 6, 5, 1, 0, 8, 7, 9};
//        IsertionSort.sort(arr);
//        for (int n : arr)
//            System.out.print(n + " ");

        int[] dataSize = {1000, 10000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("IsertionSort", arr);
            SortingHelper.sortTest("IsertionSort2", arr2);
        }

//        IsertionSort, n =1000, 0.010389 s
//        IsertionSort2, n =1000, 0.005747 s
//        IsertionSort, n =10000, 0.223931 s
//        IsertionSort2, n =10000, 0.134732 s
    }
}
