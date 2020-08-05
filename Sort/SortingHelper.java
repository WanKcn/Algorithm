// 辅助排序算法的类
public class SortingHelper {

    private SortingHelper() {
    }

    // 判断一个数组是否是有序的
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    // 测试一个排序算法
    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        long starTime = System.nanoTime();
        if (sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
//            SelectionSort.sort2(arr);
        long endTime = System.nanoTime();
        double time = (endTime - starTime) / 1000000000.0;
        // 非有序抛运行时异常
        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + "failed");
        System.out.println(String.format("%s, n =%d, %f s",sortname,arr.length,time));
    }
}
