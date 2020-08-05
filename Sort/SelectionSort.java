public class SelectionSort {

    // 算法类不允许产生任何实例
    private SelectionSort() {
    }

    // 有约束的泛型
    public static <E extends Comparable<E>> void sort(E arr[]) {
        // arr[0...i)有序 [i..n）无序
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);

        }
    }

    // 交换数组的两个元素下标位置，必须通过引用来交换
    private static <E> void swap(E arr[], int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for (int n: dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }

//        SelectionSort, n =10000, 0.112853 s
//        SelectionSort, n =100000, 10.795565 s
    }
}
