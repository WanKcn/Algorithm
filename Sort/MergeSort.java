import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 递归函数
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
//        int mid2 = (r + l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 合并区间 arr[l...mid],arr[mid+1...r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        // 复制一份元素组用于排序，Arrays.copyOfRange()是一个闭区间[] 所以需要复制[l,r+1)
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1; // i和j分别指向temp中两端区间的头部
        // 每次都判断arr[i]与arr[j]的大小即temp[i-l]和temp[j-l] l...r区间内
        for (int k = l; k <= r; k++) {
            // i超出中间位置，直接从j中取元素
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("MergeSort", arr);
        }
//        Integer[] arr = {1, 3, 4, 2, 6, 5, 7, 9, 8, 0};
//        MergeSort.sort(arr);
//        for (int n : arr) {
//            System.out.print(n + " ");
//        }
    }
}
