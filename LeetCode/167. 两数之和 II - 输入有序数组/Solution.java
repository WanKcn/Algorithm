class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                int[] res = {left + 1, right + 1};
                return res;
            } else if (numbers[left] + numbers[right] < target)
                left++;
            else
                right--;

        }
        return null;

    }
}