public class Sum {

    // 用户操作的函数
    public static int sum(int[] arr) {
        // 递归的初始调用是从0开始到n-1
        return sum(arr, 0);
    }


    // 计算arr【l...n)这个区间所有数字的和 l-(n-1)的和
    // 真正的递归的函数
    private static int sum(int[] arr, int l) {
        // 当左边界l等于数组长度的时候 即整个数组为空的时候
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sum(nums));
    }

}
