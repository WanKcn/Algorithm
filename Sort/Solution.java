class Solution {
    public static int singleNumber(int[] nums) {
        int target = 0;
        for (int n : nums)
            target ^= n;
        return target;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 2};
        int target = singleNumber(arr);
        System.out.println(4^1^1);
        System.out.println(4^4);
        System.out.println(2^3^3);

    }
}