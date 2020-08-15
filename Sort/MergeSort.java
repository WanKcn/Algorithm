import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    // 递归函数
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
//        int mid2 = (r + l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);

        // 如果mid>mid+1的情况下执行merge
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);

    }

    // 合并区间 arr[l...mid],arr[mid+1...r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        // 保证temp和arr相应元素相同
        System.arraycopy(arr, l, temp, l, r - l + 1);
        // i和j分别指向temp中两端区间的头部
        int i = l, j = mid + 1;
        // 每次都判断arr[i]与arr[j]的大小即temp[i]和temp[j] l...r区间内
        for (int k = l; k <= r; k++) {
            // i超出中间位置，直接从j中取元素
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
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
