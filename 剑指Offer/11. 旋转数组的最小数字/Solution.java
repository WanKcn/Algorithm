class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        if (right == 0)
            return numbers[0];

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (numbers[mid] == numbers[right])
                right--;
            else if (numbers[mid] > numbers[right])
                left = mid + 1;
            else if (numbers[mid] < numbers[right])
                right = mid;
        }

        return numbers[left];
    }

    public static void main(String[] args) {
        
    }
}