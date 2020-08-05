// 数组生成器 用来生产测试用例

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator() {
    }

    /**
     * 生成一个顺序数组
     *
     * @param n 用户指定数组大小为
     * @return 返回生成的数组
     */
    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    /**
     * 生成长度为n,每个数组范围[0,bound)
     * @param n 生成数组的大小
     * @param bound 生成数的最大边界
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }
}
