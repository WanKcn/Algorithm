class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1; // [l..r]初始化不包含任何元素
        // 初始化最大长度，这是一个永远去不到的值，每次和新的res取最小的那一个
        int res = nums.length + 1;
        int sum = 0; // 存放区间的和
        while (l < nums.length) {

            if (sum < s && r + 1 < nums.length)
                sum += nums[++r]; // 先扩充区间，在计算和
            else
                sum -= nums[l++];  // 先减去做左侧值，再移动l

            if (sum >= s)
                res = Math.min(res, r - l + 1); // 闭区间+1
        }
        if (res == nums.length + 1)
            return 0; // 如果res还是初始化大小，说明不存在这样的子数组
        return res;
    }
}